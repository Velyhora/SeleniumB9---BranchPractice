package selenium.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4 {
    @Test
    public void x(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName= driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

        password.sendKeys("secret_sauce");
        userName.sendKeys("standard_user");
        WebElement login = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        login.click();

        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actual,expected);



    }
}
