@regression @feedback
Feature: Website of Deva Medical Center - Home Page - FEEDBACK

  Scenario: Send a Successful Feedback
    Given  I navigate to homepage
    Then I verify home page is visible
    When I hover and click feedback button
    Then I verify feedback popup opened
    When I fill the details and send the feedback
    Then I should be presented with a success feedback message
    Then I click OK and navigate to homepage