package selenium.test.sentrifugo.tests;

import selenium.test.sentrifugo.page.DepartmentsPage;
import selenium.test.sentrifugo.page.HomePage;
import selenium.test.sentrifugo.page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DepartmentTest {
    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    HomePage homePage;
    DepartmentsPage DepartmentsPage;

@BeforeMethod
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.get("http://demo.sentrifugo.com/index.php/");
    driver.manage().window().maximize();
    softAssert = new SoftAssert();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    DepartmentsPage=new DepartmentsPage(driver);

}
   @Test
    public void validateAddDepartment() throws InterruptedException {
    loginPage.login("EM01","sentrifugo");
    Thread.sleep(600);
    homePage.clickDepartment();
       Thread.sleep(600);
    DepartmentsPage.clickAddButton();
       Thread.sleep(600);
    DepartmentsPage.sendDepartmentDescription("Finance","123","Techtorial Test");
    String actualMessage= DepartmentsPage.getSuccessMessage();
    String expectedMessage="Department added successfully.";
       Assert.assertEquals(actualMessage,expectedMessage,"New Department Validation");

   }
}
