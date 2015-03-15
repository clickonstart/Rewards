package rewards

class CustomerController {

	static scaffold = true;
	
	def calculationsService
	
	def lookup()
	{		
		//Multiple field example
		def customerInstance = Customer.findAllByFirstNameIlikeAndTotalPointsGreaterThan("b%",2, [sort: "totalPoints", order: "desc"])	
		[customerInstanceList:customerInstance]
	}
	
	def customerLookup(Customer lookupInstance)
	{
		def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)
		render(view: "checkin", model:[customerInstance:customerInstance, welcomeMessage:welcomeMessage])	
	}
	
	def checkin() {}
	
	def index()
	{
		params.max = 5
		[customerInstanceList: Customer.list(params), customerInstanceCount: Customer.count()]
	}
	
	def create()
	{
		[customerInstance: new Customer()]
	}
	
	def save(Customer customerInstance)
	{
		customerInstance.save(flush:true)
		redirect(action: "show", id: customerInstance.id)
	}
	
	def show(Long id)
	{
		def customerInstance = Customer.get(id)
		customerInstance = calculationsService.getTotalPoints(customerInstance)
		[customerInstance: customerInstance]
	}
	
	def edit(Long id)
	{
		def customerInstance = Customer.get(id)
		[customerInstance: customerInstance]
	}
	
	def update(Long id)
	{
		def customerInstance = Customer.get(id)
		customerInstance.properties = params
		customerInstance.save(flush:true)
		redirect(action: "show", id: customerInstance.id)
	}
	
	def delete(Long id)
	{
		def customerInstance = Customer.get(id)
		customerInstance.delete(flush:true)
		redirect(action: "index")
	}
	
	def profile()
	{
		def customerInstance = Customer.findByPhone(params.id)
		[customerInstance:customerInstance]
	}
	
	def updateProfile(Customer customerInstance)
	{
		customerInstance.save(flush:true)
		render(view: "profile", model: [customerInstance:customerInstance])
	}

}
