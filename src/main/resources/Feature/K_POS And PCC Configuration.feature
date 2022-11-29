@posAndpcc
Feature: MasterData pos and pcc feature of IQD

  Scenario: User is on POS page
    
    When I click on POS
    And click on addnew button
    And I enter POS code and POS name
    And I select country,brand,currency
    And I select LangId and POSIATACode
    And I click on submit button
    Then I verify POS created successfully
    Then I click OK from the popup
    When I click on PccConfiguration
    And click on addnew button
    And I select POS and select GDS
    And I enter pcc
    And I click on submit button
    Then I verify PCC created successfully
    Then I click OK from the popup