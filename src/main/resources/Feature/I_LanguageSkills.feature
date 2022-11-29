@languageSkills
Feature: MasterData languageskills feature of IQD

  Scenario Outline: User is on LanguageSkills page
  
    When I click on languageskills from the menu
    And click on addnew button
    And I enter languagecode
    And I enter language name
    And I click on submit button
    Then I verify language skills created successfully message
    Then I click OK from the popup
      