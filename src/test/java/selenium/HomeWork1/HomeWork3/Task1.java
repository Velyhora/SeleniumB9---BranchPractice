package selenium.HomeWork1.HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
    @Test
    public void demo() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.openemr.io/openemr/interface/login/login.php?site=default");

        WebElement userName= driver.findElement(By.id("authUser"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("clearPass"));
        password.sendKeys("pass");

        WebElement login= driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']"));
        login.click();
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search by any demographics']"));
        search.sendKeys("Phil");

        WebElement se1= driver.findElement(By.xpath("//button[@title='Search for patient by entering whole or part of any demographics field information']"));
        se1.click();

        //driver.switchTo().frame("logoutinnerframe");
        Thread.sleep(2000);
        driver.switchTo().frame("fin");
        Thread.sleep(2000);

        WebElement name = driver.findElement(By.xpath("//td[@class=\"sorting_1\"]"));

      String act =name.getText();
       String exp = "Belford, Phil";
        Assert.assertEquals(act,exp);

        WebElement phoneNumber = driver.findElement(By.xpath("//td[contains(text(),'333-444-2222')]"));
        String actNum = phoneNumber.getText();
        String expNum ="333-444-2222";
        Assert.assertEquals(actNum,expNum);

        WebElement  ssn = driver.findElement(By.xpath("//td[contains(text(),'333222333')]"));
        String actSSN = ssn.getText();
        String expSSN = "333222333";
        Assert.assertEquals(actSSN,expSSN);

        driver.switchTo().defaultContent();
        Actions actions = new Actions(driver);
        WebElement patientClient = driver.findElement(By.xpath("//div[contains(text(),'Patient/Client')]"));
        actions.moveToElement(patientClient).perform();
        WebElement Patients =driver.findElement(By.xpath("//div[.='Patients' and @class='menuLabel']"));
        Patients.click();
        Thread.sleep(2000);
        driver.switchTo().frame("fin");
        WebElement name1=driver.findElement(By.linkText("Belford, Phil"));
        name1.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("pat");

        WebElement dob=driver.findElement(By.xpath("//td[@id='text_DOB']"));
        String actualDob=dob.getText();
        String expectedDob="1972-02-09";
        Assert.assertEquals(actualDob,expectedDob);


    }
}
