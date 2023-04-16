import config.Config;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Lab_8_Test_Poprawnego_Logowania_POP_Test extends SeleniumBaseTest{

    @Test
    public void correctLoginTest(){
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.typeEmail("test@test.com");
//        loginPage.typePassword("Test1!");
//
//        HomePage homePage = loginPage.submitLogin();
//        homePage.assertWelcomeElementIsShown();

        new LoginPage(driver)
//                .typeEmail("test@test.com")
                .typeEmail(new Config().getUsername())
//                .typePassword("Test1!")
                .typePassword(new Config().getPassword())
                .submitLogin()
                .assertWelcomeElementIsShown();

    }
}
