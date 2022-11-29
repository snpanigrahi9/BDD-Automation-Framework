@stq
Feature: Manage STQ feature of IQD

  Scenario Outline: User is on manage STQ page


    When I click on manage STQ
    And I click on GDS Queue Configuration
    And click on addnew
    And I enter GDS queue name
    And I select GDS type
    And I select POS and POS IATA Number and Pcc
    And I select Target THT Hour and Minute
    And I select Task and Subtask
    And I select Skill
    And I select Duration hour and minute
    And I select timezone
    And I click on Test Connection button if available
    And I click on submit
    Then I verify GDS Queue created successfully message
    Then I click OK from the popup