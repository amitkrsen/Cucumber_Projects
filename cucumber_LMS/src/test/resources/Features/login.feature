Feature: Test Login feature of Edureka LMS Portal

	@SmokeTest
	Scenario Outline: Test Edureka LMS Portal with valid credentials
		Given User opnes the browser
		And Navigate to Edureka LMS Portal
		When User provides the <email> and <password>
		And Clicks on the Login button
		Then User lands on the home page
		And Logout from the portal successfully
		
		Examples:
			| email									  | password		 |
			| amit.kr.sen21@gmail.com | amitsen@8891 |