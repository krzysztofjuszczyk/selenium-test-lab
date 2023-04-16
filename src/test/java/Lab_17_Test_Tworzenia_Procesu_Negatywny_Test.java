import config.Config;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_17_Test_Tworzenia_Procesu_Negatywny_Test extends SeleniumBaseTest{

    @Test
    public void addProcessWithFailureTest(){
        String tooShortName = "ab";
        String expErrorMessage
                = "The field Name must be a string with a minimum length of 3 and a maximum length of 30.";

        new LoginPage(driver)
                .typeEmail(config.getUsername())
                .typePassword(config.getPassword())
                .submitLogin()
                .goToProcesses()
                .assertOnProcessesPage()
                .goToCreateProcessPage()
                .typeName(tooShortName)
                .createProcessWithFailure()
                .assertProcessNameError(expErrorMessage)
                .backToList()
                .assertProcessIsNotShown(tooShortName);
    }
}
