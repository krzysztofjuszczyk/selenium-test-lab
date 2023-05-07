import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.logging.Logger;

public class Lab_14_Menu_Test extends SeleniumBaseTest{
//    private static Logger log = LoggerFactory.getLogger(Lab_14_Menu_Test.class);

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
