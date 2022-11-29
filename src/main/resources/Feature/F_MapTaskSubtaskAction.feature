@mapping
Feature: MasterData mapping feature of IQD
  
  Scenario Outline: User is on mapping page
    
    When I click on map Task Subtask and action
    And I select task from the dropdown
    And I click on Map Task Subtask Action button
    And I select subtask from the dropdown
    And I select action from the dropdown
    And I select subaction from the dropdown
    And I click on submit button
    Then I verify action mapped to task and subtask successfully
    Then I click OK from the popup
