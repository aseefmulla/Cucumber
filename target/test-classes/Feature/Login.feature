Feature: Facebook login

  Scenario Outline: Login with invalid credential
    Given user open the browser and launch facebook application
    And user enters username <username>
    And user enters password <password>
    When user clicks on submit button
    Then application displays user and pass is incorrect
    Then Close the browser

    Examples: 
      | username | password |
      | abdf     | werty    |
