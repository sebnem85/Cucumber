Feature: Adding below data to your excel file in Sheet3
  @HRProject
  Scenario: A
    Given Go to Database and get First name and Last name of employees who works in Europe and validate with their UI information (First name, Last Name)
    And Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI
    Then Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED
  @HRProject1
  Scenario: B
    Given Go to Database and get Department Name and number of ‘Active’employees and validate with their UI numbers
    And Then go to Excel and update column ‘Actual # of Employees’ with number of Active employees that you get from UI and compare that number with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED