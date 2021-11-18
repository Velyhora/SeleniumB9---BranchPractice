package selenium.HomeWork1.HomeWork2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    @Test
    public void t3(){
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
        sortDropDown.selectByValue("lohi");
        List<WebElement>prisec =driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        //String to Double
        //Pars double
        List<Double>priceDoubleList=new ArrayList();
        for (int i = 0; i <prisec.size() ; i++) {
            String price = prisec.get(i).getText().substring(1);// $29.99
            priceDoubleList.add(Double.parseDouble(price));
        }
        boolean isLowToHigh = true;
        for (int i = 0,k=1; k<priceDoubleList.size() ; i++,k++){
            if (priceDoubleList.get(i)>priceDoubleList.get(k)){
                isLowToHigh = false;
                break;
            }
        }
    }
}
