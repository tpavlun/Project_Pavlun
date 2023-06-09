package My_Site;

import BasedPage.Based_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage  extends Based_Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[text() = 'Your name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@class = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@class = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class = 'confpassword']")
    private WebElement confPasswordField;

    @FindBy(xpath = "//button[@class = 'regbutton']")
    private WebElement registerButton;

    public void registerNewUser(String username, String email, String password){
        userNameField.sendKeys(username);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confPasswordField.sendKeys(password);
        registerButton.click();
    }

}
