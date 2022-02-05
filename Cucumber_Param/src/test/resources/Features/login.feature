Feature: Test Login feature of Edureka portal

  @SmokeTest
  Scenario Outline: Edureka prtal login with valid credentials
    Given Users opens the browser
    And Navigate to the Edureka portal
    When User provides the <email> and <password>
    And Clicks of the Login button
    Then User land on the My Course page
    And Logout from the portal successfully

    Examples: 
      | email                   | password     |
      | amit.kr.sen21@gmail.com | amitsen@8891 |
