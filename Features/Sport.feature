#Author: Petar Nikolov
#Date: 23.01.2023y.
#Description: This is a framework for testing online betting platform

@RegressionScenario
Feature: Favourites page functionality

  @SmokeTest
  Scenario: Check for empty favourites list
    Given User is logged in
    When Click on Favourites
    Then Favourites page is displayed
