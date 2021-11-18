package selenium.WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WP {
    @Test
    public void windowTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement cliclButton = driver.findElement(By.xpath("//a[.='Click Here' ]"));
        cliclButton.click();

        String mainWindow= driver.getWindowHandle(); // return page id from current driver location
        Set<String > windows = driver.getWindowHandles();
        System.out.println(mainWindow);
        // 123 // 123 - 124
        for (String window :windows){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
                 driver.close(); // will close the current window

                //if the window id is not equals to thee mainWindow id them switch to that window id

            }
        }

        driver.switchTo().window(mainWindow);
        cliclButton.click();
        driver.quit(); // it will close the driver
        System.out.println(driver.getCurrentUrl()); //NoSuchSessionExeption

    }
}


