import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_14_Menu_Test extends SeleniumBaseTest{
    @Test
    public void menuTest(){
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                .assertOnProcessesPage()
                .goToCharacteristics()
                .assertOnCharacteristicsPage()
                .goToDashboards()
                .assertOnDashboardsPage();
    }
}
