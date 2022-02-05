#Author
#Date
#Description
@SmokeFeature
Feature: Feature to test Login functionality

  @SmokeTest
  Scenario: Check login is successfull with valid credentials
    Given User is on login page
    When User provides valid username and password
    And Clicks on Login button
    Then User lands on the home page
