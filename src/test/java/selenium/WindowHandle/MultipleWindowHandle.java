package selenium.WindowHandle;

import selenium.Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowHandle {
    @Test
    public void MultipleWindow(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

        WebElement followAll= driver.findElement(By.id("followall"));
        followAll.click();

        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

//        for (String window: windows){
//            if (!driver.getTitle().contains("Facebook")){
//                driver.switchTo().window(window);
//            }
//        }
        BrowserUtils.switchByTitle(driver,"Facebook");
        BrowserUtils.switchByTitle(driver,"Twitter");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.switchTo().window(mainWindow);

    }
    @Test
    public void closeAllWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

        WebElement followAll= driver.findElement(By.id("followall"));
        followAll.click();

        String maidId=driver.getWindowHandle();
        BrowserUtils.closeWindows(driver,maidId);
        System.out.println(driver.getTitle());

    }
}
