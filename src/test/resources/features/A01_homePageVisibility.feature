@allfeatures @homepageverification
Feature: Website of Deva Medical Center - Home Page

  Background: Home Page
    Given  I navigate to homepage

  Scenario: Verify Home Page Head Information Details
    Then I verify home page is visible
    Then I verify 'About Us', 'Departments', 'Contact', 'Careers' and 'Magazine' are visible


  Scenario: Insurance Partners, Working Hours and Request an Appointment are visible
    Then I verify 'Insurance Partners' is visible
    Then I verify 'Working Hours' is visible
    Then I verify 'Request an Appointment' is visible
    When I click request an appointment
    Then I should be presented with a notice for insurance members
    Then I close the pop