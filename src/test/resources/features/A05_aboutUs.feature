@allfeatures @aboutus
Feature: Website of Deva Medical Center - About Us Page
  Background: About Us Page
    Given  I navigate to about us page

  Scenario: Verify Our Mission, Our Vision and Core Value are visible
    Then I verify about us page is visible
    When I scroll down and verify Our Mission, Our Vision and Core Value are visible
    Then I click Core Value
    Then I verify Core Value of DMC is visible
@aboutusdr
  Scenario: Verify Your Doctors are as expected quantity
    Then I verify 14 doctors are listed
    Then I verify Dr Kadir is visible