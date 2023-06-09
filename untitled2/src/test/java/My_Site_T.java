import My_Site.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class My_Site_T {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    StartPage startPage;
    Screenshot screenshot;

    private String mySite = "http://localhost:3000";

    @BeforeClass
    public void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void RegisterNewUser(){
        String email = "TestUser@gmail.com", password = "123456AA", username = "Oleg";
        driver.get(mySite);
        startPage = new StartPage(driver);
        startPage.registerButton();
        registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(username,email,password);
    }

    @Test
    public void loginUser() throws IOException, InterruptedException {
        String email = "Oleg2362@gmail.com", password = "asdq234df";
        driver.get(mySite);
        startPage = new StartPage(driver);
        startPage.loginUser();
        loginPage = new LoginPage(driver);
        loginPage.loginUser(email,password);
        screenshot = new Screenshot();
        screenshot.Screenshot(driver,"PageOleg");
    }

    @Test
    public void AddNewFriend(){
        String email = "Oleg2362@gmail.com", password = "asdq234df";
        driver.get(mySite);
        startPage = new StartPage(driver);
        startPage.loginUser();
        loginPage = new LoginPage(driver);
        loginPage.loginUser(email,password);
        homePage = new HomePage(driver);
        homePage.addNewFriend();
    }

    @AfterClass
    public void endTest() throws IOException, InterruptedException {
        screenshot.Screenshot(driver,"rezult");
    }

}
