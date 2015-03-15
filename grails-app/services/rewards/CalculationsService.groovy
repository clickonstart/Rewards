package rewards

import grails.transaction.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {
		def totalPoints = params.points.toInteger()
		def firstName = params.first
		def welcomeMessage = ""
		
		
		switch(totalPoints)
		{
			case 5:
				welcomeMessage = "Welcome back $firstName, this drink is on us."
				break
			case 4:
				welcomeMessage = "Welcome back $firstName, your next drink will be free."
				break
			case 2..3:
				welcomeMessage = "Welcome back $firstName, you now have $totalPoints points."
				break
			default:
				welcomeMessage = "Welcome $firstName.  Thanks for registering"
		}
    }
	
	def getTotalPoints(customerInstance)
	{
		def totalAwards = 0
		customerInstance.awards.each
		{
			totalAwards = totalAwards + it.points
		}
		
		customerInstance.totalPoints = totalAwards
		return customerInstance
	}
	
	def processCheckin(lookupInstance)
	{
		if(lookupInstance == null)
		{
			//This is a new call to the kiosk form.  No data was entered by a user yet.
			return [null, null]
		}
		else
		{
			//Query customer by phone number
			def customerInstance = Customer.findByPhone(lookupInstance.phone)
			
			// If no results
			//	Create a new customer
			if(customerInstance == null)
			{
				customerInstance = lookupInstance
				customerInstance.firstName = "Customer"
			}
			
			//Get customer's total points
			def totalAwards = 0
			customerInstance.awards.each
			{
				totalAwards = totalAwards + it.points
			}
			customerInstance.totalPoints = totalAwards
					
			// 	Create welcome message
			def welcomeMessage = ""
			switch(totalAwards)
			{
				case 5:
					welcomeMessage = "Welcome back $customerInstance.firstName, this drink is on us."
					break
				case 4:
					welcomeMessage = "Welcome back $customerInstance.firstName, your next drink will be free."
					break
				case 1..3:
					welcomeMessage = "Welcome back $customerInstance.firstName, you now have ${totalAwards + 1} points."
					break
				default:
					welcomeMessage = "Welcome $customerInstance.firstName.  Thanks for registering"
			}
			// 	Add award record
			if(totalAwards < 5)
			{
				customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
			}
			else
			{
				customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
			}
			
			// 	Save customer
			customerInstance.save(flush:true)
			
			// 	Send welcome to kiosk
			return [customerInstance, welcomeMessage]
		}
	}
}
