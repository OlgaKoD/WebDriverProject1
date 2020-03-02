package test.java.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.PropertyLoader;
import test.java.utils.Screenshot;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void SetUp(ITestContext context) {
        System.setProperty(PropertyLoader.getProperty("wDriver"), PropertyLoader.getProperty("driverFile"));
        driver = new ChromeDriver();
        context.setAttribute(PropertyLoader.getProperty("strDriver"), driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

