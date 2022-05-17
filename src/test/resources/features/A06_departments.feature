@regression @departments
Feature: Website of Deva Medical Center - Departments Page

  Scenario: Verify Departments are listed as expected
    Given I navigate to departments page
    Then I verify Our Medical Services is visible
    Then I verify 8 departments are visible
