@allfeatures @joinusdirection
Feature: Website of Deva Medical Center - Home Page - Join Us

  Scenario: Send a Successful Join
    Given  I navigate to homepage
    Then I verify home page is visible
    When I scroll down and verify Join us is visible
    Then I click Apply Now button
    Then I should be directed to new page
    Then I verify I am navigated to career page