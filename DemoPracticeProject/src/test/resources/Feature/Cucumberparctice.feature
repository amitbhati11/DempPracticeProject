Feature: 

  Scenario Outline: 
    Given open the browser
    And enter the URL
    When enter the <username> and <password>
    And Click on loginbutton
    Then navigate to home page

    Examples: 
      | username | password |
      | amit     |    12345 |
      | shaivani |    12345 |
      | kaushal  |    12345 |
      | rajvir   |   123456 |
