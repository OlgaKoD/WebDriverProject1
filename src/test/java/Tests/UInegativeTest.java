package test.java.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class UInegativeTest {
    WebDriver driver;
    WebDriverWait waitForPresence;

    @BeforeMethod
    public void SetUp(ITestContext context) {
        System.setProperty(PropertyLoader.getProperty("wDriver"), PropertyLoader.getProperty("driverFile"));
        driver = new ChromeDriver();
        context.setAttribute(PropertyLoader.getProperty("strDriver"), driver);
        waitForPresence = new WebDriverWait(driver, 15);
    }

    @Parameters({"exp"})
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkStyleSecond(String color) throws InterruptedException {
        driver.get(PropertyLoader.getProperty("uaLink"));
        By callBack = By.xpath("//a[@class='callback-btn']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(callBack));
        WebElement callBackEl = driver.findElement(callBack);
        callBackEl.click();

        By sendInput = By.xpath("//input[@value='Надіслати']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(sendInput));
        WebElement sendEl = driver.findElement(sendInput);
        sendEl.click();

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
        assertNotEquals(actualSecond, expectedSecond,
                String.format("Expected %s to be equal %s", actualSecond, expectedSecond));
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
