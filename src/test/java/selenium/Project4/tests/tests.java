package selenium.Project4.tests;

import selenium.Project4.pages.AccessPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tests {
    WebDriver driver;
    AccessPage accessPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://icehrm-open.gamonoid.com/login.php?");
        accessPage = new AccessPage(driver);


    }
    @Test
    public void validate() throws InterruptedException {
        accessPage.login("admin", "admin");
        accessPage.switchClick();
        Thread.sleep(1000);
        Assert.assertEquals(accessPage.textSwitchEmployee.getText().trim(), "Switch Employee");
        Assert.assertEquals(accessPage.selectEmployeeToSwitchInto.getText(), "Select The Employee to Switch Into");
        accessPage.select1.click();
        accessPage.select2.click();
        accessPage.switchLala.click();
        Thread.sleep(1000);
        Assert.assertEquals(accessPage.lala.getText().trim(),"Lala Lamees");
        Thread.sleep(1000);
        Assert.assertEquals(accessPage.textChange.getText().trim(),"Changed To");
        String color = accessPage.brownColor.getCssValue("Color")
                .replace("rgb(", "").replace(")", "").replace(" ", "");
        Assert.assertEquals(color, "138,109,59");



    }

}