@regression @applynow
Feature: Website of Deva Medical Center - Careers Application Details

  Scenario: New Candidate Application - Successful
    Given I navigate to career page
    Then I verify 'Home /Careers' is visible
    Then I click Apply Now and verify Application form is opened
    Then I fill the application form
    Then I attach my profile photo and write a message
    Then I click on send, I should be directed to home page