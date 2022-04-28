@allfeatures @careerPage
Feature: Website of Deva Medical Center - Careers Application Details

  Scenario: New Candidate Application - Successful
    Given I navigate to career page
    Then I verify 'Apply Now' and 'Home / Careers' are visible
    And I verify Latest Jobs and Physiotherapist are visible
    When I click Learn More
    Then I verify 'Job Brief', 'Responsibilities', 'Qualifications/Skills' and 'Requirements' are visible
    Then I verify that Apply Now visible
