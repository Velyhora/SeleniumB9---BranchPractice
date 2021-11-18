package selenium.IFrame;

import selenium.Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeIntro {
    /*
    1- go to https://the-internet.herokuapp.com/
    2 - click frames
    3 - ckickiFrame
    4- send "Hello Techtorial" to the input box
     */
    @Test
    public void validateIframe(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement frame = driver.findElement(By.xpath("//a[@href='/frames']"));
        frame.click();

        WebElement iframe = driver.findElement(By.xpath("//a[@href='/iframe']"));
        iframe.click();

        driver.switchTo().frame("mce_0_ifr");
        //it will switch to the inner frame with given id
        //this id, index , or webelement should be belongs to the iframe

        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys(("Hello Techtorial"));

        //assert that hello Techtorial entered
        //clear the text
        // validate empty page

        String actual = textBox.getText();
        String expected = "Hello Techtorial";
        Assert.assertEquals(actual,expected,"Text Box Validation");

        textBox.clear();

        Assert.assertTrue(textBox.getText().trim().isEmpty());

    }
    @Test
    public void nestedFrame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

//        driver.switchTo().frame("frame-top").switchTo().frame("frame-middle");
//        WebElement middle = driver.findElement(By.id("content"));
//        System.out.println(middle.getText());


          driver.switchTo().frame("frame-top");
          //under the top frame we have 3 other like left,middle , and right
          driver.switchTo().frame(1); // this will switch to the middle frame
        WebElement middleText = driver.findElement(By.id("content"));
        Assert.assertEquals(middleText.getText(),"MIDDLE");

        driver.switchTo().parentFrame();// parent frame goes to the one parent

        driver.switchTo().frame("frame-left");  // NoSuchFrameException
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertEquals(body.getText().trim(),"LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame(); //main html

        driver.switchTo().defaultContent(); // defaultContent method will switch back to the main html


        driver.switchTo().frame("frame-bottom");
         body = driver.findElement(By.tagName("body"));
        Assert.assertEquals(BrowserUtils.getText(body).trim(),"BOTTOM");


    }
}
