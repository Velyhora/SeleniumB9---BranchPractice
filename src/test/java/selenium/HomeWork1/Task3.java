package selenium.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {
    @Test
    public void task(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName= driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

        password.sendKeys("Selenium");
        userName.sendKeys("Java");

        WebElement login = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        login.click();

        WebElement match= driver.findElement(By.xpath("//h3"));
        String actual = match.getAttribute("data-test");
        String expected = "error";
        Assert.assertEquals(actual,expected);


    }
}
