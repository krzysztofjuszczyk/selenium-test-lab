import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

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
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .assertWelcomeElementIsShown();

    }
}
