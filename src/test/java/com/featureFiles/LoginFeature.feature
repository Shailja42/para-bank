@tag
Feature: Login

  @tag1
  Scenario: Login with user details
    Given I launch the application
    And I enter the user details and navigate to home page
    When I search for the product 
    Then I should land of list of product page