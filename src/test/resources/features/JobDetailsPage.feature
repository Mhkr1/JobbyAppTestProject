Feature: Job Details Page
  As a user, I seek an efficient job search functionality
  to find relevant opportunities.

  Scenario: Test the UI elements of job details page
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And Find jobs button should be visible
    And Click the find jobs button
    And I should be navigated to that find jobs page
    When I search for "Devops Engineer" job
    And I click on one job in the page
    Then I should be redirected to that job details page
    And company image should be visible
    And job title should be visible
    And job rating should be visible
    And location should be visible
    And employment type should be visible
    And job details description should be visible
    And check skills visible or not
    And life inside company should be visible
    And Similar movie should be visible
