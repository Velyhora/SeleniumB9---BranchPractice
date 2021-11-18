package selenium.FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {
    @Test
    public void validaFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement choseFile= driver.findElement(By.id("file-upload"));
        choseFile.sendKeys("C:/Users/velyh/Downloads/techtorial.png");// we need to send the location of the file.

        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.submit();
        //submit() method : 1 - it should be under the form tag
        // 2 - input tag type should be "submit"
        WebElement text= driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(text.getText().trim(),"techtorial.png");

    }
}
