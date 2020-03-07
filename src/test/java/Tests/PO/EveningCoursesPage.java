package test.java.Tests.PO;

import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Epic("Page Object")
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
    @Link("http://iteaua-develop.demo.gns-it.com/uk/")
    @Step("Open Home page")
    public EveningCoursesPage openHomePage() {
        driver.get(PropertyLoader.getProperty("uaLink"));
        logger.debug("HomePage was opened," + driver.getCurrentUrl() + ", method is working, Url is available");
        logger.info("HomePage was opened");
        logger.error("HomePage wasn't opened");
        return this;

    }
    @Step("Open Courses menu")
    public EveningCoursesPage openEveningCourses() {
        WebElement eveningCoursesBtn = driver.findElement(By.xpath("//a[(contains(@href, 'courses_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(eveningCoursesBtn));
        eveningCoursesBtn.click();
        logger.debug("Evening Courses Btn was clicked, method is working, locator is available");
        logger.info("Evening Courses Btn was clicked");
        logger.error("Evening Courses Btn wasn't clicked");
        return this;

    }
    @Step("Open Evening courses list")
    public EveningCoursesPage openCoursesListPage() {
        WebElement coursesBtn = driver.findElement(By.id("menu-item-7871"));
        wait.until(ExpectedConditions.visibilityOf(coursesBtn));
        coursesBtn.click();
        logger.debug("Courses List Btn was clicked, method is working, locator is available");
        logger.info("Courses List Btn was clicked");
        logger.error("Courses List Btn wasn't clicked");
        return this;

    }

    @Step("Get list")
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

    @Step("Open courses page {courseName}")
    public EveningCoursesPage goToCoursePage(String courseName) {
        WebElement coursePage = driver.findElement(By.xpath("//h2[contains(text(),'" + courseName + "')]/parent::div//a[@class='view']"));
        coursePage.click();
        logger.debug("Course page" + courseName + "was clicked, method is working, locator is available");
        logger.info("Course page" + courseName + "was clicked");
        logger.error("Course page" + courseName + "wasn't clicked");
        return this;
    }

    @Step("Buy course")
    public EveningCoursesPage buyCourse() {
        WebElement buyButton = driver.findElement(By.xpath("//button[@name='roadFull_payOnce']"));
        wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        buyButton.click();
        logger.debug("Buy Btn was clicked, method is working, locator is available");
        logger.info("Buy Btn was clicked");
        logger.error("Buy Btn wasn't clicked");

        return this;
    }

    @Step("Input name {name}, email {email}, phone number {phone} and sign up for course")
    public String signUpForCourse(String name, String email, String phone) {
        By nameInput = By.xpath("//input[@id='name']");
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        WebElement nameEl = driver.findElement(nameInput);
        nameEl.sendKeys(name);
        logger.debug("Name Vasiliy Pupkin was input, method is working, locator is available");
        logger.info("Name Vasiliy Pupkin was input");

        By emailInput = By.xpath("//input[@id='email']");
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        WebElement emailEl = driver.findElement(emailInput);
        emailEl.sendKeys(email);
        logger.debug("Email was input, method is working, locator is available");
        logger.info("Email was input");

        By phoneInput = By.xpath("//input[@id='phone']");
        wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
        WebElement phoneEl = driver.findElement(phoneInput);
        phoneEl.sendKeys(phone);
        logger.debug("Phone number was input, method is working, locator is available");
        logger.info("Phone number was input");

        WebElement policyAgreement = driver.findElement(By.xpath("//div[@id='privacy-policy']//label//span"));
        wait.until(ExpectedConditions.visibilityOf(policyAgreement));

        policyAgreement.click();

        WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Записатися']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();

        WebElement ApplicationMsgEl = driver.findElement(By.xpath("//h1[contains(text(),'Ваша заявка прийнята.    ')]"));

        wait.until(ExpectedConditions.elementToBeClickable(ApplicationMsgEl));
        String actualMsg = ApplicationMsgEl.getText();
        actualMsg = actualMsg.substring(0, 21);
        logger.debug("Application Msg was right, method is worked, locator is available");
        logger.info("Application Msg was right");
        return actualMsg;
    }

    @Step("Checking default conditions")
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
