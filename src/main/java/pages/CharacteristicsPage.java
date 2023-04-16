package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CharacteristicsPage extends HomePage {
//    protected WebDriver driver;

    @FindBy(css = ".page-title h3")
    private WebElement characteristicsElm;

    public CharacteristicsPage(WebDriver driver) {
        super(driver);
        //        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    public CharacteristicsPage assertOnCharacteristicsPage() {
        String txt = "Characteristics";

        Assert.assertTrue(characteristicsElm.isDisplayed(), "Processes element is not displayed");
        Assert.assertTrue(characteristicsElm.getText().contains(txt),
                "Characteristics element text: " + characteristicsElm.getText() + "doesn't contain word " + txt);
        assertDashboardUrl("http://localhost:4444/Characteristics");
        return this;
    }

    public CharacteristicsPage assertDashboardUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
        return this;
    }
}
