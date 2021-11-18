package selenium.WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindow {
    @Test
    public void openNewWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");

        System.out.println(driver.getCurrentUrl());
       // driver = new ChromeDriver(); // instanse the chrome one more time

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/apply-now');");



        String mainId = driver.getWindowHandle();
        Set<String>ids = driver.getWindowHandles();
        //System.out.println(ids);

        for (String id : ids){
            if (!id.equals(mainId)){
                driver.switchTo().window(id);
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().endsWith("apply-now"), "Apply now url validation.");
        System.out.println(driver.getCurrentUrl());

    }
}
