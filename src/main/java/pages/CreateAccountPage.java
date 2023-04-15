package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccountPage {
    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="Email")
    private WebElement emailTxt;

    @FindBy(id="Password")
    private WebElement passwordTxt;

    //    @FindBy(className="btn btn-success submit btn-block")
    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    public CreateAccountPage typeEmail(String email){
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage typePassword(String password){
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage createAccount(){
        registerBtn.click();
        return new HomePage(driver);
    }

    public CreateAccountPage createAccountWithFailure(){
        registerBtn.click();
        return this;
    }

}
