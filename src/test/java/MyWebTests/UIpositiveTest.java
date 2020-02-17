package test.java.MyWebTests;

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

import static org.testng.Assert.assertEquals;

public class UIpositiveTest {
    WebDriver driver;
    WebDriverWait waitForPresence;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        waitForPresence = new WebDriverWait(driver,15);
    }

    @Parameters({"phone"})
    @Test
    public void checkStyle1(String ph) throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
        By callBack = By.xpath("//a[@class='callback-btn']");
        WebElement callBackEl = driver.findElement(callBack);
        waitForPresence.until(ExpectedConditions.elementToBeClickable(callBack));
        callBackEl.click();

        By nameInput = By.xpath("//input[@name='name']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(nameInput));
        WebElement nameEl = driver.findElement(nameInput);
        nameEl.sendKeys("Vasiliy Pupkin");

        By phoneInput = By.xpath("//input[@name='phone']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(phoneInput));
        WebElement phoneEl = driver.findElement(phoneInput);
        phoneEl.sendKeys(ph);


        By sendInput = By.xpath("//input[@value='Надіслати']");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(sendInput));
        WebElement sendEl = driver.findElement(sendInput);
        sendEl.click();


        By callBackMsg = By.xpath("//*[@class='b-header-contacte-phone-thank']");
        waitForPresence.until(ExpectedConditions.presenceOfElementLocated(callBackMsg));
        WebElement callBackMsgEl = driver.findElement(callBackMsg);
        String actual = callBackMsgEl.getText();

        String expected = "Дякуємо!\n" +
                "Наш менеджер зв'яжеться з Вами.";
        assertEquals(actual, expected,
                String.format("Expected %s to be equal %s", expected, actual));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

