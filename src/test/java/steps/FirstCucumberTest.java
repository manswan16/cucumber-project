package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstCucumberTest {

    @Given("correct {string} username")
    public void correct_username(String string) {
        System.out.println("Username passed");

    }
    @Given("correct {string} password")
    public void correct_password(String string) {
        System.out.println("Password passed");


    }
    @When("user is clicking login button")
    public void user_is_clicking_login_button() {
        System.out.println("Login button passed");


    }
    @Then("verify user logs in")
    public void verify_user_logs_in() {
        System.out.println("User logged in");


    }

}

