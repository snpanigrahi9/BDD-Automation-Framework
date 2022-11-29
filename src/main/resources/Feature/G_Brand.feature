@brand
Feature: MasterData brand feature of IQD

  Scenario: Brand feature of IQD
    When I click on brand
    And click on addnew button
    And I enter brand code
    And I enter brand name
    And I click on submit button
    Then I verify brand created successfully message
    Then I click OK from the popup
    
    
    



