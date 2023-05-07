//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import pages.CreateAccountPage;
//import pages.LoginPage;
//
//import java.time.Duration;
//
//public class Lab_11_Test_Niepoprawnej_Rejestracji_Email_DP_Test extends SeleniumBaseTest{
//
//    @DataProvider(name = "incorrectEmails")
//    public Object[][] getIncorrectEmails(){
//        return new Object[] []{
//                {"a_a.com"},
//                {"a@aba"},
//                {"afafaf@test.c"},
//                {".@."},
//                {"test@test.cccccccacacacacaacacaca"},
//                {"1@1.1"},
//        };
//    }
//
//    @Test(dataProvider = "incorrectEmails")
//    public void registerWithIncorrectEmail(String incorrectEmail){
////        System.setProperty("webdriver.chrome.driver",
////                "c:/dev/driver/chromedriver.exe");
////        WebDriver driver = new ChromeDriver();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////        driver.manage().window().maximize();
////        driver.get("http://localhost:4444/");
//
//        LoginPage page = new LoginPage(driver);
//        CreateAccountPage regPage = page.goToRegisterPage();
//        regPage.typeEmail(incorrectEmail)
//                .createAccountWithFailure()
//                .assertErrorIncorrectEmail();
////        regPage.typePassword("Test1!");
//
//
////        boolean hasError = false;
////        for (WebElement e :
////                regPage.loginErrors) {
////            if (e.getText().equals("The Email field is not a valid e-mail address."));{
////                hasError = true;
////                break;
////            }
////        }
////        Assert.assertTrue(hasError);
//
//    }
//}
