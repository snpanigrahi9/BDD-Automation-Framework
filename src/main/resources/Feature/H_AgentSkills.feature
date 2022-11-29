@agentSkills
Feature: MasterData agentskills feature of IQD

  Scenario Outline: User is on AgentSkills page
    
    When I click on agentskills from the menu
    And click on addnew button
    And I enter agentskillcode
    And I enter agentskillname
    And I click on submit button
    Then I verify agent skill created successfully message
    Then I click OK from the popup