package selenium.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsMethods {
    @Test
    public void keysPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement search=driver.findElement(By.name("q"));
//        search.click();
//        search.sendKeys();

        Actions actions=new Actions(driver);
        actions.moveToElement(search)
                .click()
                .keyDown(search,Keys.SHIFT)
                .sendKeys("s")
                .keyUp(search,Keys.SHIFT)
                .sendKeys("elenium")
                .doubleClick(search)
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .contextClick()
                .perform();
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.RETURN);





    }
}
