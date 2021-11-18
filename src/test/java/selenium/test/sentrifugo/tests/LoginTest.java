package selenium.test.sentrifugo.tests;

import selenium.Utils.BrowserUtils;
import selenium.test.sentrifugo.data.CredData;
import selenium.test.sentrifugo.page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage = new LoginPage(driver);
        //if you do not initialize the LoginPage object
        //you can not use the webelement
    }
    //TASK: provide correct user name and password from data provider annotations


    @Test(dataProvider = "positiveCred", dataProviderClass = CredData.class)
    public void validateLoginPositive(String usernaem, String password) {
        loginPage.login(usernaem, password);

//        loginPage.username.sendKeys("EM01");
//        loginPage.password.sendKeys("sentrifugo");
//        loginPage.loginButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void validateLoginManagement() {
        loginPage.login("EM01", "sentrifugo");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl, expectedUrl);

    }
    //create one more test annotation
    //provide invalid username and password
    //validate "The user name or password you entered is incorrect"

    //TASK: Using data provider annotation test invalid credentions

//    @DataProvider( name ="credentials")
//    public Object[][] gexCred(){
//        return new Object[][]{
//                {"Techtorial","sentrifugo"},
//                {"EM01","test"},
//                {"test","test"}
//        };
//    }

    @Test(dataProvider = "credentials", dataProviderClass = CredData.class)
    public void validateNegativeLogin1(String username, String password) throws InterruptedException {
        loginPage.login(username, password);
        Thread.sleep(500);
        String actualErrMessage = loginPage.getErrorText();// it comes from website
        String expectedMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrMessage, expectedMessage);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
       // result.getTestName(); --> returns the methodName from test annotation
        if (!result.isSuccess()){
            BrowserUtils.getScreenShot(driver,"sentrifugo");

        }
        driver.quit();
    }


//    @Test(dataProvider = "credentials")
//    public void validateNegativeLogin2() throws InterruptedException {
//        loginPage.login("EM01", "test");
//        Thread.sleep(500);
//        String actualErrMessage = loginPage.getErrorText();// it comes from website
//        String expectedMessage = "The username or password you entered is incorrect.";
//        Assert.assertEquals(actualErrMessage, expectedMessage);
//    }
//
//    @Test(dataProvider = "credentials")
//    public void validateNegativeLogin3() throws InterruptedException {
//        loginPage.login("test", "test");
//        Thread.sleep(500);
//        String actualErrMessage = loginPage.getErrorText();// it comes from website
//        String expectedMessage = "The username or password you entered is incorrect.";
//        Assert.assertEquals(actualErrMessage, expectedMessage);

}