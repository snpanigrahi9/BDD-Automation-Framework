@task
Feature: MasterData task feature of IQD

  
  Scenario: Create new task
  
    Then click on manage master data
    Then click on task
    Then click on addnew button
    When I enter taskcode
    And I enter taskname
    And I click on submit button
    Then I verify task created successfully message
    Then I click OK from the popup
      
