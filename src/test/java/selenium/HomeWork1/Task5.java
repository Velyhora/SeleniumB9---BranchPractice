package selenium.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
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

        List<WebElement> names = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List <String>actual = n(names);
        List<String> expected = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(actual,expected);
    }
    public List<String>n(List<WebElement>options){
        List<String>oprionText = new ArrayList<>();
        for (WebElement opt:options){
            oprionText.add(opt.getText());
        }
return oprionText;
    }

    }

