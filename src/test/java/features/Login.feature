Feature: Application Login 

Background:
Given Open the Application URL
And Navigate to Login page

@smoke @positive @all @login
Scenario: Login with valid credentials
When User enter valid username and valid password into the fields
And User clicks on Login button
Then Verify user is able to successfully login

@negative @all @login
Scenario: Login with valid username and invalid password
When User enter valid username and invalid password into the fields
And User clicks on Login button
Then Verify a warning informing user to provide valid credentials is displayed

@negative @all @login
Scenario: Login with invalid username and valid password
When User enter invalid username and valid password into the fields
And User clicks on Login button
Then Verify a warning informing user to provide valid credentials is displayed