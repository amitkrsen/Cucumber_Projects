package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside step - User is on login page");
	}

	@When("User provides valid username and password")
	public void user_provides_valid_username_and_password() {
		System.out.println("Inside step - User provides valid username and password");
	}

	@And("Clicks on Login button")
	public void clicks_on_login_button() {
		System.out.println("Inside step - Clicks on Login button");
	}

	@Then("User lands on the home page")
	public void user_lands_on_the_home_page() {
		System.out.println("Inside step - User lands on the home page");
	}

}
