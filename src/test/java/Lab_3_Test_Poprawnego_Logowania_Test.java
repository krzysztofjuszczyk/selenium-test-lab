import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab_3_Test_Poprawnego_Logowania_Test {
    @Test
    public void correctLoginTest(){
        System.setProperty("webdriver.chrome.driver",
                "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //        driver.get("http://localhost:4444/");

        // użycie pliku config.properties
        driver.get(new Config().getApplicationUrl());

        WebElement emailTxt = driver.findElement(By.cssSelector("input#Email"));
        emailTxt.sendKeys("test@test.com");

        WebElement passTxt = driver.findElement(By.cssSelector("input#Password"));
        passTxt.sendKeys("Test1!");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        WebElement welcomeElm = driver.findElement(By.cssSelector(".profile_info>h2"));
        Assert.assertTrue(welcomeElm.isDisplayed());
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"));
        driver.quit();

    }
}
