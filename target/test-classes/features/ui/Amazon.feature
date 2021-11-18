
Feature: Amazon's general features like search, pricing, buying

  Background:
  Given I am on amazon's home page
    When  I get the url

  @smoketest
Scenario: Amazon's home page test
  And I get the home page title
  And I get all the links
  Then url and title are valid

  Scenario: Amazon's search test
  When I search for selenium cookbook
  Then I should see  selenium cookbook related results only

  Scenario: Amazon's price test
  When  I search for "iphone"
  Then the result page should have max price of iphone more than $100






