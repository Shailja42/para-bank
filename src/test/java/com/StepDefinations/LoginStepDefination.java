package com.StepDefinations;

import java.io.IOException;

import com.mainPages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination extends LoginPage {
	
	@Given("I launch the application")
	public void i_launch_the_application() throws IOException {
		launch();
	}

	@Given("I enter the user details and navigate to home page")
	public void i_enter_the_user_details_and_navigate_to_home_page() throws IOException, InterruptedException {
		login();
	}

	@When("I search for the product")
	public void i_search_for_the_product() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should land of list of product page")
	public void i_should_land_of_list_of_product_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
