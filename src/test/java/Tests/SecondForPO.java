package test.java.Tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Tests.PO.EveningCoursesPage;
import test.java.utils.RetryAnalyzer;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

@Epic("Page Object")
public class SecondForPO extends BaseTest {
    EveningCoursesPage eveningCoursesPage;
    @BeforeMethod
    public void PageLoad() {
        eveningCoursesPage = new EveningCoursesPage(driver);
    }

    @DataProvider(name = "Courses")
    public Object[][] CoursesExpectedList() {
        return new Object[][] {
                {"Frontend development",
                "JS development",
                "Веб-дизайн",
                "PHP",
                "Java programming",
                "Python",
                "Data Science/Machine Learning",
                "C# /.NET development",
                "C++",
                "Game Development",
                "DEVOPS",
                "Digital Marketing",
                "Управління персоналом",
                "Управління проектами",
                "Mobile development",
                "Відеомонтаж",
                "Cisco",
                "Go development",
                "Кібербезпека",
                "Менеджмент",
                "Тестування"}
        };
    }

    @DataProvider(name = "CoursesBuy")
    public Object[][] CoursesBuyList() {
        return new Object[][] {
                {"Frontend development"},
                {"JS development"},
                {"Веб-дизайн"}
        };
    }

    @Story("Check courses list")
    @Test(dataProvider = "Courses")
    public void checkCourses(Object[] s)  {
        List<String> actualList;
        List<String> expectedList = new ArrayList<String>();;

        for (Object o : s) {
            expectedList.add(o.toString());
        }

        actualList = eveningCoursesPage
                .openHomePage()
                .openEveningCourses()
                .openCoursesListPage()
                .getCourseList()
                ;

        Collections.sort(actualList);
        Collections.sort(expectedList);

        assertEquals(actualList, expectedList);
    }

    @Story("Check default conditions before buying")
    @Test(dataProvider = "CoursesBuy")
    public void checkCoursesBuy(Object[] s) {
        String courseName = s[0].toString();
        boolean[] actualResult;

        eveningCoursesPage
                .openHomePage()
                .openEveningCourses()
                .openCoursesListPage();
        actualResult = eveningCoursesPage.goToCoursePage(courseName).buyCourse().getDefaultConditions();

        assertTrue((actualResult[0] == true && actualResult[1] == false && actualResult[2] == false && actualResult[3] == false));
    }


}
