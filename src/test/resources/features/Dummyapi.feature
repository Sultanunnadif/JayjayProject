Feature: Dummy API Testing
  Scenario: get all list
    Given setting endpoint "user?limit=10"
    When method get
    Then status 200
    Then match response contains 'data'

  Scenario: get user ID
   Given setting endpoint "user?limit=10"
   When method get specific user ID
   Then status 200
   Then match response contains 'id'

  Scenario: get user ID without appId
    Given setting endpoint "user?limit=10"
    When method get specific user ID without appId
    Then status 404
    Then match response contains 'id'

  Scenario: post user ID
   Given setting post endpoint "user/create"
   And the Request body:
   """
   {
      "firstName": "morpheus",
      "lastName": "Doe",
      "email": "Morphe@example.com"
   }
   """
   When user send post request
   Then status 201
   And match response contains 'morpheus'

  Scenario: update created ID
    Given setting put endpoint "user/{createdUserId}"
    And the Request body:
    """
    {
        "firstName": "morp",
        "lastName": "heus"
    }
    """
    When user send put request
    Then status 200
    And match response contains 'morp'

    Scenario: Delete created ID
      Given setting delete endpoint "user/{createdUserId}"
      When user send delete request
      Then status 200