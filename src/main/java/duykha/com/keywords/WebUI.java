package duykha.com.keywords;

import duykha.com.drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class WebUI {
    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static int WAIT_PAGE_LOADED_TIMEOUT = 30;


    public static void logConsole(String message) {
        System.out.println(message);
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static void openURL(String URL) {
        DriverManager.getDriver().get(URL);
        waitForPageLoaded();
        logConsole("Open URL: " + URL);

    }

    public static void clickElement(By by) {
        waitforElementVisible(by);
        highlightElement(by);
        getWebElement(by).click();
        logConsole("Click on element: " + by);
    }

    public static void clearElement(By by) {
        waitforElementVisible(by);
                 getWebElement(by).clear();
        logConsole("Clear on element: " + by);
    }

    public static String getCurrentURL() {
        waitForPageLoaded();
        logConsole("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
        return DriverManager.getDriver().getCurrentUrl();


    }

    public static void setText(By by, String value) {
        waitforElementVisible(by);
        getWebElement(by).sendKeys(value);
        logConsole("Set Text" + value + " on element" + by);

    }

    public static String getTextElement(By by) {
        waitforElementVisible(by);
        logConsole("Get Text of element: " + by);
        logConsole("==> Text: " + getWebElement(by).getText());
        return getWebElement(by).getText();
    }

    public static String getAttributeElement(By by, String attributeName) {
        waitforElementVisible(by);
        logConsole("Get attribute value of element" + by);
        logConsole("==> Attribute value: " + getWebElement(by).getAttribute(attributeName));
        return getWebElement(by).getAttribute(attributeName);
    }

    public static void scrollToElement(By by) {
        waitforElementPresent(by);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));


    }

    public static void hoverOnElement(By by) {
        waitforElementVisible(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(by));
        logConsole("Hover on element" + by);

    }

    public static WebElement highlightElement(By by) {
        waitforElementVisible(by);
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {

            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);


    }

    public static void rightClickElement(By by) {
        waitforElementVisible(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.contextClick(getWebElement(by));
        logConsole("Right click on element" + by);

    }


    public static void sleep(double second) {

        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public static void waitforElementVisible(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitforElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }
    public static boolean verifyElementVisible(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void waitforElementPresent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitforElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitforElementClickable(By by, int second) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static Boolean checkElementExist(By by) {
        List<WebElement> listElement = DriverManager.getDriver().findElements(by);
        if (listElement.size() > 0) {
            System.out.println("Element" + by + "existing.");
            return true;
        } else {
            System.out.println("Element" + by + "not existing.");
            return false;
        }


    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();


        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");

            }
        };
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        if (!jsReady) {
            System.out.println("Javascript is NOT ready.");
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load");

            }
        }
    }

}



