Feature: Scenarios for creating, reading, updating and deleting users

  Scenario: Read all users

    Given REST URL <"/users">
    When GET request is sent
    Then response status should be <200>
    And response body should match

    """
    [
      {
        "id": 1,
        "name": "Chris"
      },
      {
        "id": 2,
        "name": "Kevin"
      }
    ]
    """

  Scenario: Read a specific user

    Given REST URL <"/users/2">
    When GET request is sent
    Then response status should be <200>
    And response body should match

    """
    {
      "id": 2,
      "name": "Kevin"
    }
    """