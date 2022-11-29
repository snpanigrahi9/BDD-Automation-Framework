@subaction
Feature: MasterData subaction feature of IQD

  Scenario Outline: Create new SubAction
    When I click on SubAction
    And click on addnew button
    When I enter subaction code
    And I enter subaction name
    And I click on submit button
    Then I verify subaction created successfully message
    Then I click OK from the popup