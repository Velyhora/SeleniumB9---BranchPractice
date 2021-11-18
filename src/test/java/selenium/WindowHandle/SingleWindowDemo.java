package selenium.WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class SingleWindowDemo {
   /*
   Task https://www.seleniumeasy.com/test/window-popup-modal-demo.html
   click follow us on twitter
   send username to the page
    */
    @Test
    public void validateSingleWindow() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

        WebElement twitter = driver.findElement(By.xpath("//a[@href='https://twitter.com/intent/follow?screen_name=seleniumeasy']"));
        twitter.click();
        String mainWindow= driver.getWindowHandle();
        Set<String > windows = driver.getWindowHandles();

        for (String window:windows){
            if (!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }
        }
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("techtorialschool");

    }
}
