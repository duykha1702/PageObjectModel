package duykha.com.pages;

import duykha.com.keywords.WebUI;
import static duykha.com.keywords.WebUI.*;
import duykha.com.pages.Clients.ClientsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    //Data trong nội bộ trang
    private String PAGE_URL = "https://rise.fairsketch.com/dashboard/index/1";
    private String PAGE_TEXT = "Dashboard";

    By menuClient = By.xpath("//a[@href='https://rise.fairsketch.com/clients']");
   // By menuAllStaffs = By.xpath("//span[normalize-space()='All staffs']");



    //Các  Object


    //Hàm xây dựng
    private WebDriver driver;
    public DashboardPage(WebDriver _driver){
        driver = _driver;
        new WebUI(driver);

    }

    public void verifyDashboardPage(){
        //Kiem tra cai URL
        //Kiem tra text chi co trang Dashboard co
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Dashboard");


    }
    //Hàm xử lý
    public ClientsPage openClientPage(){
       WebUI.sleep(3);

        clickElement(menuClient);
        return new ClientsPage(driver);

    }


}
