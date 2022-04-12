Feature: Adding new computer to the database from frontend application

  @Run1
  Scenario: Validate the option exists in front end to add new computers to the database
    Given User opens the web application
    When User clicks on the Add a New Computer button
    Then User should view the new form page with heading "Add a New Computer"

  @Run2
  Scenario Outline: Validate the feature of adding new computers to the database
    Given User opens the web application
    When User clicks on the Add a New Computer button
    And Enters the values for "<Field1>","<Field2>","<Field3>" and "<Field4>"
    And User clicks the Add computer button to add the entry
    Then User should view the data for "<Field1>" in the main page

    Examples:
     |Field1|Field2|Field3|Field4|
     |LAP111|2001-04-14|2010-04-14|IBM|
     |LAP222|1991-06-14|2010-04-24|Canon|
     |LAP333|04-14-2000|2010-04-14|IBM|
     |LAP444|1991-06-14|04-24-2010|Canon|
     |LAP555|06-14-1991|04-24-2010|Canon|
     |LAPTOP4|     |      |      |
     ||2001-04-14|     |      |
     ||     |2001-04-14|      |
     |LAPTOP3|     |      |IBM|

  @Run3
  Scenario Outline: Validate the cancel button feature while adding computers to the database
    Given User opens the web application
    When User clicks on the Add a New Computer button
    And Enters the values for "<Field1>"
    And User clicks cancel button to abort the adding the entry
    Then User should go back to the main page

    Examples:
      |Field1|
      |LAPTOP123|