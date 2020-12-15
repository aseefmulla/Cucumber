Feature: Goibibo Application Testing

  Scenario: Goibibo login
    Given user open browser and launch goibibo application
    When user click on goibibo login page
    Then goibibo login page displayed
    Then Close the browser
  #Scenario Outline: Goibibo bus search
    #Given user open browser and launch goibibo application
    #And selects from <from> and to <to>
    #And select departure <depdate>
    #When user clicks search button
    #Then click on round trip radio button
    #And select round trip radio button is selected
    #
     #
#
    #Examples: 
      #| from      | to    | depdate       |
      #| Bangalore | Delhi | 19/June 2019 |
