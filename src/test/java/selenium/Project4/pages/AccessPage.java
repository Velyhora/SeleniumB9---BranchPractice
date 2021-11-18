package selenium.Project4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessPage {

    public AccessPage (WebDriver driver){
        PageFactory.initElements(driver,this);


    }
    @FindBy(id = "username")
    WebElement uName;

    @FindBy(id = "password")
    WebElement psw;

    @FindBy(xpath = "//button[.='Log in ']")
    WebElement logIn;

    @FindBy(xpath = "//i[@class='glyphicon glyphicon-new-window']")
    WebElement clickSwitch;

    @FindBy(id = "myModalLabel")
    public WebElement textSwitchEmployee;

    @FindBy(xpath = "//p[contains(text(),'Select The Employee to Switch Into')]")
   public WebElement selectEmployeeToSwitchInto;

    @FindBy(xpath = "//b[@role='presentation']")
    public WebElement select1;

    @FindBy(xpath = "//div[@class='select2-result-label' and @id='select2-result-label-3']")
    public WebElement select2;

    @FindBy(xpath = "//button[contains(text(),'Switch')]")
    public WebElement switchLala;

    @FindBy(xpath ="//a[contains(text(),'Lala Lamees')]")
   public WebElement lala;

    @FindBy(xpath = "//a[.=' Changed To ']")
    public WebElement textChange;

    @FindBy(xpath = "//i[@class='fa fa-circle text-warning']")
    public WebElement brownColor;

    public void login(String username, String password){

        this.uName.sendKeys(username);
        this.psw.sendKeys(password);
        logIn.click();

    }

    public void switchClick() throws InterruptedException {
        clickSwitch.click();








    }


}
