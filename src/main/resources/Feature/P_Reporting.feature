@report
Feature: Reporting feature of IQD

  Scenario Outline: User is on agent report page
    When I click on reporting
    And I click on agent report
    And I select site, site partition, datefilter, startDate, endDate
    Then I click on download button
    
    #Donot enter any startdate or enddate. It's taking dynamic value from script
   
      Scenario Outline: User is on agent performance report page
   
     When I click on agent performance report
     And I select site, site partition, pos, datefilter, startDate, endDate
     Then I click on download
     
    #Donot enter any startdate or enddate. It's taking dynamic value from script
     
     Scenario Outline: User is on work item details report page
     
     When I click on work itme details report
     And I select OnDateType, site, sitePartition, workItemType, startDate, endDate, datefilter
     And I select task
     Then I click on download button
     
      #Donot enter any startdate or enddate. It's taking dynamic value from script
     
     
     
    Scenario Outline: User is on Single Work Item report page
       
    When I click on SingleWorkItem report
    And I enter WorkItemId and PNRRecordlocator
    Then I click on download
    

  Scenario Outline: User is on SLA Compliance report page
    When I click on SLA Compliance report
    And I select site, sitepartition, datefilter, startDate, endDate
    And I click task or STQ radio button
    And I select task or STQ from the dropdown
    And I select subtask or ASTQ from the checkbox
    Then I click on download
    
    # Donot enter any startdate or enddate. It's taking dynamic value from script 

      
    Scenario Outline: User is on escalated work item report page
    
    When I click on escalated work item report
    And I select site, sitepartition, startDate, endDate
    And I select STQ from the dropdown
    And I select ASTQ from the checkbox
    Then I click on download
    
     #Donot enter any startdate or enddate. It's taking dynamic value from script 