Feature: User should be able to register

@register @all
Scenario: User is able to register by providing only mandatory fields
Given I navigate to register page
When I enter all the below details into the fields
|firstName	|arun												|
|lastName		|motoori										|
|telephone	|12345678901								|
|password		|12345											|
And I select privacy policy checkbox field
And I click on Continue button
Then User should get successfully registered
