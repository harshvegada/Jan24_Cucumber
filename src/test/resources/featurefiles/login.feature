@login
Feature: Verfiy Login feature

  Background:
    Given User is on Login Page
    When User enter username as "rajshri@gmail.com"
    And User enter password as "January@123"
    And User click on login button

  @successful
  Scenario: verify login using valid credentials
    Then User is on dashboard Page

  @unsuccessful
  Scenario: verify login using invalid credentials
    Then User verify authentication failure popup is displayed
    Then User verify user is on Login Page

  #@loginDataprovider
  #Scenario Outline: verify login using example data
  #Given User is on Login Page
  #When User enter username as "<username>"
  #And User enter password as "<password>"
  #And User click on login button
  #Then User verify username empty message "<usernamestatus>" displayed
  #Then User verify password empty message "<passwordstatus>" displayed
  #Then User verify authentication failure message "<authenticationstatus>" displayed
  #Then User verify account doesnt exist message "<accountexiststatus>" displayed
  #Then User verify login is "<result>"
  #
  #Examples:
  #| username          | password     | result       | usernamestatus | passwordstatus | authenticationstatus | accountexiststatus |
  #| rajshri@gmail.com | January@123  | successful   | is not         | is not         |
  #| mkanani@gmail.com | January@1234 | unsuccessful | is not         | is not         |
  #|                   | January@1234 | unsuccessful | is             | is not         |
  #| mkanani@gmail.com |              | unsuccessful | is not         | is             |

  @loginDataprovider
  Scenario Outline: verify login using example data
    Given User is on Login Page
    When User enter username as "<username>"
    And User enter password as "<password>"
    And User click on login button
    Then User verify message "<message>" is displayed
    Then User verify login is "<result>"

    Examples:
      | username          | password     | result       | message                       |
      | rajshri@gmail.com | January@123  | successful   |                               |
      | mkanani@gmail.com | January@1234 | unsuccessful | Account does not exists.      |
      |                   | January@1234 | unsuccessful | Hey! email can't be empty!    |
      | mkanani@gmail.com |              | unsuccessful | Hey! password can't be empty! |
