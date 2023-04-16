package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProcessesPage extends HomePage{
//    protected WebDriver driver;

    @FindBy (css = ".page-title h3")
    private WebElement processesElm;

    public ProcessesPage(WebDriver driver) {
        super(driver);
        //        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    public ProcessesPage assertOnProcessesPage() {
        String txt = "Processes";

        Assert.assertTrue(processesElm.isDisplayed(), "Processes element is not displayed");
        Assert.assertTrue(processesElm.getText().contains(txt),
                "Processes element text: "+ processesElm.getText() + "doesn't contain word "+ txt);
        assertProcessesUrl("http://localhost:4444/Projects");

        return this;
    }

    public ProcessesPage assertProcessesUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
        return this;
    }
}
