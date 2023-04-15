import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_13_HomePage_Menu_Test extends SeleniumBaseTest {

    @Test
    public void loginAndGoToProcessesTest() {

        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses();
    }

    @Test
    public void loginAndGoToCharacteristics(){
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToCharacteristics();
    }

    @Test
    public void loginAndGoToDashboards(){
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToDashboards();
    }
}

