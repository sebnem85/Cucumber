$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AwsCalculator.feature");
formatter.feature({
  "line": 1,
  "name": "Testing AWS Calculator",
  "description": "",
  "id": "testing-aws-calculator",
  "keyword": "Feature"
});
formatter.before({
  "duration": 11696640100,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Testing calculation of prices for EC2 Instances",
  "description": "",
  "id": "testing-aws-calculator;testing-calculation-of-prices-for-ec2-instances",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@TECTC-110"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user Navigate to AWS Calculator Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User adds 2 EC2 Instances",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user adds 2 EC2 Dedicated Hosts",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Total estimated cost has to match with prices on \"testData\" \"Sheet2\" excel file",
  "keyword": "Then "
});
formatter.match({
  "location": "AwsCalculatorSteps.user_Navigate_to_AWS_Calculator_Homepage()"
});
formatter.result({
  "duration": 1801300100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 10
    },
    {
      "val": "2",
      "offset": 14
    }
  ],
  "location": "AwsCalculatorSteps.user_adds_EC_Instances(int,int)"
});
formatter.result({
  "duration": 8506456700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 10
    },
    {
      "val": "2",
      "offset": 14
    }
  ],
  "location": "AwsCalculatorSteps.user_adds_EC_Dedicated_Hosts(int,int)"
});
formatter.result({
  "duration": 5545124500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testData",
      "offset": 50
    },
    {
      "val": "Sheet2",
      "offset": 61
    }
  ],
  "location": "AwsCalculatorSteps.total_estimated_cost_has_to_match_with_prices_on_excel_file(String,String)"
});
formatter.result({
  "duration": 3984396900,
  "error_message": "java.lang.NumberFormatException: empty String\r\n\tat sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1842)\r\n\tat sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)\r\n\tat java.lang.Double.parseDouble(Double.java:538)\r\n\tat stepDefs.AwsCalculatorSteps.total_estimated_cost_has_to_match_with_prices_on_excel_file(AwsCalculatorSteps.java:58)\r\n\tat ✽.Then Total estimated cost has to match with prices on \"testData\" \"Sheet2\" excel file(AwsCalculator.feature:9)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 351964500,
  "status": "passed"
});
});