package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.GoogleHomePage;
import pages.GoogleSearchResultPage;
import selenium.Utils.Driver;

public class GoogleStepDefs {
    WebDriver driver;
    GoogleHomePage googleHomePage;
    GoogleSearchResultPage googleSearchResultPage;

    @When("user navigates to google.com")
    public void user_navigates_to_google_com() {
        driver= Driver.getDriver();
        driver.get("https://www.google.com/");
    }
    @When("user searches for java programming language")
    public void user_searches_for_java_programming_language() {
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.googleSearch("java programming language");

    }

    @Then("user should see more than {int} results")
    public void user_should_see_more_than_results(Integer expectedResult) {
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        int actualResult = googleSearchResultPage.getResultStatsCount();
        Assert.assertTrue(actualResult>expectedResult);

    }
    @When("user searches cucumber for java")
    public void user_searches_cucumber_for_java() {
        googleHomePage= new GoogleHomePage(driver);
        googleHomePage.googleSearch("cucumber for java");

    }
    @Then("user should get more than {int} links")
    public void user_should_get_more_than_links(Integer expectedLinksCount) {

        googleHomePage= new GoogleHomePage(driver);
        int actualLinksCount = googleSearchResultPage.getResultLinksCount();
        Assert.assertTrue(actualLinksCount>expectedLinksCount);

    }
}
