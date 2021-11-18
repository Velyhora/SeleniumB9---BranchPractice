package selenium.SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Elements {
    public static void main(String[] args) {
       // Sestem.setProoerty("........exe);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> links = driver.findElements(By.xpath("//ul//a"));
        //Task print all the text from the links
        for (WebElement L:links) {
            System.out.println(L.getText());

        }
        //TASK print only the links has more than 10 letters
        for (WebElement link: links) {
            String linkText=link.getText();
            if (link.getText().length()>10){
                System.out.println(linkText);
                //go to the TYPOS and find the p tags and store them as list of webelement
                //than print the lenght of each text


            }
        }

        WebElement typos=driver.findElement(By.xpath("//a[.='Typos']"));
        typos.click();

        List<WebElement>ps=driver.findElements(By.xpath("//p"));
        for (WebElement p:ps){
            System.out.println(p.getText().length());
        }

    }
}
