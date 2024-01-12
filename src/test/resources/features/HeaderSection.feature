Feature: Header Section
  As a user, I want a seamless and intuitive navigation experience,
  enabling me to effortlessly explore different sections of the application.

  Scenario:Test the headerSection UI elements
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I am on home page home heading should be visible
    Then the app logo image should be visible
    And the home route should be visible
    And the jobs route should be visible
    And logout button should be visible

    Scenario: Test the navigation by clicking the Navbar Jobs link
      Given I am on the login page
      And I enter valid username as 'rahul'
      And I enter valid password as 'rahul@2021'
      And I click the login button
      And I should be redirected to the home page
      When I click jobs link on navbar
      Then I should be redirected to the jobs page

  Scenario: Test the navigation by clicking the App logo link
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I click jobs link on navbar
    And I should be redirected to the jobs page
    When I click on the app logo
    Then I should be redirected to the home page

  Scenario: Test the navigation by clicking the Navbar Home link
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I click jobs link on navbar
    And I should be redirected to the jobs page
    When I click home route
    Then I should be redirected to the home page

    Scenario: Test the logout button functionality
      Given I am on the login page
      And I enter valid username as 'rahul'
      And I enter valid password as 'rahul@2021'
      And I click the login button
      And I should be redirected to the home page
      When I click logout button
      Then I should be redirected to the login page

