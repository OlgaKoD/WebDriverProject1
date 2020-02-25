package test.java.MyWebTests.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VacancyPage {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(VacancyPage.class);
    public VacancyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        logger.debug("Class " + VacancyPage.class + " initialized with driver");
        logger.info("Start initializing class");
    }
    public VacancyPage selectVacancy (String vacancy) {
        System.out.println(vacancy);
        WebElement uxVacancy = driver.findElement(By.xpath("//a//h2[text()='" + vacancy + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(uxVacancy));
        uxVacancy.click();
        logger.debug("Vacancy" + vacancy + "was selected, method is working, locator is available");
        logger.info("Vacancy was selected");
        return this;
    }
    public VacancyPage setName(String name) {
        WebElement nameInput = driver.findElement(By.id("names"));
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys(name);
        logger.debug("Name" + name + "was input, method is working, locator is available");
        logger.info("Name was input");
        return this;
    }
    public VacancyPage setEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email"));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys(email);
        logger.debug("Email" + email + "was input, method is working, locator is available");
        logger.info("Email was input");
        return this;
    }
    public VacancyPage submit() {
        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='submit-btn']/input[@name='ok']"));
        submitBtn.click();
        logger.debug("Submit Btn was clicked, method is working, locator is available");
        logger.info("Submit Btn was clicked");
        return this;
    }
    public String getPhoneErrorMsg() {
        WebElement phoneMsg = driver.findElement(By.xpath("(//label[@for='telephone']/span)[2]"));
        wait.until(ExpectedConditions.visibilityOf(phoneMsg));
        String actualMsg = phoneMsg.getText();
        logger.debug("Phone error Msg was received, method is working, locator is available");
        logger.info("Phone error Msg was received");
        logger.error("Phone error Msg wasn't received");
        return actualMsg;
    }
}
