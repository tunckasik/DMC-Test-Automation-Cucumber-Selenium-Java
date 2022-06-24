@regression @appointment
Feature: Website of Deva Medical Center - Home Page

  Scenario: Successful Appointment Request
    Given  I navigate to homepage
    When I click request an appointment
    Then I should be presented with a notice for insurance members
    Then I click next and fill the details
    Then I attach the a file and write a message
    When I click on Request, I should be presented with success message