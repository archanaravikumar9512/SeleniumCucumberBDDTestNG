@TestDataReading
Feature: Application PageTitle
 
@SmokeTest 
Scenario: Verification of Home Page Title
Given read data from excel TC_001
When user is already on home page 
And user gets the page title
Then user validates the page title
Then update the result into the excelfile for TC_001