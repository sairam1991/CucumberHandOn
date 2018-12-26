Feature: Login tests
  
  This feature file contains all the login tests
  
  Background:
    Given User is on https://store.demoqa.com
    When User clicks on MyAccount link

  Scenario: Verify that user is able to login using valid username and password
    And User logs in using valid username LearnCucumber and password TestPassword123@
    Then User is taken to the my account page
    
   Scenario: Verify that user is able to login using invalid username and password
    And User logs in using valid username LearCucumber and password TestPassword123
    Then User is taken to the my account page
