Feature: Amazon application Test

  
  Scenario: Login Amazon
  Given user open browser and launch amazon application
  When user click on login page
  Then amazon login page displayed
  And close amazon site
  
  Scenario Outline: Search criteria
  Given user open browser and launch amazon application
  And user selects <dropdown>
  And user enter <searchvalue>
  When user click on submit button of amazon
  Then application display <searchvalue> result for search
  And close amazon site
  
  Examples:
  | dropdown | searchvalue |
  | Books    | freedom     |
  | Baby     | soap        |
  Scenario Outline: Add to cart
    Given user open browser and launch amazon application
    And user selects <dropdown>
    And user enter <searchvalue>
    And user click on submit button of amazon
    And user clicks on random search result link
    When user click on add to cartbutton
    Then item is adde to cart
    And swich back to main window
    And close amazon site

    Examples: 
      | dropdown    | searchvalue |
      | Electronics | headphones   |
