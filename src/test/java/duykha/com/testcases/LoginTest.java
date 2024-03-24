package duykha.com.testcases;

import duykha.com.common.BaseTest;
import duykha.com.helpers.ExcelHelper;
import duykha.com.helpers.PropertiesHelper;
import duykha.com.keywords.WebUI;
import duykha.com.listeners.TestListener;
import duykha.com.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    public void loginTestSuccess(){
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage();


        //Gọi hàm 'login' từ LoginPage để dùng
        loginPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));

        PropertiesHelper.setFile("src/test/resources/configs/data.properties");
        PropertiesHelper.setValue("label",WebUI.getTextElement(By.xpath("//span[normalize-space()='Subscriptions']")));
        WebUI.sleep(2);

    }
    @Test
    public void loginTestInvalidEmail(){
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage();
        //Gọi hàm 'login' từ LoginPage để dùng
        loginPage.loginInvalidEmail("admin@demo.com", "riseDemo");
        WebUI.sleep(3);

    }

//    @Test
//    public void loginTestSuccess2(){
//        //Khởi tạo đối tượng trang LoginPage
//        //Truyền driver từ BaseTest
//        loginPage = new LoginPage();
//        ExcelHelper excelHelper = new ExcelHelper();
//        excelHelper.setExcelFile("src/test/resources/datatest/data.xlsx","Login");
//
//        //Gọi hàm 'login' từ LoginPage để dùng
//        loginPage.login(excelHelper.getCellData("EMAIL",1),excelHelper.getCellData("PASSWORD",1));
//        excelHelper.setCellData("PAss","RESULT",1);
//
//        WebUI.sleep(2);
//
//    }
}
