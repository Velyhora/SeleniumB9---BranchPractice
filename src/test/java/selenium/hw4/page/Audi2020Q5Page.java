package selenium.hw4.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Audi2020Q5Page {
    public Audi2020Q5Page(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath ="//span[.='SUVs & Wagons' and @class='audi-link-m']" )
    WebElement suvAndWagons;
    @FindBy(xpath = "//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
    WebElement closingPupUps;

    @FindBy(xpath = "//span[.='SUVs & Wagons']//parent ::div//following-sibling::ul")
    WebElement listOfSuvAndWagons;

    @FindBy(xpath = "//div[@class='nm-model-band-container-headline']//span[text()='SUVs & Wagons']/..//following-sibling::ul/li")
    List<WebElement> allTheListOfNameSUVW;

    @FindBy(xpath = "//div[@class='nm-model-band-container-headline']//span[text()='SUVs & Wagons']/..//following-sibling::ul/li//span[.='2022 Audi Q5']")
    WebElement clickingAudiQ5;

    @FindBy(xpath = "//a[@class='sc-fzplWN jUhXVT']")
    WebElement buildButton;

    public void svuClick(){
        closingPupUps.click();
        suvAndWagons.click();

    }
    public void clickBuildButton() {
        buildButton.click();
    }



}
