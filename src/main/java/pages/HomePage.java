package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".profile_info>h2")
    private WebElement welcomeElm;

    @FindBy(css = ".menu-workspace")
    private WebElement workspaceNav;

    @FindBy(css = ".menu-home")
    private WebElement homeNav;

    @FindBy(css = "a[href$=Projects]")
    private WebElement processesMenu;

    @FindBy(css = "a[href$=Characteristics]")
    private WebElement characteristicsMenu;

//    @FindBy(css = "#sidebar-menu > div > ul > li.active > ul > li > a")
//    @FindBy(xpath = "//[text()[contains('Dashboard')]]")
    @FindBy(className = "current-page")
    private WebElement dashboardsMenu;

    public HomePage assertWelcomeElementIsShown(){
        String txt = "Welcome";
        Assert.assertTrue(welcomeElm.isDisplayed(), "Welcome element is not displayed");
        Assert.assertTrue(welcomeElm.getText().contains(txt),
                "Welcome element text: "+ welcomeElm.getText() + "doesn't contain word "+ txt);

        return this;
    }

    public ProcessesPage goToProcesses(){
        if (!isParentExpanded(workspaceNav)){
            workspaceNav.click();
//            #sidebar-menu > div > ul > li.active > ul > li.active > a
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(processesMenu));

        processesMenu.click();
        return new ProcessesPage(driver);
    }


    public CharacteristicsPage goToCharacteristics() {
        if (!isParentExpanded(workspaceNav)) {
            workspaceNav.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(characteristicsMenu));
        characteristicsMenu.click();
        return new CharacteristicsPage(driver);
    }

    public DashboardsPage goToDashboards() {
        if(!isParentExpanded(homeNav)){
            homeNav.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardsMenu));
        dashboardsMenu.click();
        return new DashboardsPage(driver);
    }

    private boolean isParentExpanded(WebElement menuLink){
        WebElement parent = menuLink.findElement(By.xpath("./.."));
        return parent.getAttribute("class").contains("active");
    }
}
