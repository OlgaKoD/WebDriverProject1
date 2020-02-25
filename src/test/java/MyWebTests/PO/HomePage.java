package test.java.MyWebTests.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(HomePage.class);
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        logger.debug("Class " + HomePage.class + " initialized with driver");
        logger.info("Start initializing class");
    }
    public HomePage open() {
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        logger.debug("Home page was opened," + driver.getCurrentUrl() + ", method is working, Url is available");
        logger.info("Home page was opened");
        logger.error("Home page wasn't opened");
        return this;
    }
    public HomePage selectLanguage(String lang) {
        WebElement uaLang = driver.findElement(By.xpath("(//a[@hreflang='" + lang + "'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(uaLang));
        uaLang.click();
        logger.debug("Language was selected, method is working, locator is available");
        logger.info("Language was selected");
        return this;
    }
    public HomePage openAbout() {
        WebElement aboutBtn = driver.findElement(By.xpath("//a[(contains(@href, 'about_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(aboutBtn));
        aboutBtn.click();
        logger.debug("About Btn was clicked, method is working, locator is available");
        logger.info("About Btn was clicked");
        return this;
    }
    public HomePage openVacancies() {
        WebElement vacancies = driver.findElement(By.xpath("//li[@id='menu-item-15362']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
        logger.debug("Vacancies list was opened, method is working, locator is available");
        logger.info("Vacancies list was opened");
        return this;
    }

}
