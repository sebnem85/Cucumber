@TECT-1112
Feature: Authentication functionality

  Scenario: Verify Create an account
    Given Navigate to home page
    Then User click the Sign in button
    Then User create by sign in with valid credentials email "sebnem85@gmail.com"
    And User click Create an account
    Then Fill up the new account from with the following data
      | First name | Last Name | Email              | Password | DOB Day | DOB Month | Address     | City        | State | Zip/PostalCode | Country | Home phone | Mobile phone | Assign an address |
      | Tester FN  | Tester LN | sebnem85@gmail.com | 12345    | 13      | 01        | 123 Roselle | Des Plaines | IL    | 60078          | USA     | 123987234  | 12392345     | 123 N Tech        |

    Then User clicks on Register

  Scenario: Verify Create an account
    Given Navigate to home page
    Then User click the Sign in button
    Then User create by sign in with invalid credentials email "sebnem85@gmail.com"
    And User click Create an account
    Then Fill up the new account from with the following data
      | First name | Last Name | Email              | Password | DOB Day | DOB Month | Address     | City        | State | Zip/PostalCode | Country | Home phone | Mobile phone | Assign an address |
      | Tester FN  | Tester LN | sebnem85@gmail.com | 12345    | 13      | 01        | 123 Roselle | Des Plaines | state    | 60078          | USA     | 123987234  | 12392345     | 123 N Tech        |
    Then User clicks on Register




    
