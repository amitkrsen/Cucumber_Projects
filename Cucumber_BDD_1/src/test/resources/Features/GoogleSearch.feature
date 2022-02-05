Feature: Feature to test Google search functionality

	@GoogleSearch
  Scenario: Validate Google search is working as expected
    Given Browser is open
    And User is on the Google search page
    When User provides the text in the search box
    And Press the enter button
    Then Page displays the search results