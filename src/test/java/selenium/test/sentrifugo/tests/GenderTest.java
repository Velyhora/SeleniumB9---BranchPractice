package selenium.test.sentrifugo.tests;

import selenium.test.sentrifugo.page.GenderPage;
import selenium.test.sentrifugo.page.HomePage;
import selenium.test.sentrifugo.page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GenderTest {

    WebDriver driver;
    LoginPage loginPage;
    SoftAssert softAssert;
    HomePage homePage;
    GenderPage genderPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        genderPage = new GenderPage(driver);
    }
    @Test
    public void validateErrorMessage() throws InterruptedException {
       loginPage.login("EM01","sentrifugo");
       homePage.clickGenderButton();
       genderPage.clickAddButton();
       genderPage.clickSaveButton();
       Thread.sleep(600);
       String actualGenderCodeMessage= genderPage.getGenderCodeError();
       String expectedGenderCodeMessage ="Please enter gender code.";

       softAssert.assertEquals(actualGenderCodeMessage,expectedGenderCodeMessage);

       String actualGenderNameMessage= genderPage.getGenderNameError();
       String expectedGenderNameMassage="Please enter gender.";
       softAssert.assertEquals(actualGenderNameMessage,expectedGenderNameMassage);

       softAssert.assertAll();

    }
    @Test
    public void validateGenderSelected(){
        loginPage.login("EM01","sentrifugo");
        homePage.clickGenderButton();
        String actualSelectedValue= genderPage.getGenderClassAttribute();
        String expectedSelectedValue="side-menu-selected";
        softAssert.assertEquals(actualSelectedValue,expectedSelectedValue);
        String actualColor= genderPage.getGenderColor();
        String expectedColor="rgba(52, 152, 219, 1)";
        softAssert.assertEquals(actualColor,expectedColor);
        softAssert.assertAll("Color validation.");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
