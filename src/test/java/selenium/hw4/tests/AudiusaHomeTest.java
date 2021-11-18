package selenium.hw4.tests;

import selenium.hw4.page.Audi2020Q5Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AudiusaHomeTest {
    WebDriver driver;

    Audi2020Q5Page audi2020Q5Page;


    @BeforeMethod
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.audiusa.com/us/web/en.html");
        driver.manage().window().maximize();
        audi2020Q5Page = new Audi2020Q5Page(driver);
    }
    @Test
    public void testHomePage() throws InterruptedException {
        Thread.sleep(1000);
        audi2020Q5Page.svuClick();
        audi2020Q5Page.clickBuildButton();


    }



}
