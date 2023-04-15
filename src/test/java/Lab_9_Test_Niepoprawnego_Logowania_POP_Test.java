import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class Lab_9_Test_Niepoprawnego_Logowania_POP_Test extends SeleniumBaseTest{
    @Test
    public void incorrectLoginTest(){
//        System.setProperty("webdriver.chrome.driver",
//                "c:/dev/driver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("http://localhost:4444/");

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.typeEmail("asdf");
//        loginPage.typePassword("asd");
//        loginPage.submitLoginWithFailure();

        new LoginPage(driver)
                .typeEmail("asdf")
                .typePassword("asdf")
                .submitLoginWithFailure()
                .assertErrorIncorrectEmail();

    }
}
