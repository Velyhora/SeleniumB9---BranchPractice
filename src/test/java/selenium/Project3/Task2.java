package selenium.Project3;

import selenium.HomeWork1.HomeWork2.HomeworkUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class Task2 {
    @Test
    public void case2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        List<WebElement> allPrices = driver.findElements(By.xpath("//span[@itemprop='price']"));
        //size of allPrices is 28
        // Actual price size is 7
        //We need only currently displayed elements
        //We'll use isDisplayed method for finding actually displayed prices
        List<WebElement>allNames= driver.findElements(By.xpath("//a[@class='product-name']"));
        //size of allName is 14
        // Actual name size is 7
        // we should create a method for getting displayed elements from a WebElement list
        List<WebElement>displayedPrices= SeleniumProjectUtil.getDisplayedElements(allPrices);
        List<WebElement>displayedNames=SeleniumProjectUtil.getDisplayedElements(allNames);
        List<String>nameString= HomeworkUtil.getListText(displayedNames);
        //we should protect the order of the elements in the list bc that is the only way we can
        // connect them
        //Find the expensive price
        //What happen if you sort? you change the order and bc it is mutable
        //get the text and created double values for them and store in the list
        List<Double>doublePrices =SeleniumProjectUtil.getPriceFromText(displayedPrices);
        List<Double>orderPrices = SeleniumProjectUtil.getPriceFromText(displayedPrices);
        Collections.sort(orderPrices);
        //the lst element from ordered price should be biggest value;
       // then we need to find index of price from a doublePrices and call that index number from displayedNames
       Double biggest = orderPrices.get(orderPrices.size()-1);
        int biggestPricesIndex = doublePrices.indexOf(biggest);
        System.out.println(biggestPricesIndex);

        List<WebElement>allMoreButtons = driver.findElements(By.xpath("//span[.=\\\"More\\\"]"));

        new Actions(driver).moveToElement(displayedNames.get(biggestPricesIndex)).perform();
        Thread.sleep(2000);
        List<WebElement> moreButton = SeleniumProjectUtil.getDisplayedElements(allMoreButtons);
        moreButton.get(0).click();




    }
}