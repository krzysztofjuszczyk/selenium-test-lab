import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Lab_5_Test_Niepoprawnego_Logowania_Email_Test {
    @Test
    public void incorrectLoginTestWrongEmail (){
        System.setProperty("webdriver.chrome.driver",
                "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:4444/");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("incorrect");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        WebElement emailError = driver.findElement(By.cssSelector("#Email-error"));
        Assert.assertTrue(emailError.isDisplayed());
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");

        boolean doesErrorExist = false;
        List<WebElement> validationErrors =
//                driver.findElements(By.cssSelector(".validation-summary-errors>ul>li"));
        driver.findElements(By.cssSelector("#Email-error"));
        doesErrorExist = validationErrors
                .stream()
                .anyMatch(validationError -> validationError.getText()
                        .equals("The Email field is not a valid e-mail address."));
       Assert.assertTrue(doesErrorExist);

        driver.quit();
    }
}
