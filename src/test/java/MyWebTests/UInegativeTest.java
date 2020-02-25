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
import sun.font.EAttribute;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertEquals;

public class UInegativeTest {
    WebDriver driver;
    WebDriverWait waitForPresence;
    /*Logger logger = LogManager.getLogger(UInegativeTest.class);*/

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        waitForPresence = new WebDriverWait(driver, 15);
        /*logger.debug("Class " + UInegativeTest.class + " initialized with driver");
        logger.info("Start initializing class");*/
    }

    @Parameters({"exp"})
    @Test
    public void checkStyle2(String color) throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
        /*logger.debug("HomePage was opened," + driver.getCurrentUrl() + ", method is working, Url is available");
        logger.info("HomePage was opened");
        logger.error("HomePage wasn't opened");*/
        By callBack = By.xpath("//a[@class='callback-btn']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(callBack));
        WebElement callBackEl = driver.findElement(callBack);
        callBackEl.click();
        /*logger.debug("Callback was clicked, method is working, locator is available");
        logger.info("Callback was clicked");*/

        By sendInput = By.xpath("//input[@value='Надіслати']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(sendInput));
        WebElement sendEl = driver.findElement(sendInput);
        sendEl.click();
        /*logger.debug("SendEl was clicked, method is working, locator is available");
        logger.info("SendEl was clicked");*/



        By nameInput = By.xpath("//input[@name='name']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(nameInput));
        WebElement nameEl = driver.findElement(nameInput);
        waitForPresence.until(ExpectedConditions.attributeContains(nameEl, "style", color));

        String actual = nameEl.getAttribute("style");
        System.out.println(actual);
        String expected = color;
        assertEquals(actual, expected,
                String.format("Expected %s to be equal %s", actual, expected));

        By phoneInput = By.xpath("//input[@name='phone']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(phoneInput));
        WebElement phoneEl = driver.findElement(phoneInput);
        waitForPresence.until(ExpectedConditions.attributeContains(phoneEl, "style", color));

        String actualSecond = phoneEl.getAttribute("style");
        System.out.println(actualSecond);
        String expectedSecond = color;
        assertEquals(actualSecond, expectedSecond,
                String.format("Expected %s to be equal %s", actualSecond, expectedSecond));
        /*logger.debug("PhoneEl style was right, method is worked, locator is available");
        logger.info("PhoneEl style was right");*/
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
