package selenium.HomeWork1.HomeWork2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task1 {
    @Test
    public void x() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

        password.sendKeys("secret_sauce");
        userName.sendKeys("standard_user");

        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        Select sortDropDown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        sortDropDown.selectByValue("za");
        List<WebElement>itemNames=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        //We have list of web elements and we need to get text out of them
        List<String>itemNameTexts= HomeworkUtil.getListText(itemNames);
        //All strings are list of chars
        //every char has a value
        for (String name:itemNameTexts){
            System.out.println(name);
        }

        //school road car
        boolean elementsAreInReverseOrder=true;
        for (int i = 0,k=1; k<itemNameTexts.size() ; i++,k++) {
            if (itemNameTexts.get(i).charAt(0)<itemNameTexts.get(k).charAt(0)){
                elementsAreInReverseOrder=false;
                break;
            }

        }
        Assert.assertTrue(elementsAreInReverseOrder);
    }
}
