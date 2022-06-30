Feature: Login to Omayo application

@omayologin @all @datadriven
Scenario Outline: User should only be able to login with valid credentials
Given I navigate to Omayo website
When I enter username as <username> and password as <password> into the fields
And I click on Login button
Then User should get logged in based on expected <loginstatus> status
Examples:
|username				|password	|loginstatus	|
|arun						|pswd1		|failure			|
|SeleniumByArun	|Test143$	|success			|
|motoori				|pswd2		|failure			|

