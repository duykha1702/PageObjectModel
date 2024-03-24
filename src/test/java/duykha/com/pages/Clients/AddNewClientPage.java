package duykha.com.pages.Clients;

import duykha.com.keywords.WebUI;
import static duykha.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewClientPage extends ClientsPage {

    private String PAGE_URL = "https://rise.fairsketch.com/clients";
    private String PAGE_TEXT = "Clients";


    By clickPerson= By.xpath("//label[normalize-space()='Person']");

    By inputName = By.xpath("//input[@id='company_name']");
    //By inputOwner = By.xpath("//div[@id='select2-drop-mask']");

    By inputAddress = By.xpath("//textarea[@id='address']");
    By inputCity = By.xpath("//input[@id='city']");
    By inputCountry = By.xpath("//input[@id='country']");
    By inputPhone = By.xpath("//input[@id='phone']");

    By clickonSave = By.xpath("//button[@type='submit']");

    public void addDataNewClient(String NAME){

        WebUI.sleep(3);

        setText(inputName,NAME);

      //  driver.findElement(inputOwner).sendKeys("Sara Ann", Keys.ENTER);
        setText(inputAddress,"PhuNhuan");

        //driver.findElement(inputCity).sendKeys("TPHCM");
        setText(inputCity,"TPHCM");
        //driver.findElement(inputCountry).sendKeys("Vietnam");
        setText(inputCountry,"vietnam");

        //driver.findElement(inputPhone).sendKeys("0123456789");
        setText(inputPhone,"0123456789");


        //driver.findElement(clickonSave).click();
        clickElement(clickonSave);
        waitForPageLoaded();

    }


}
