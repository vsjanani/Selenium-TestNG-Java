@tag
Feature: Quick Shop displays product details
  
 Background:
 Given American Eagle website is opened accepting cookies and popup offer
 
  @SmokeTestCucumber
  Scenario Outline: Validate on clicking Quick Shop option for a <productName>, the same is displayed as title in QuickShop page
    Given <optFrmWomen> presence is validated
    And <optFrmWomen> is clicked
    When Quick Shop option for selected <productName> is entered
    Then <productName> is displayed as product title

    Examples: 
      |		 productName   | optFrmWomen |  
      |  AE Hey Baby Tee | 	 Tops	    |
       
      
