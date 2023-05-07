import config.Config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
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
import java.util.logging.Logger;

@Slf4j
public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Config config;

    @BeforeMethod
    public void baseBeforeMethod() {
        System.setProperty("webdriver.chrome.driver",
                "c:/Tools/drivers/chromedriver.exe"); //jenkins add
        String url = System.getProperty("applicationUrl");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
//        driver.get("%applicationUrl%");
//        driver.get("http://localhost:4444/");
        config = new Config();

        log.info("Tests run on environment" + System.getProperty("ENV"));
        log.info("Run on url:" + url);

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
