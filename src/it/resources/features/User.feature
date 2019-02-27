Feature: Scenarios for creating, reading, updating and deleting users

  Scenario: Read all users

    Given REST URL <"/users">
    When GET request is sent
    Then response status should be <200>
    And response body should match

    """
    {
      "users": [
        {
          "id": "123456",
          "name": "Chris"
        },
        {
          "id": "789123",
          "name": "Kevin"
        }
      ]
    }
    """

  Scenario: Read a specific user

    Given REST URL <"/users/123456">
    When GET request is sent
    Then response status should be <200>
    And response body should match

    """
    {
      "users": [
        {
          "id": "123456",
          "name": "Kevin"
        }
      ]
    }
    """