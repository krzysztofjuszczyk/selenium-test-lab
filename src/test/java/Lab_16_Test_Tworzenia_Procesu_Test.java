import config.Config;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.UUID;

public class Lab_16_Test_Tworzenia_Procesu_Test extends SeleniumBaseTest{
    @Test
    public void processCreationTest(){
        String randomName = UUID.randomUUID().toString().substring(0,10);
        new LoginPage(driver)
                .typeEmail(new Config().getUsername())
                .typePassword(new Config().getPassword())
                .submitLogin()
                .goToProcesses()
                .addNewProcess(randomName)
                .assertOnProcessesPage()
                .assertProcessHasBeenCreated(randomName,"","");
    }
}
