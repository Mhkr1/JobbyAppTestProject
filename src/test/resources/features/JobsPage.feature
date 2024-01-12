Feature: Testing Jobs page functionality
  As a user, I demand a visually appealing and user-friendly login page
  to facilitate easy access to the application.


  Scenario: Test the Profile Container UI
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I click jobs link on navbar
    And I should be redirected to the jobs page
    Then The profile image should be displayed
    And  The profile name text should be displayed
    And The short bio text should be displayed


    Scenario: Test the navigation to job details page in job page
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



    Scenario: Test the Successful Search
      Given I am on the login page
      And I enter valid username as 'rahul'
      And I enter valid password as 'rahul@2021'
      And I click the login button
      And I should be redirected to the home page
      And Find jobs button should be visible
      When Click the find jobs button
      Then I should be navigated to that find jobs page
      When I search with multiple job names in search bar
      Then I should get the count of jobs visibled

    Scenario: Test the Unsuccessful Search
      Given I am on the login page
      And I enter valid username as 'rahul'
      And I enter valid password as 'rahul@2021'
      And I click the login button
      And I should be redirected to the home page
      And Find jobs button should be visible
      And Click the find jobs button
      And I should be navigated to that find jobs page
      When Search for the job with the text Netflix
      Then The No Jobs Found image should be visible
      And The No Jobs Found heading text should be visible
      And The No Jobs Found description text should be visible