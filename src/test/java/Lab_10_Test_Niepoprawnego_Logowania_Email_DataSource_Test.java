//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import pages.LoginPage;
//
//import javax.xml.crypto.Data;
//import java.time.Duration;
//
//public class Lab_10_Test_Niepoprawnego_Logowania_Email_DataSource_Test extends SeleniumBaseTest {
////    private WebDriver driver;
//
//    @DataProvider (name = "incorrectEmails")
//    public Object[][] getWrongEmails(){
//        return new Object[][]{
//                {"test"},
//                {"admin"},
//                {"@test "}
//                };
//    }
//
//    @Test(dataProvider = "incorrectEmails")
//    public void incorrectEmailTest(String incorrectEmails){
////        System.setProperty("webdriver.chrome.driver",
////                "c:/dev/driver/chromedriver.exe");
////        WebDriver driver = new ChromeDriver();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////        driver.manage().window().maximize();
////        driver.get("http://localhost:4444/");
//
//        new LoginPage(driver)
//                .typeEmail(incorrectEmails)
//                .typePassword("abc")
//                .submitLoginWithFailure()
//                .assertErrorIncorrectEmail();
//
////        boolean hasError = false;
////        for (WebElement e :
////                page.loginErrors) {
////            if (e.getText().equals("The Email field is not a valid e-mail address."));{
////                hasError = true;
////                break;
////            }
////        }
////        Assert.assertTrue(hasError);
//
//    }
//}
