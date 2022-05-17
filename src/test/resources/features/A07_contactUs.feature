@regression @contactus
Feature: Website of Deva Medical Center - Contact Us Page

  Scenario: Verify Contact Us Page
    Given I navigate to contact us page
    Then I verify contact us is visible
    Then I am presented with 'Customer Care', 'Insurance Officer' and 'HR Officer'
    Then I scroll down and verify the address

