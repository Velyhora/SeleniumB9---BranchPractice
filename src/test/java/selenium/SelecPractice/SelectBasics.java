package selenium.SelecPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectBasics {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement options = driver.findElement(By.id("dropdown"));
        Select select = new Select(options);
        select.selectByVisibleText("Option 1");

        Thread.sleep(2000); // it will pause the code in this line 2 sec

        select.selectByValue("2");
        Thread.sleep(2000);
        select.selectByIndex(1);



    }
}
