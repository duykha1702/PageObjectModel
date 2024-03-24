package duykha.com.testcases;

import duykha.com.common.BaseTest;
import duykha.com.keywords.WebUI;
import static duykha.com.keywords.WebUI.*;
import duykha.com.pages.Clients.ClientsPage;
import duykha.com.pages.DashboardPage;
import duykha.com.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
        LoginPage loginPage;
        DashboardPage dashboardPage;
        ClientsPage productsPage;
    @Test
    public void testOpenClientPage(){
        loginPage = new LoginPage();

        //Lien ket trang được xảy ra nhờ hàm Login trả về là sự khoiwr tạo của trang Dashboards
        dashboardPage= loginPage.login("admin@demo.com","riseDemo");
//        WebUI.sleep(3);
//        By total = By.xpath("//div[@class='tw-mb-3']");
//
//        System.out.println(driver.findElement(total).getText());
        //dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        productsPage = dashboardPage.openClientPage();
        productsPage.verifyClientPage();
    //        clientPage = new ClientPage(driver);


        WebUI.sleep(3);
//    }


}}
