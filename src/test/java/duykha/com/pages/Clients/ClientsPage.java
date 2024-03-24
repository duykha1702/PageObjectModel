package duykha.com.pages.Clients;

import duykha.com.keywords.WebUI;
import static duykha.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ClientsPage {
    private String PAGE_URL = "https://rise.fairsketch.com/clients";
    private String PAGE_TEXT = "Clients";
    private By headerPageClient = By.xpath("//a[@role='presentation'][normalize-space()='Clients']");
    private By buttonAddClient= By.xpath("//a[normalize-space()='Add client']");

    private By inputSearch = By.xpath("//input[@type='search']");

    private By tdName = By.xpath("//table[@id='client-table']//tbody/tr/td[2]");
    private By client = By.xpath("//a[@role='presentation'][normalize-space()='Clients']");

    public void verifyClientPage(){
        //Kiem tra cai URL
        //Kiem tra text chi co trang Client
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Clients");
        Assert.assertEquals(getTextElement(headerPageClient),PAGE_TEXT,"HeaderPage chưa đúng trang Clients");
    }

    public AddNewClientPage clickonAddClient(){
        WebUI.waitforElementVisible(buttonAddClient,10);
       clickElement(buttonAddClient);

        return new AddNewClientPage();
    }
    public void searchClient(String NAME){
        WebUI.sleep(3);

        clickElement(client);
        WebUI.sleep(3);
        setText(inputSearch,NAME);
        WebUI.sleep(3);
    }

    public ClientDetailsPage clickonFirstRowName(){
        WebUI.sleep(3);
       clickElement(tdName);
        WebUI.sleep(3);
        return new ClientDetailsPage();

    }
}
