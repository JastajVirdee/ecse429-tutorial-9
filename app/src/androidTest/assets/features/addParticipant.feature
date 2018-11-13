Feature: Add a participant
  Add a test participant to the main activity

  Scenario Outline: Add new participant to the main activity
    Given I have a MainActivity
    When I input username <username> in text field 'Who?'
    And I press 'Add Participant' button
    When I click on the 'Refresh Participant List' button
    Then I should see <see> in the list

    Examples:
      | username          | see               |
      | some_random_guy_1 | some_random_guy_1 |
      | some_random_guy_2 | some_random_guy_2 |
      | some_random_guy_3 | some_random_guy_3 |