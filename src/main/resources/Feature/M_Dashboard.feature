@dashboard
Feature: Dashboard feature of IQD

  Scenario: User is on Agent & WI dashboard page
  When I click on dashboard from the menu
  And I click on AgentAndWorkItem dashboard
  And I select site, sitepartition, duration
  And I select STQ
  Then I click on search button
  
  Scenario: User is on STQ/ASTQ dashboard page
  When I click on dashboard from the menu
  And I click on STQ/ASTQ dashboard
  And I select site, sitepartition, duration
  Then I click on search button
  
  Scenario: Verfiy expand arrow of STQ
  
  When I click on dashboard from the menu
  And I click on AgentAndWorkItem dashboard
  And I select site, sitepartition, duration
  And I select STQ
  Then I click on search button
  Then I click on the expand arrow of 'New ITEMS'
  Then I verify 'Work Item Status' dialog box
  
  Scenario: Verify STQ/ASTQ Dashboard
    When I click on dashboard from the menu
    And I click on STQ/ASTQ dashboard
    And I select site, sitepartition, duration
    And I click on search button
    And I click on STQ dropdown
    Then I verify if the count of COMPLETED WORK ITEMS, NEW WORK ITEMS, SLA BREACHED (NEW), AGENTS ASSIGNED, AGENTS WORKING, AGENTS ON BREAK, AGENTS IDLE is displaying as expected
