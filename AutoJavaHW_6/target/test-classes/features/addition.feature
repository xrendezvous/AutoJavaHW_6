Feature: Addition

  Scenario Outline: Add two numbers
    Given I have two numbers <num1> and <num2>
    When I add them
    Then the result should be <result>

    Examples:
      | num1 | num2 | result |
      | 1    | 1    | 2      |
      | 2    | 3    | 5      |
      | 3    | 5    | 8      |
