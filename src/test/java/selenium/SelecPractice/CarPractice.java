package selenium.SelecPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
//TASK: Select "new cars"
//	  Select "Porche"
//	  select model "911"
//	  click search button
//	  Validate the header "New and used Porsche 911 for sale" is correct

public class CarPractice {

    @Test
    public void test1()  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");

        WebElement newUsed = driver.findElement(By.id("make-model-search-stocktype"));
        WebElement make = driver.findElement(By.id("makes"));
        WebElement  model  = driver.findElement(By.id("models"));
        WebElement search = driver.findElement(By.xpath("//div[@id='by-make-tab']//button[.='Search']"));

        selectByValue(newUsed,"new");
        selectByValue(make,"porsche");
        selectByValue(model,"porsche-911");

//
//        Select select= new Select(newUsed);
//        select.selectByValue("new");
//
//        Select select1 = new Select(make);
//        select1.selectByValue("porsche");
//
//        Select select2 = new Select(model);
//        select2.selectByValue("porsche-911");

        search.click();

        WebElement resultHeader = driver.findElement(By.xpath("//*[@id='search-live-content']//h1"));

        String actual = resultHeader.getText();
        String expected = "New Porsche 911 for sale";
        Assert.assertEquals(actual,expected,"Header assertion is failed after search");

    }
    public void selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
}