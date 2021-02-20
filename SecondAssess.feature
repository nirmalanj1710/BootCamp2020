Feature: Assessment integrating Cucumber and POM

Scenario: To verify the reports

#Given launch the Chrome browser
#And load the url
#And Enter the username as cypress@testleaf.com
#And Enter the password as Bootcamp@123
#When click on login button
Then load AppLauncher and navigate till Reports option
#Then AppLauncher page should be displayed
#And click on ViewAll
#And click on Sales
#And click on Accounts
And click on New Report_Salesforce_Classic
And click on Leads
#And click on Lead Report image to download
And click on Create button 
And select the Range as All Time
And select the date as 5 days from today
And veriy the Preview is in Tabular Format
And get the List of Company_Account
And get the Grand Total of Records Available
Then click on save button in Reports
And Enter Report name as Nirmal
And Enter Report Unique name as Nirmal_01 
And Report Discussion as Report Updated by Nirmal01
And select Report Folder as Unfiled Public Reports
Then click save button to save the Reports
#And Verify Report has been created successfully
And Click on Run Report

 



