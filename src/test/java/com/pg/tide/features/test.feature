#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Tide Automation Testing
 Testing the tide website with the bdd cucumber

  @test1 
  Scenario: User registration functionality check
  	Given I am on the tide homepage
    When I click on the Register link following it I click on signup
    And I enter my credential and click on create account
    Then my account is created with a successfull account creation messsage
    
   @test2 
   Scenario: User login functionality check
    Given I am on the tide homepage
    And I click on the Register link following it I click on signup
    And I click on the login link on the pg page
    When I enter my credential and click on Login button
    Then my account is logged in with a successfull validation by user name visibility
    
   @test3 
   Scenario: Check language check functionality
    Given I am on the tide homepage
    When I click on the US-english language button on top
    And I choose Canada french as language from the popup
    Then the language is changed to canada french
    
   @test4 
   Scenario: Check for custom stain among many stain types
    Given I am on the tide homepage
    When I click on the cant find stain link
    And I search Grease as the stain type and click on the result
    Then I am on the article for Grease stain removal

	 @test5 
	 Scenario: Calculate savings after switching to cold water
		Given I am on the tide homepage
    When I click on savings sticky banner
    And I enter ten in the number of washes
    Then I am shown my savings for ten cold washes
    
    @test6 
    Scenario: Check for contact options availability on ContactUs Page
    Given I am on the tide homepage
    When I click on contact us link
    Then I am able to see different ways to contact
   
    @test7 
    Scenario: Search for pods and find result related to it 
    Given I am on the tide homepage
    When I search for pods
    Then I am able to product related to pods in the search result
    
    @test8 
    Scenario: Check for working status of part companies websites of Tide 
    Given I am on the tide homepage
    When I open all the part company websites using the logos on the homepage
    Then correct websites of the part companies are loaded
    
    @test9 
    Scenario: Start a live chat if the chat sevice is available
    Given I am on the tide homepage
    When I click on the Live chat link and go to chat window if Start Chat button is available
    And I enter the required details and go through the flow
    Then I am in a live chat session with the representative
    
    @test10 
    Scenario: Browse by Need for Freshness/Scent products
    Given I am on the tide homepage
    When I click on Browse by Need and click on Freshness/Scent from the popup
    Then I am redirected to Freshness Page where I find the product related to freshness
    
 