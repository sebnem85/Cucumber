$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Project.feature");
formatter.feature({
  "line": 1,
  "name": "Adding below data to your excel file in Sheet3",
  "description": "",
  "id": "adding-below-data-to-your-excel-file-in-sheet3",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "A",
  "description": "",
  "id": "adding-below-data-to-your-excel-file-in-sheet3;a",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@HRProject"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "Go to Database and get First name and Last name of employees who works in Europe and validate with their UI information (First name, Last Name)",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED",
  "keyword": "Then "
});
formatter.match({
  "location": "HRApplicationSteps.go_to_Database_and_get_First_name_and_Last_name_of_employees_who_works_in_Europe_and_validate_with_their_UI_information_First_name_Last_Name()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HRApplicationSteps.go_to_Excel_and_update_column_Actual_of_Employees_with_number_of_Europe_employees_that_you_get_from_UI()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HRApplicationSteps.compare_Actual_of_Employees_with_expected_of_Employees_and_if_they_matched_then_update_Test_Execution_Status_cell_as_PASSEDif_not_match_then_update_with_FAILED()"
});
formatter.result({
  "status": "skipped"
});
});