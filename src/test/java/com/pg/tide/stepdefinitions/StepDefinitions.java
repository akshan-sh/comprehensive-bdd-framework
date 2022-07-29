package com.pg.tide.stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pg.tide.pageobjects.ChatWindow;
import com.pg.tide.pageobjects.ContactUsPage;
import com.pg.tide.pageobjects.FreshnessPage;
import com.pg.tide.pageobjects.GreaseStainPage;
import com.pg.tide.pageobjects.HomePage;
import com.pg.tide.pageobjects.HowToRemoveStainsPage;
import com.pg.tide.pageobjects.SavingsCalculatorPage;
import com.pg.tide.pageobjects.SearchResultsPage;
import com.pg.tide.pageobjects.SignUpNowPGPage;
import com.pg.tide.utilities.ExcelReading;
import com.pg.tide.utilities.Logging;
import com.pg.tide.utilities.Reporting;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	Base base = new Base(); // creating global object of base class to be used by each test method
	Reporting report = new Reporting();// creating global object for extent reporting
	Logging log = new Logging();

	@Given("I am on the tide homepage")
	public void i_am_on_the_tide_homepage() throws IOException {
		base.initializeDriver();
		base.navigateDriver();
		report.test = report.getExtent().createTest("Test");
	   
	}
	@When("I click on the Register link following it I click on signup")
	public void i_click_on_the_register_link_following_it_i_click_on_signup() throws IOException {
	   
		
				
				
				HomePage home = new HomePage(base.getDriver(), report, log);
				home.goToPGRegistrationPage();
				
				//switching to PG registration page
				ArrayList<String> tabs2 = new ArrayList<String>(base.getDriver().getWindowHandles());
				base.getDriver().switchTo().window(tabs2.get(1));
	}
	
	
	@When("I enter my credential and click on create account")
	public void i_enter_my_credential_and_click_on_create_account() throws IOException {

		String name = ExcelReading.extractCell(2, 3);
		String email = ExcelReading.extractCell(3, 3);
		String password = ExcelReading.extractCell(4, 3);

		SignUpNowPGPage now = new SignUpNowPGPage(base.getDriver(), report, log);
		now.signUp(name, email, password);
		
	   
	}
	
	
	@Then("my account is created with a successfull account creation messsage")
	public void my_account_is_created_with_a_successfull_account_creation_messsage() {
		
		SignUpNowPGPage now = new SignUpNowPGPage(base.getDriver(), report, log);
		now.verifySignup();
		
	   
	}
	
	@Given("I click on the login link on the pg page")
	public void i_click_on_the_login_link_on_the_pg_page() {
		SignUpNowPGPage now = new SignUpNowPGPage(base.getDriver(), report, log);
		now.clickOnLoginLink();
	}

	@When("I enter my credential and click on Login button")
	public void i_enter_my_credential_and_click_on_login() throws IOException {
		
		String email = ExcelReading.extractCell(5, 3);
		String password = ExcelReading.extractCell(6, 3);
		
		SignUpNowPGPage now = new SignUpNowPGPage(base.getDriver(), report, log);
		now.login(email, password);
	}

	@Then("my account is logged in with a successfull validation by user name visibility")
	public void my_account_is_logged_in_with_a_successfull_validation_by_user_name_visibility() {
		
		SignUpNowPGPage now = new SignUpNowPGPage(base.getDriver(), report, log);
		now.verifyLogin();
		
	}

	@When("I click on the US-english language button on top")
	public void i_click_on_the_us_english_language_button_on_top() {
		HomePage home = new HomePage(base.getDriver(), report, log);
		home.clickOnChangeLanguageButton();
	}
	@When("I choose Canada french as language from the popup")
	public void i_choose_canada_french_as_language_from_the_popup() {
		HomePage home = new HomePage(base.getDriver(), report, log);
		home.clickOnCanadaFrench();
	}
	
	@Then("the language is changed to canada french")
	public void the_language_is_changed_to_canada_french() {
		HomePage home = new HomePage(base.getDriver(), report, log);
		home.verifyFrench();
	}
	
	@When("I click on the cant find stain link")
	public void i_click_on_the_cant_find_stain_link() {
		HomePage home = new HomePage(base.getDriver(), report, log);
		home.clickOnCantFindStain();
	}
	@When("I search Grease as the stain type and click on the result")
	public void i_search_grease_as_the_stain_type_and_click_on_the_result() throws IOException, InterruptedException {
		
		String greaseStain = ExcelReading.extractCell(7, 3);
		
	    HowToRemoveStainsPage howto = new HowToRemoveStainsPage(base.getDriver(), report, log);
	    howto.SearchGreaseStain(greaseStain);
	}
	@Then("I am on the article for Grease stain removal")
	public void i_am_on_the_article_for_grease_stain_removal() throws InterruptedException {
	    GreaseStainPage grease = new GreaseStainPage(base.getDriver(), report, log);
	    grease.isGreaseContentPresent();
	}
	
	@When("I click on savings sticky banner")
	public void i_click_on_savings_sticky_banner() {
		HomePage home = new HomePage(base.getDriver(), report, log);
		home.clickOnSavingsBanner();
	}
	
	@When("I enter ten in the number of washes")
	public void i_enter_ten_in_the_number_of_washes() throws IOException {
		
		String numberOfWash = ExcelReading.extractCell(8, 3);
		
		SavingsCalculatorPage savings = new SavingsCalculatorPage(base.getDriver(), report, log);
		savings.calculateSavingsForTenWash(numberOfWash);
	}
	
	@Then("I am shown my savings for ten cold washes")
	public void i_am_shown_my_savings_for_ten_cold_washes() {

		SavingsCalculatorPage savings = new SavingsCalculatorPage(base.getDriver(), report, log);
		savings.verfiySavings();
	}
	
	@When("I click on contact us link")
	public void i_click_on_contact_us_link() {
	    HomePage home = new HomePage(base.getDriver(), report, log);
	    home.clickOnContactUs();
	}
	
	@Then("I am able to see different ways to contact")
	public void i_am_able_to_see_different_ways_to_contact() throws InterruptedException {
		ContactUsPage contact = new ContactUsPage(base.getDriver(), report, log);
		contact.checkIFrameVisibility();
	}
	
	@When("I search for pods")
	public void i_search_for_pods() throws IOException {
	   
		String searchQuery = ExcelReading.extractCell(9, 3);
		 HomePage home = new HomePage(base.getDriver(), report, log);
		 home.search(searchQuery);
	}
	
	@Then("I am able to product related to pods in the search result")
	public void i_am_able_to_product_related_to_pods_in_the_search_result() {
	  
		SearchResultsPage search = new SearchResultsPage(base.getDriver(), report, log);
		search.checkSearchResults();
	}
	
	@When("I open all the part company websites using the logos on the homepage")
	public void i_open_all_the_part_company_websites_using_the_logos_on_the_homepage() {
		 HomePage home = new HomePage(base.getDriver(), report, log);
		 home.openPartCompanySites();
	}
	
	
	@Then("correct websites of the part companies are loaded")
	public void correct_websites_of_the_part_companies_are_loaded() throws InterruptedException {
		 HomePage home = new HomePage(base.getDriver(), report, log);
		 home.verifyPartCompanySites();
	}
	
	@When("I click on the Live chat link and go to chat window if Start Chat button is available")
	public void i_click_on_the_live_chat_link_and_go_to_chat_window_if_start_chat_button_is_available() throws InterruptedException {
		
		HomePage home = new HomePage(base.getDriver(), report, log);
		home.navigateToChatWindow();
		
	}
	
	
	@When("I enter the required details and go through the flow")
	public void i_enter_the_required_details_and_go_through_the_flow() throws IOException {
	   
		String firstName = ExcelReading.extractCell(10, 3);
		String lastName = ExcelReading.extractCell(11, 3);
		String email = ExcelReading.extractCell(12, 3);
		
		ChatWindow chat = new ChatWindow(base.getDriver(), report, log);
		chat.continueChat(firstName, lastName, email);
	}
	
	
	@Then("I am in a live chat session with the representative")
	public void i_am_in_a_live_chat_session_with_the_representative() throws IOException, InterruptedException {
		
		String hiMessage = ExcelReading.extractCell(13, 3);
		
		ChatWindow chat = new ChatWindow(base.getDriver(), report, log);
		chat.verifyAndSendMessage(hiMessage);
	}
	
	@When("I click on Browse by Need and click on Freshness\\/Scent from the popup")
	public void i_click_on_browse_by_need_and_click_on_freshness_scent_from_the_popup() throws InterruptedException {
		
		HomePage home = new HomePage(base.getDriver(), report, log);
		home.goToFreshnessPageThroughBrowseByNeed();
	}
	
	
	@Then("I am redirected to Freshness Page where I find the product related to freshness")
	public void i_am_redirected_to_freshness_page_where_i_find_the_product_related_to_freshness() {
	    
		FreshnessPage fresh = new FreshnessPage(base.getDriver(), report, log);
		fresh.isFebrezePresent();
		
	}
	
	
	@After
	public  void tearDown(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
			log.getLog().error("Taking the screenshot for the failed test scenario");
			base.getDriver().quit();
			
		} else if(Base.skipFlag == true) {
			
			final byte[] screenshot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
			log.getLog().error("Taking the screenshot for the skipped test scenario");
			base.getDriver().quit();
			Base.skipFlag = false;
			
		} else {
			//when test case is passing
			base.getDriver().quit();
		}
	}
		
	
}

	

