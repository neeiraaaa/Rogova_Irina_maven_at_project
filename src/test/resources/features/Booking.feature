Feature: Booking test

  Scenario: My first booking test
    Given I open booking site
    When  I register new user
    Then I verify, that mailbox was confirmed