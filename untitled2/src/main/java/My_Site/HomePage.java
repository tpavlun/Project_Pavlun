package My_Site;

import BasedPage.Based_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Based_Page {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class = 'postButton']")
    private WebElement addNewPostButton;

    @FindBy(xpath = "//input[@class = 'postUserPage']")
    private WebElement postField;

    @FindBy(xpath = "//button[@class = 'addFriend']")
    private WebElement addFriendButton;

    public void addNewPost(){
        postField.sendKeys("TestPost_123");
        addNewPostButton.click();
    }

    public void addNewPostText(String postText){
        postField.sendKeys(postText);
        addNewPostButton.click();
    }

    public void addNewFriend(){
        addFriendButton.click();
    }


}
