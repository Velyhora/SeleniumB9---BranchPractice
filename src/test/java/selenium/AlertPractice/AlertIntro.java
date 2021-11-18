package selenium.AlertPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertIntro {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        //it will one time before each test annotation
    }

    @Test
    public void htmlPopup() throws InterruptedException {
        //Navigate to the sweetAlert page
        // click sweetAlert
        //Validate "Something went wrong!" is displayed
        //close popup
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://sweetalert.js.org/");

        WebElement prewieButton = driver.findElement(By.xpath("//button[contains(@onclick, 'swal')]"));
        JavascriptExecutor js =(JavascriptExecutor)  driver;
        js.executeScript("arguments[0].click()",prewieButton);

        Thread.sleep(1000);

        WebElement errorMessage= driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualMassage = errorMessage.getText();
        Assert.assertEquals(actualMassage,"Something went wrong!");
        Assert.assertTrue(errorMessage.isDisplayed());

        WebElement okButton= driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();


        //Assert.assertFalse(okButton.isDisplayed());

    }
    @Test
    public void javaScriptAlert(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://sweetalert.js.org/");

        WebElement previewButton = driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]"));
        previewButton.click();

        Alert alert = driver.switchTo().alert();
        String actualErrMessage = alert.getText();
        Assert.assertEquals(actualErrMessage,"Oops, something went wrong!");

        alert.accept(); // (OK BUTTON)

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
        // it will be executed after each test annotation
        //we use it to quit the driver
        // later we will use afterMethod annotation to tke a screenshot as well
    }
}
