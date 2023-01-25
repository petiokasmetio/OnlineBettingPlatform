#Author: Petar Nikolov
#Date: 23.01.2023y.
#Description: This is a framework for testing online betting platform

@RegressionScenario
Feature: Login functionality

  @RegressionTest @SmokeTest
  Scenario Outline: Check login is successful with valid credentials
    Given User is on login page "https://winbet.bg/sports"
    When User enters Username "<username>" and Password "<password>"
    Then User is navigated to the home page

  Examples:
  |username|password|
  |pet.io  |36L99mw5FcTYR82|

  @RegressionTest
  Scenario Outline: Check login with invalid credentials is unsuccessful
    Given User is on login page "https://winbet.bg/sports"
    When User enters Username "<username>" and Password "<password>"
    Then Error message is displayed

  Examples:
    |username|password|
    |user1   |pass1   |
