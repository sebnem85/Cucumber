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
  "name": "Go to Database and get First name and Last name of employees who works in Europe and validate with their UI information (First name, Last Name).",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI.",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSED if not match then update with FAILED.",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});