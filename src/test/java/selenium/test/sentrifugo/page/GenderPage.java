package selenium.test.sentrifugo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenderPage {
    public GenderPage (WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="86")
    WebElement gender;

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(id="submitbutton")
    WebElement saveButton;

    @FindBy(id="errors-gendercode")
    WebElement genderError;

    @FindBy(id="errors-gendername")
    WebElement genderNameError;

    public String getGenderCodeError(){
        return genderError.getText().trim();
    }
    public String getGenderNameError(){
        return genderNameError.getText().trim();
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public String getGenderClassAttribute(){
        return gender.getAttribute("class").trim();
    }
    public String getGenderColor(){
        return gender.getCssValue("color").trim();
    }
    public void clickAddButton(){
        addButton.click();
    }

}
