package test.java.MyWebTests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class UIpositiveTest {
    WebDriver driver;
    WebDriverWait waitForPresence;
    Logger logger = LogManager.getLogger(UIpositiveTest.class);

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        waitForPresence = new WebDriverWait(driver,15);
        logger.debug("Class " + UIpositiveTest.class + " initialized with driver");
        logger.info("Start initializing class");
    }

    @Parameters({"phone"})
    @Test
    public void checkStyleFirst(String ph) throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
        logger.debug("HomePage was opened," + driver.getCurrentUrl() + ", method is working, Url is available");
        logger.info("HomePage was opened");
        logger.error("HomePage wasn't opened");
        By callBack = By.xpath("//a[@class='callback-btn']");
        WebElement callBackEl = driver.findElement(callBack);
        waitForPresence.until(ExpectedConditions.elementToBeClickable(callBack));
        callBackEl.click();

        By nameInput = By.xpath("//input[@name='name']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(nameInput));
        WebElement nameEl = driver.findElement(nameInput);
        nameEl.sendKeys("Vasiliy Pupkin");
        logger.debug("Name Vasiliy Pupkin was input, method is working, locator is available");
        logger.info("Name Vasiliy Pupkin was input");

        By phoneInput = By.xpath("//input[@name='phone']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(phoneInput));
        WebElement phoneEl = driver.findElement(phoneInput);
        phoneEl.sendKeys(ph);
        logger.debug("Phone number was input, method is working, locator is available");
        logger.info("Phone number was input");


        By sendInput = By.xpath("//input[@value='Надіслати']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(sendInput));
        WebElement sendEl = driver.findElement(sendInput);
        sendEl.click();
        logger.debug("SendEl was clicked, method is working, locator is available");
        logger.info("SendEl was clicked");


        By callBackMsg = By.xpath("//*[@class='b-header-contacte-phone-thank']");
        waitForPresence.until(ExpectedConditions.presenceOfElementLocated(callBackMsg));
        WebElement callBackMsgEl = driver.findElement(callBackMsg);
        String actual = callBackMsgEl.getText();
        logger.debug("Callback Msg was received, method is working, locator is available");
        logger.info("Callback Msg was received");

        String expected = "Äÿêóºìî!\n" +
                "Íàø ìåíåäæåð çâ'ÿæåòüñÿ ç Âàìè.";
        assertEquals(actual, expected,
                String.format("Expected %s to be equal %s", expected, actual));
        logger.debug("Callback Msg was right, method is worked, locator is available");
        logger.info("Callback Msg was right");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

