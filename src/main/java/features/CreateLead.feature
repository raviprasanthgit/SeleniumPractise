@createlead
Feature: To create cucumber scripts for Create Lead

#Background:
#Given Launch the browser
#And Maximise the browser Window
#And Load the URL
#And Wait for the implicit time

@sanity @smoke
Scenario: Create Lead Scripts
Given Enter the user name as DemoSalesManager
And Enter the password as crmsfa
And click on the submit button
And Click on CRMSFA link
And Click on Create Lead link
And Enter the Company name as test leaf
And Enter the first name as Ravi
And Enter the last name as Naveen
When Click on submit button
Then Create lead is successfully created
And Close the browser

@smoke @reg
Scenario Outline: Create Lead Scripts usng outline
Given Enter the user name as <uname>
And Enter the password as <password>
And click on the submit button
And Click on CRMSFA link
And Click on Create Lead link
And Enter the Company name as test leaf
And Enter the first name as <fname>
And Enter the last name as <lname>
When Click on submit button
Then Create lead is successfully created
And Close the browser

 Examples:
 |uname|password|fname|lname|
 |DemoSalesManager|crmsfa|ravi|naveen|
 |DemoCsr|crmsfa|naveen|ravi|
 
 