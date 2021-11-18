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

public class prarafa {
    @Test
    public void  getAllProducts(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

       WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        WebElement click = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));

        click.click();

        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List <String>actual = getProductsName(productNames);
        List<String> expected = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
       Assert.assertEquals(actual,expected);
    }
    public List<String> getProductsName(List<WebElement> options){
        List<String> optionTexts=new ArrayList<>();
        for(WebElement option: options){
            optionTexts.add(option.getText());
        }
        return  optionTexts;
    }
    }

