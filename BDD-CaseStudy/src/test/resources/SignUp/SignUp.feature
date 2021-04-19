Feature: SignUp Feature
@SignUp
Scenario: Signup to the portal successfully
Given I am able to navigate to Homepage
And Click on SignUp button
When I Enter the First name as "Usha"
And I Enter the Last name as "B C"
And I Enter the email "ushabc.ncet@gmail.com"
And I Enter Username as "ushabc"
And I Enter Pass as "Admin@123"
And I Enter Confirm password as "Admin@123"
And Click on Register button
Then User should be registered successfully

@ComposeEmail
Scenario: Compose and send email to other user in the system
Given Able to login to the portal
When Click on Compose 
And Enter Subject
And Enter SendTo
And Click on Send Message
Then Email will be sent successfully with acknowledgement

@MultipleUsersRegistration
Scenario: Signup to the portal successfully
Given I am able to navigate to Homepage
And Click on SignUp button
When I Enter the First name as "<firstname>"
And I Enter the Last name as "<lastname>"
And I Enter the email "<email>"
And I Enter Username as "<username>"
And I Enter Pass as "<password>"
And I Enter Confirm password as "<confirmpassword>"
And Click on Register button
Then User should be registered successfully

Examples:
|firstname|lastname|email        		   |username  |password |confirmpassword|
|admin    |a12 		 |admin12@gmail.com	 |admin12   |admin@123|admin@123|
|usha			|ibm12	 |ushaibm12@gmail.com|ushaibm		|usha@123	|usha@123	|


