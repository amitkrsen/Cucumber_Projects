@SmokeScenarios
Feature: Feature to test Login functionality
	@SmokeTest
  Scenario: Check login is successfull with valid credentials
    Given User is on login page
    When User provides valid username and password
    And Clicks on Login button
    Then User land on the home page

  Scenario Outline: Check login is successfull with valid credentials
    Given User is on login page
    When User provides valid <username> and <password>
    And Clicks on Login button
    Then User land on the home page

    Examples: 
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
