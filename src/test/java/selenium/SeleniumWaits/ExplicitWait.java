package selenium.SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    @Test
    public void validateWat(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.tagName("button"));
        startButton.click();

        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement hello= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));
        Assert.assertEquals(hello.getText(),"Hello World!");

    }
    @Test
    public void validateImWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.tagName("button"));
        startButton.click();
        //TASK: put the condition to wait until the loading part is visible then get the text from hello element

        WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        WebElement hello= driver.findElement(By.id("finish"));
//        System.out.println(hello.getText());
       Assert.assertEquals(hello.getText(),"Hello World!");

//      WebDriverWait wait2 = new WebDriverWait(driver,10);
//      WebElement h = wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading"))));
//        System.out.println(h.getText());


    }
}
