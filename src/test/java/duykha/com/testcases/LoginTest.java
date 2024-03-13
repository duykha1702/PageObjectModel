package duykha.com.testcases;

import duykha.com.common.BaseTest;
import duykha.com.keywords.WebUI;
import duykha.com.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    public void loginTestSuccess(){
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage(driver);

        //Gọi hàm 'login' từ LoginPage để dùng
        loginPage.login("admin@demo.com", "riseDemo");
        WebUI.sleep(2);

    }
    //@Test
//    public void loginTestInvalidEmail(){
//        //Khởi tạo đối tượng trang LoginPage
//        //Truyền driver từ BaseTest
//        loginPage = new LoginPage(driver);
//        //Gọi hàm 'login' từ LoginPage để dùng
//        loginPage.loginInvalidEmail("admin@demo.com", "riseDemo");
//        WebUI.sleep(3);
//
//    }
}
