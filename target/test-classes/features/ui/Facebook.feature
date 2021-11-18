Feature: Facebook registration

  @dataTable
  Scenario: Happy path registration
    Given I am on facebook home page
    When I try to sign up for account
    And I fill up sign up information
      | firstName  | Techtorial                |
      | lastName   | Academy                   |
      | email      | techtorial@techtorial.com |
      | password   | randomPassword101         |
      | birthMonth | Mar                       |
      | birthDay   | 23                        |
      | birthYear  | 2019                      |
      | gender     | Custom                    |
    Then new account is ready to be created
    But I cancel sign up form
 #   And new account is not created

  @examplesTable
  Scenario Outline: Sing in to Facebook with invalid username and password
    Given  I am on facebook home page
    When  I try to sign in with invalid "<username>" or "<password>"
    Then I should get error message:"<errorMessage>"
    Examples:
      | username        | password        |      errorMessage                                                                                           |
      | invalidUserName | invalidPassword | The email or mobile number you entered isn’t connected to an account. Find your account and log in. |
      |                 | ALLUPPERCASE    | The email or mobile number you entered isn’t connected to an account. Find your account and log in. |
      | ALLLOWERCASE   | validPassword   | The email or mobile number you entered isn’t connected to an account. Find your account and log in. |