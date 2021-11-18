package selenium.HomeWork1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {
    @Test
    public void t() {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement chelAll = driver.findElement(By.id("check1"));
        boolean act = chelAll.isDisplayed();
        Assert.assertTrue(act);
    }
    @Test
    public void checkAll(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement has = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        String act = has.getAttribute("value");
        String exp = "Check All";
        Assert.assertEquals(act,exp);

    }
    @Test
    public void allSelected(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement selected = driver.findElement(By.xpath("//input[@class='cb1-element']"));
        boolean notSelected= selected.isSelected();
        Assert.assertFalse(notSelected);

    }
    @Test
    public void click() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement all = driver.findElement(By.xpath("//input[@value='Check All']"));
        Thread.sleep(5000);
        all.click();

        WebElement unall = driver.findElement(By.xpath("//input[@value='Uncheck All']"));
        String  act = unall.getAttribute("value"); //?
        String exp = "Uncheck All";
        Assert.assertEquals(exp,act);

    }
    }
