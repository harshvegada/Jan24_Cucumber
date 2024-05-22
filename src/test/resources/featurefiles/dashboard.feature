Feature: Verify dashboard feature
  
  @Dashboard @smoke
  Scenario: Dashboard UI validation
    Given User is on Login Page
    When User login using valid credentials
    And User wait for dashboardpage to be loaded
    Then User verify Invites Used, Total Assessments, Total Appeared, Total Qualified is visible
    Then User verify Total Assessments, Total Appeared, Total Qualified card must have value 0 or more
    Then User verify Assessments, Library, Candidates, Interviews tabs are visible
    Then User verify Create Assessments and Create Question button is clickable