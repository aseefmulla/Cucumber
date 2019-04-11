Feature: Facebook login

  Scenario Outline: Login with invalid credential
    Given user open the browser and launch facebook application
    And user enters <username> and <password>
    When user clicks on submit button
    Then application displays user and pass is incorrect
    Then Close the browser

    Examples: 
    |username|password|
    |abc3445|wer123|