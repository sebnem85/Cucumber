@db @TECTC-108
Feature:  Testing my application
  Scenario Outline: Validating UI data with Database
    Given Navigate to MyApplication
    When User gets employee info for employee_id "<Employee_id>" from UI
    And User gets data for employee_id "<Employee_id>" from database
    Then Validate data are matching
  Examples:
    |Employee_id   |
    | 100          |
    | 105          |
    | 119          |
    | 125          |





