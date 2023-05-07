import config.Config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Config config;

    @BeforeMethod
    public void baseBeforeMethod() {
        System.setProperty("webdriver.chrome.driver",
                "c:/Tools/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:4444");
//        driver.get("%applicationUrl%");
//        driver.get("http://localhost:4444/");
        config = new Config();
    }

    @AfterMethod
    public void baseAfterMethod(ITestResult result) {
        //verify if test failed
        if (result.getStatus() == ITestResult.FAILURE) {
            String methodName =  result.getMethod().getMethodName();
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            createFile(this.getClass().getName()+' '+ methodName+ ' '+ timeStamp);
        }
        driver.quit();
    }

    public void createFile(String fileName){
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("c:\\tmp\\"+fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
