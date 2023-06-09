package My_Site;

import BasedPage.Based_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Based_Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "css2342-user")
    private WebElement loginButton;

    @FindBy(className = "emailField")
    private WebElement email;

    @FindBy(className = "passwordField")
    private WebElement password;

    public void loginTestUser(){
        email.sendKeys("TestUser12@gmail.com");
        password.sendKeys("123456789A");
        loginButton.click();
    }

    public void loginUser(String passwordText, String emailText){
        email.sendKeys(emailText);
        password.sendKeys(passwordText);
        loginButton.click();

    }
}
