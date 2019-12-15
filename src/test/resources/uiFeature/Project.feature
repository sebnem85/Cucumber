Feature: Adding below data to your excel file in Sheet3
@HRProject
  Scenario:
    Given Go to Database and get First name and Last name of employees who works in Europe and validate with their UI information (First name, Last Name).

    And Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI.

    Then Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSED if not match then update with FAILED.
