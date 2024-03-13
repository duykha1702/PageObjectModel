package duykha.com.testcases;

import duykha.com.common.BaseTest;
import duykha.com.pages.LoginPageFactory;
import org.testng.annotations.Test;

public class LoginTestFactory extends BaseTest {
    LoginPageFactory loginPageFactory;

    @Test
    public void testLoginSuccess(){
        loginPageFactory = new LoginPageFactory(driver);
       loginPageFactory.login("admin@demo.com","riseDemo");


    }
}
