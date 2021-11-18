package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.FacebookHomePage;
import selenium.Utils.Driver;

import java.util.Map;

public class FacebookStepDefs {
    WebDriver driver;
    FacebookHomePage facebookHomePage;

    @Given("I am on facebook home page")
    public void i_am_on_facebook_home_page() {
        driver= Driver.getDriver();
        driver.get("https://www.facebook.com/");


    }
    @When("I try to sign up for account")
    public void i_try_to_sign_up_for_account() {
        facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.clickToCreateNewAccount();

    }
    @When("I fill up sign up information")
    public void i_fill_up_sign_up_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> signUpInfoMap=dataTable.asMap(String.class, String.class);
        System.out.println(signUpInfoMap);
        String firstName=signUpInfoMap.get("firstName");
        String lastName=signUpInfoMap.get("lastName");
        String email=signUpInfoMap.get("email");
        String password=signUpInfoMap.get("password");
        String birthMonth=signUpInfoMap.get("birthMonth");
        String birthDay=signUpInfoMap.get("birthDay");
        String birthYear=signUpInfoMap.get("birthYear");
        String gender=signUpInfoMap.get("gender");

        facebookHomePage.fillUpRegForm(firstName,lastName,email,password,birthMonth,birthDay,birthYear);
    }
    @Then("new account is ready to be created")
    public void new_account_is_ready_to_be_created() {
        System.out.println("Account is ready to be created");

    }
    @Then("I cancel sign up form")
    public void i_cancel_sign_up_form() {
        facebookHomePage.closeRegistrationForm();
    }
    @When("I try to sign in with invalid {string} or {string}")
    public void i_try_to_sign_in_with_invalid_or(String username, String password) {
        facebookHomePage=new FacebookHomePage(driver);
        facebookHomePage.loginToFacebook(username,password);

    }
    @Then("I should get error message:{string}")
    public void i_should_get_error_message(String errorMessage) {

    }


}
