package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardsPage {
    protected WebDriver driver;

    @FindBy(css = ".x_title h2")
    private WebElement dashboardsElm;

    public DashboardsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public DashboardsPage assertOnDashboardsPage() {
        String txt = "DEMO PROJECT";
        Assert.assertTrue(dashboardsElm.isDisplayed(), "Processes element is not displayed");
        Assert.assertTrue(dashboardsElm.getText().contains(txt),
                "Dashboards element text: "+ dashboardsElm.getText() + "doesn't contain word "+ txt);
        assertDashboardUrl("http://localhost:4444/");
        return this;
    }

    public DashboardsPage assertDashboardUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
        return this;
    }
}
