package selenium.test.sentrifugo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        //PageFactory.initElements(driver, LoginPage,class);
        // we use this annotation when we need to initialize webElement from page class
    }
    @FindBy(id="username")//it will find the element with given locators
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="loginsubmit")
    WebElement loginButton;

    @FindBy(xpath="//div[contains(text(), 'username')]")
    WebElement errorMessage;


   //crate one method takes two params username and password
    //this method will login to the page with given credentials
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public String getErrorText(){
        return errorMessage.getText().trim();
    }
}
