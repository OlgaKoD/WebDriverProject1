package java.WebDriverLesson;


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

public class Program1 {
    WebDriver driver;
    WebDriverWait waitForPresence;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        waitForPresence = new WebDriverWait(driver, 15);
    }

    @Parameters({"itea", "num"})
    @Test
    public void checkPhone(String link, String numbers) throws InterruptedException {
        driver.get(link);
        By phoneblock = By.xpath("//div[@class='phones-block']/a");
        waitForPresence.until(ExpectedConditions.elementToBeClickable(phoneblock));
        WebElement phones = driver.findElement(phoneblock);

        String phone = phones.getText();
        String phone2 = phone.replaceAll(numbers, "");
        phone2 = phone2.substring(phone2.length() - 10);

        System.out.println(phone2);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

