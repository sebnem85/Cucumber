Feature: Testing AWS Calculator

  @TECTC-110

  Scenario: Testing calculation of prices for EC2 Instances
    Given user Navigate to AWS Calculator Homepage
    When User adds 2 EC2 Instances
    And user adds 2 EC2 Dedicated Hosts
    Then Total estimated cost has to match with prices on "testData" "Sheet2" excel file