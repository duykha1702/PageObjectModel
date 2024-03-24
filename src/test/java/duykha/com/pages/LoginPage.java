package duykha.com.pages;

import duykha.com.helpers.PropertiesHelper;
import duykha.com.keywords.WebUI;
import static duykha.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private String URL = "https://rise.fairsketch.com/signin";
    private String PAGETEXT ="Sign in";

    //Lưu Object của trang Signin
    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    By headerPage = By.xpath("//h2");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Sign in']");
    By messageErrorEmail = By.xpath("//body/script[4]");


    //Hàm xây dựng để truyền vào driver

    //Viết các hàm xử lý cho trang Login
    public void verifyHeaderPage(){
        Assert.assertEquals(getTextElement(headerPage),PAGETEXT,"FAIL. HeaderPage not matching");

    }

    public void verifyErrorMessageDisplay(){
        //Assert.assertTrue(driver.findElement(messageErrorEmail).isDisplayed(),"FAIL.ErrorMessage no display");
        Assert.assertEquals(getTextElement(messageErrorEmail),"Invalid login credentials1","FAIL.ErrorMessage no match");

    }
    public void clearEmail(String email){
        clearElement(inputEmail);
    }
    public void clearPassword(String password){
        clearElement(inputPassword);
    }

    public void enterEmail(String email){

        //driver.findElement(inputEmail).sendKeys(email);
        setText(inputEmail,email);

    }
    public void enterPassword(String password){

        setText(inputPassword,password);
    }


    public void clickOnLoginButton(){
        clickElement(buttonLogin);
    }



    public DashboardPage login(String email, String password){
        openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        clearEmail(email);
        clearPassword(password);
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        return new DashboardPage();

    }
    public void loginInvalidEmail(String email, String password){
        openURL(URL);
        verifyHeaderPage();
        clearEmail(email);
        clearPassword(password);
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();


        verifyErrorMessageDisplay();

    }

}
