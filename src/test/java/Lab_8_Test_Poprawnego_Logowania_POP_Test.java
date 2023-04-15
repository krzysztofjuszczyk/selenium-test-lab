import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Lab_8_Test_Poprawnego_Logowania_POP_Test {
    @Test
    public void correctLoginTest(){
        System.setProperty("webdriver.chrome.driver",
                "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://localhost:4444/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail("test@test.com");
        loginPage.typePassword("Test1!");

        HomePage homePage = loginPage.submitLogin();
        String txt = "Welcome";

        Assert.assertTrue(homePage.welcomeElm.isDisplayed(), "Welcome element is not displayed");
        Assert.assertTrue(homePage.welcomeElm.getText().contains(txt),
                "Welcome element text: "+ homePage.welcomeElm.getText() + "doesn't contain word "+ txt);

    }
}
