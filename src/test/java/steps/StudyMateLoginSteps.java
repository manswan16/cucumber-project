package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudyMateLoginSteps {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

    }
    @When("the user enters correct {string} username")
    public void the_user_enters_correct_username(String username) {
        System.out.println("passed username " + username);


    }
    @When("there is correct {string} password")
    public void there_is_correct_password(String password) {
        System.out.println("passed password " + password);


    }
    @When("the user click the login button")
    public void the_user_click_the_login_button() {

    }
    @Then("verify the user logs in successfully")
    public void verify_the_user_logs_in_successfully() {

    }
}
