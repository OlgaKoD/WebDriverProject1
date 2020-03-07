package test.java.Tests;

        import io.qameta.allure.Epic;
        import io.qameta.allure.Feature;
        import io.qameta.allure.Step;
        import io.qameta.allure.Story;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;
        import test.java.Tests.PO.HomePage;
        import test.java.Tests.PO.VacancyPage;
        import test.java.utils.RetryAnalyzer;

        import java.util.ArrayList;
        import java.util.List;

        import static org.testng.Assert.assertEquals;
@Epic("Page Object")
public class ForPO extends BaseTest {
    HomePage homePage;
    VacancyPage vacancyPage;

    @BeforeMethod
    public void PageLoad() {
      homePage = new HomePage(driver);
      vacancyPage = new VacancyPage(driver);

    }
    @Parameters({"language"})
    @Story("Select UX vacancy")
    @Test
    public void anyTest(String ukrainian) {

        homePage
                .open()
                .selectLanguage(ukrainian)
                .openAbout()
                .openVacancies();
        vacancyPage
                .selectVacancy("Викладач UX")
                .setName("Vova")
                .setEmail("email@email.com")
                .submit();
        String actualMsg = vacancyPage.getPhoneErrorMsg();
        String expectedMsg = "Поле не має бути пустим";
        assertEquals(actualMsg, expectedMsg);
    }
    @Parameters({"languages"})
    @Story("Check languages")
    @Test
    @Step("Checking language {linkFirst}")
    public void checkLang(String linkFirst) {
        int arr[] = {2, 4, 6, 8, 1, 1};
        List<String> a = new ArrayList<String>();
        homePage.open();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text() = '"+linkFirst+"'])[1]"))));

        List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='lang'])[1]//a"));
        System.out.println(list.get(0).getText());
        System.out.println(list.get(1).getText());
        System.out.println(list.get(2).getText());
        list.size();
        for(WebElement el: list) {
            System.out.println(el.getText());
        }

    }


}