Feature: get all list
  Scenario: get all list
    Given setting endpoint "user?limit=10"
    When method get
    Then status 200
    Then match response contains 'data'