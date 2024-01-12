Feature: Home Page
  As a user, I desire a streamlined process to
  access comprehensive job-related information,
  facilitating efficient searching and viewing of job details.


  Scenario: Test the Homepage Heading
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I am on home page home heading should be visible
    Then the home description should be visible
    And Find jobs button should be visible


  Scenario: Test the Find Jobs button functionality
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I am on home page home heading should be visible
    And the home description should be visible
    And Find jobs button should be visible
    When Click the find jobs button
    Then I should be navigated to that find jobs page