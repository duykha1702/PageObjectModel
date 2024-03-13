package duykha.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageFactory {
    private String URL = "https://rise.fairsketch.com/signin";
    private String PAGETEXT ="Sign in";

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//h2")
    private WebElement headerPage;

    //Hàm xây dựng để truyền vào driver
    private WebDriver driver;
    public LoginPageFactory(WebDriver _driver) {
        driver = _driver;
        PageFactory.initElements(driver,this)  ;
    }

      public void login(String email, String password){
        driver.get(URL);
        inputEmail.clear();
        inputPassword.clear();
        inputEmail.sendKeys("admin@demo.com");
        inputPassword.sendKeys("riseDemo");
        buttonLogin.click();
    }


}
