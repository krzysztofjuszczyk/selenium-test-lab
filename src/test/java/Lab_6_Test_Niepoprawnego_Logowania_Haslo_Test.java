import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab_6_Test_Niepoprawnego_Logowania_Haslo_Test {
    @Test
    public void incorrectLoginTestWrongPassword  (){
        System.setProperty("webdriver.chrome.driver",
                "c:/dev/driver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("http://localhost:4444/");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("test@test.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("incorrect");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        WebElement error = driver.findElement(By.cssSelector(".validation-summary-errors"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertTrue(error.getText().equals("Invalid login attempt."));


    }
}
