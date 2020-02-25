package test.java.MyWebTests.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class EveningCoursesPage {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(EveningCoursesPage.class);

    public EveningCoursesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        logger.debug("Class " + EveningCoursesPage.class + " initialized with driver");
        logger.info("Start initializing class");

    }
    public EveningCoursesPage openHomePage() {
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
        logger.debug("HomePage was opened," + driver.getCurrentUrl() + ", method is working, Url is available");
        logger.info("HomePage was opened");
        logger.error("HomePage wasn't opened");
        return this;

    }
    public EveningCoursesPage openEveningCourses() {
        WebElement eveningCoursesBtn = driver.findElement(By.xpath("//a[(contains(@href, 'courses_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(eveningCoursesBtn));
        eveningCoursesBtn.click();
        logger.debug("Evening Courses Btn was clicked, method is working, locator is available");
        logger.info("Evening Courses Btn was clicked");
        logger.error("Evening Courses Btn wasn't clicked");
        return this;

    }
    public EveningCoursesPage openCoursesListPage() {
        WebElement coursesBtn = driver.findElement(By.id("menu-item-7871"));
        wait.until(ExpectedConditions.visibilityOf(coursesBtn));
        coursesBtn.click();
        logger.debug("Courses List Btn was clicked, method is working, locator is available");
        logger.info("Courses List Btn was clicked");
        logger.error("Courses List Btn wasn't clicked");
        return this;

    }

    public List<String> getCourseList() {
        List<String> list = new ArrayList<String>();
        List <WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='container_12 isotope 21']//h2"));
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
        for (WebElement el : listOfElements) {
            list.add(el.getText());
        }
        logger.debug("Courses list was received, method is working, locator is available");
        logger.info("Courses list was received");
        logger.error("Courses list wasn't received");
        return list;
    }
    public EveningCoursesPage goToCoursePage(String courseName) {
        WebElement coursePage = driver.findElement(By.xpath("//h2[contains(text(),'" + courseName + "')]/parent::div//a[@class='view']"));
        coursePage.click();
        logger.debug("Course page" + courseName + "was clicked, method is working, locator is available");
        logger.info("Course page" + courseName + "was clicked");
        logger.error("Course page" + courseName + "wasn't clicked");
        return this;
    }

    public EveningCoursesPage buyCourse() {
        WebElement buyButton = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        buyButton.click();
        logger.debug("Buy Btn was clicked, method is working, locator is available");
        logger.info("Buy Btn was clicked");
        logger.error("Buy Btn wasn't clicked");


        return this;
    }
    public boolean[] getDefaultConditions() {
        boolean locationBeresteikaStatus;
        boolean locationPozniakyStatus;
        boolean locationVDNHStatus;
        boolean privacyAgreementStatus;


        WebElement locationBeresteika = driver.findElement(By.xpath("//input[@id='location1']"));
        WebElement locationPozniaky = driver.findElement(By.xpath("//input[@id='location2']"));
        WebElement locationVDNH = driver.findElement(By.xpath("//input[@id='location3']"));
        WebElement privacyAgreement = driver.findElement(By.xpath("//input[@id='input-privacy-policy']"));

        locationBeresteikaStatus = locationBeresteika.isSelected();
        locationPozniakyStatus = locationPozniaky.isSelected();
        locationVDNHStatus = locationVDNH.isSelected();
        privacyAgreementStatus = privacyAgreement.isSelected();

        boolean[] result = {locationBeresteikaStatus, locationPozniakyStatus, locationVDNHStatus, privacyAgreementStatus};
        logger.trace("Check default locations and PrivacyAgreementStatus");
        logger.debug("Default locations and PrivacyAgreementStatus were right, method is worked, locators are available");
        logger.info("Default locations and PrivacyAgreementStatus were right");
        logger.warn("Please check method getDefaultConditions and locators");
        logger.error("Default locations and/or PrivacyAgreementStatus were/was wrong");
        logger.fatal("Method isn't worked and/or locators are wrong");
        return result;
    }
}
