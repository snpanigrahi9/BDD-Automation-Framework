@subtask
Feature: MasterData subtask feature of IQD

  Scenario Outline: Create new subtask
    And I click on subtasks
    And click on addnew button
    When I enter subtaskcode
    And I enter subtaskname
    Then I click on submit button
    Then I verify subtask created successfully message
    Then I click OK from the popup
