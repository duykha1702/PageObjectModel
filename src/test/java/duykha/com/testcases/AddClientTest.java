package duykha.com.testcases;

import duykha.com.common.BaseTest;
import duykha.com.keywords.WebUI;
import duykha.com.pages.Clients.AddNewClientPage;
import duykha.com.pages.Clients.ClientDetailsPage;
import duykha.com.pages.Clients.ClientsPage;
import duykha.com.pages.DashboardPage;
import duykha.com.pages.LoginPage;
import org.testng.annotations.Test;

public class AddClientTest extends BaseTest {
    LoginPage loginPage;
    ClientsPage clientsPage;
    DashboardPage  dashboardPage;
    AddNewClientPage addNewClientPage;
    ClientDetailsPage clientDetailsPage;

    @Test
    public void testAddNewClient(){
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.login("admin@demo.com","riseDemo");
        clientsPage = dashboardPage.openClientPage();

        dashboardPage = new DashboardPage(driver);

        clientsPage.verifyClientPage();

        addNewClientPage = clientsPage.clickonAddClient();
        addNewClientPage.addDataNewClient("hongmai");

        dashboardPage.openClientPage();
        clientsPage.searchClient("hongmai");
        WebUI.sleep(3);
        clientDetailsPage = clientsPage.clickonFirstRowName();
        clientDetailsPage.checkClientDetails();

    }
}



