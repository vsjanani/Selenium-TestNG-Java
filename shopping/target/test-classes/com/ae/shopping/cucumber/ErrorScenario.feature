@tag
Feature: Verify negative scenario assertion

Background:
 Given American Eagle website is opened accepting cookies and popup offer
   
  @NegativeScenario
  Scenario Outline: Error is thrown if non-existing option is selected in Women Mega Menu
    Given <optFrmWomen> presence is validated 
    Then assertion returns false

     Examples: 
      | 	optFrmWomen  |  
      | 	   Hello	   |
   