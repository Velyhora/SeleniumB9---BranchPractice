package selenium.Project3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    @Test
    public void t1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement empty = driver.findElement(By.xpath("//span[@class='ajax_cart_no_product']"));
        String act= empty.getText();
        String exp = "(empty)";
        Assert.assertEquals(act,exp);

        List<WebElement> prices= driver.findElements(By.xpath("//span[contains(text(), '$')]"));
        List<Double> p = new ArrayList<>();

        for (WebElement price:prices){
            if (price.getText().contains("$")){
                p.add(Double.parseDouble(price.getText().replace("$","")));

            }

        }
        Collections.sort(p);
        System.out.println(p);
        String cheapestPrice= p.get(0).toString();
        System.out.println(cheapestPrice);
        cheapestPrice = "//span[contains(text(), '"+cheapestPrice+"')]";
        List<WebElement> cheapests = driver.findElements(By.xpath(cheapestPrice));
        Thread.sleep(1000);
        List<String> stringList = new ArrayList<>();
        for (WebElement cheapest:cheapests){
            if (cheapest.isDisplayed()){
                stringList.add(cheapest.getText());
            }
        }

    }

}
//span[contains(text(), '16.4')]