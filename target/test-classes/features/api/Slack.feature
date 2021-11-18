Feature: Messaging in Slack
  This is the new cool feature in slack,
  where users should be able to send messages via API calls

  Scenario: Success message
    Given user has valid send message URL
    When user sends a message to "API" channel
    Then status code should be 200
    And ok key is true