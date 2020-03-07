package test.java.Tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.Tests.PO.EveningCoursesPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Page Object")
public class ThirdForPO extends BaseTest {
    EveningCoursesPage eveningCoursesPage;
    List<String> coursesList = new ArrayList<String>();

    @BeforeMethod
    public void PageLoad() {
        eveningCoursesPage = new EveningCoursesPage(driver);

        for(int i = 0; i < 21; i++) {

            coursesList.add(0, "Тестування");
            coursesList.add(1, "Frontend development");
            coursesList.add(2, "JS development");
            coursesList.add(3, "Веб-дизайн");
            coursesList.add(4, "PHP");
            coursesList.add(5, "Java programming");
            coursesList.add(6, "Python");
            coursesList.add(7, "Data Science/Machine Learning");
            coursesList.add(8, "C# /.NET development");
            coursesList.add(9, "C++");
            coursesList.add(10, "Game Development");
            coursesList.add(11, "DEVOPS");
            coursesList.add(12, "Digital Marketing");
            coursesList.add(13, "Управління персоналом");
            coursesList.add(14, "Управління проектами");
            coursesList.add(15, "Mobile development");
            coursesList.add(16, "Відеомонтаж");
            coursesList.add(17, "Cisco");
            coursesList.add(18, "Go development");
            coursesList.add(19, "Кібербезпека");
            coursesList.add(20, "Менеджмент");


        }
    }







    @Story("Buying evening course")
    @Test
    public void checkCoursesBuy() throws InterruptedException {
        int rand = (int)( Math.random() * coursesList.size() );
        String courseName = coursesList.get(rand);
        String actualResult;
        String expectedResult = "Ваша заявка прийнята.";


        actualResult = eveningCoursesPage
                .openHomePage()
                .openEveningCourses()
                .openCoursesListPage()
                .goToCoursePage(courseName).buyCourse().signUpForCourse("Vasiliy Pupkin","email@internet.com", "0800212407");

        assertEquals(actualResult, expectedResult,
                String.format("Expected %s to be equal %s", expectedResult, actualResult));

    }


}
