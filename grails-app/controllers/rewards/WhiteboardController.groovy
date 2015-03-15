package rewards

class WhiteboardController {
	def calculationsService

    def index() { }
	
	def variables()
	{
		def myTotal = 1
		render("Total: " + myTotal)
		render("<br>" + myTotal.class)
		myTotal = myTotal + 1
		render("<br>New Total: " + myTotal + "<br>")
		
		def firstName = "Mike"
		render("<br>Name:" + firstName)
		render("<br>" + firstName.class)
		firstName = firstName + 1
		render("<br>New First Name: " + firstName + "<br>")
		
		def today = new Date("2/1/2015")
		render("<br>Today is : " + today)
		render("<br>" + today.class)
		today = today + 1
		render("<br>New today: " + today + "<br>")
	}
	
	def strings()
	{
		def first = "Mike"
		def last = "Smith"
		def fullName = first + " " + last
		def input = "SHOUTING"
		def points = 4
		
		render "Your string, $fullName, has ${fullName.length()} characters in length"
		render "<br>Please stop ${input.toLowerCase()}."
	}
	
	def conditions()
	{
		def welcomeMessage = calculationsService.welcome(params)
		
		render welcomeMessage
	}
}
