Feature: Facebook Registration
  
  This feature file contains tests for facebook registration
  


  Scenario: Verify that user is able to register in facebook
    Given User navigates to https://www.facebook.com
    When User fills details for facebook registration
    		 | Firstname | Ram |
    		 | Surname | Ganesh |
    		 | Mobile | 8561234789|
    		 