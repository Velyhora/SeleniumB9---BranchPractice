package selenium.AlertPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSAlert {

    WebDriver driver;
    SoftAssert softAssert;
    @BeforeMethod
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        softAssert= new SoftAssert();
    }
    @Test
    public void validateJSConfirm(){
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsAlert.click();

        Alert alert= driver.switchTo().alert();
        String actualText = alert.getText();

        softAssert.assertEquals(actualText, "I am a JS Confirm", "JS Confirm validation");

        alert.accept();// Ok button is clicked

        WebElement result =  driver.findElement(By.id("result"));
        String actualResult = result.getText();
       softAssert.assertEquals(actualResult,"You clicked: OK");

       jsAlert.click();
       alert.dismiss();

       String actualCancelResult = result.getText();
       softAssert.assertEquals(actualCancelResult,"You clicked: Cancel");
       softAssert.assertAll();

    }
    @Test
    public void  validateJSPrompt(){
        //click the JSPrompt
        // send Techtorial s an input
        //click okay button
        // validate You entered: TECHTORIAL IN THE RESULT

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement Pomp = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        Pomp.click();

        Alert alert= driver.switchTo().alert();
        alert.sendKeys("TECHTORIAL");
        alert.accept();

        WebElement result=driver.findElement(By.id("result"));
        String actualResult = result.getText();

        softAssert.assertEquals(result.getText(),"You entered: TECHTORIAL");
        softAssert.assertAll();





    }

}
