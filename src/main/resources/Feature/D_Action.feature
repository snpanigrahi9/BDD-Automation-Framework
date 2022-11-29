@action
Feature: MasterData action feature of IQD
  
  Scenario Outline: Create new action
    When I click on action
    And click on addnew button
    When I enter actioncode
    And I enter actionname
    And I click on submit button
    Then I verify action created successfully message
    Then I click OK from the popup
