package test.java.Tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;
import test.java.utils.RetryAnalyzer;

@Epic("Without PO")
public class FirstProgram {
    WebDriver driver;
    WebDriverWait waitForPresence;
    Logger logger = LogManager.getLogger(FirstProgram.class);

    @BeforeMethod
    public void SetUp(ITestContext context) {
        System.setProperty(PropertyLoader.getProperty("wDriver"), PropertyLoader.getProperty("driverFile"));
        driver = new ChromeDriver();
        context.setAttribute(PropertyLoader.getProperty("strDriver"), driver);
        waitForPresence = new WebDriverWait(driver, 15);
        logger.debug("Class " + FirstProgram.class + " initialized with driver");
        logger.info("Start initializing class");
    }

    @Parameters({"itea", "num"})
    @Story("Check phone number")
    @Test
    @Step("Checking phone format {numbers} for page {link}")
    public void checkPhone(String link, String numbers) throws InterruptedException {
        driver.get(link);
        logger.debug("Home page was opened," + driver.getCurrentUrl() + ", method is working, Url is available");
        logger.info("Home page was opened");
        logger.error("Home page wasn't opened");
        By phoneblock = By.xpath("//div[@class='phones-block']/a");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(phoneblock));
        WebElement phones = driver.findElement(phoneblock);

        String phone = phones.getText();
        logger.debug("Phone number was received, method is working, locator is available");
        logger.info("Phone number was received");
        String phoneSecond = phone.replaceAll(numbers, "");
        phoneSecond = phoneSecond.substring(phoneSecond.length() - 10);

        System.out.println(phoneSecond);
        logger.debug("Right phone number was printed, method is working, locator is available");
        logger.info("Right phone number was printed");
    }

    @AfterMethod
    public void tearDown() {
        saveScreenshot();
        driver.quit();
    }
    @Attachment(value = "screen", type = "image/png")
    private byte[] saveScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
