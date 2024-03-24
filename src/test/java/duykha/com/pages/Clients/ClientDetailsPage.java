package duykha.com.pages.Clients;

import duykha.com.keywords.WebUI;
import static duykha.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.lang.model.element.Name;

public class ClientDetailsPage extends AddNewClientPage {

    By clientInfo = By.xpath("//a[normalize-space()='Client info']");

    public void checkClientDetails(){
        WebUI.waitForPageLoaded();
       clickElement(clientInfo);
       WebUI.sleep(4);
        Assert.assertEquals(getAttributeElement(inputName,"value"), "hongmai");
        Assert.assertEquals(getAttributeElement(inputCity,"value"), "TPHCM");
        Assert.assertEquals(getAttributeElement(inputCountry,"value"), "vietnam");

    }
}
