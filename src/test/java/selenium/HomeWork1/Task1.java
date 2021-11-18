package selenium.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task1 {
    @Test
    public void task1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");


        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement input : elements) {
            boolean actual = input.isDisplayed();
            boolean expected = true;
            Assert.assertEquals(actual, expected);
        }
    }
        @Test
        public void hasCheckAll () {

            WebDriverManager.chromedriver().setup();
            WebDriver driver= new ChromeDriver();
            driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

            WebElement has = driver.findElement(By.xpath("//input[@type='button']"));
            String act = has.getAttribute("value");
            String exp = "Check All";
            Assert.assertEquals(act, exp);
        }
        @Test
        public void select() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

            WebElement all = driver.findElement(By.xpath("//input[@id='check1']"));
            all.click();
            boolean act = all.isDisplayed();
            boolean exp = true;
            Assert.assertEquals(act,exp);

            WebElement un = driver.findElement(By.xpath("//input[@class='cb1-element']"));
            boolean selected = un.isSelected();
            Assert.assertTrue(selected);










    }
}
