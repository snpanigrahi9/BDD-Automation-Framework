@country
Feature: MasterData country feature of IQD

  Scenario: Country feature of IQD
    When I click on countries
    And click on addnew button
    And I enter region name
    And I enter country code
    And I enter country name
    And I click on submit button
    Then I verify country created successfully message
    Then I click OK from the popup
    



