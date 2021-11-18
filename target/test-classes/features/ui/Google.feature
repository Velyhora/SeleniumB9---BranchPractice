Feature: Tests google search

  Background:
    When  user navigates to google.com

  @smoketest
  Scenario: search for java programming language
    And user searches for java programming language
    Then user should see more than 10000 results

    Scenario: search for cucumber for java
      And user searches cucumber for java
      Then user should see more than 500 results
      And user should get more than 15 links
