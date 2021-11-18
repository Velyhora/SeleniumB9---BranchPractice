package selenium.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSScroll {
    @Test
    public void scrollToEnd(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");

        JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
        // scrollTo(xCord, yCord);
        //document.body.scrollHeight
        System.out.println(jsExecutor.executeScript("return document.body.scrollHeight"));
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }
    @Test
    public void scrollToElementByCord(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");

        JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
        WebElement allRight =driver.findElement(By.xpath("//p[contains(text(),'2021')]"));
       Point location= allRight.getLocation(); // getLocation method returns POINT object
        int xCord = location.getX();
        int yCord = location.getY();
        System.out.println("XCORD="+xCord);
        System.out.println("YCORD"+yCord);

        jsExecutor.executeScript("window.scrollTo("+xCord+","+yCord+")");

        driver.navigate().refresh(); //refresh he page
        jsExecutor.executeScript("history.go(0)"); //goes to the first url in history.It will refresh page as well



    }
}
