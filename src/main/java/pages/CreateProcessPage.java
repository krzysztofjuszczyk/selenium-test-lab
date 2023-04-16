package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProcessPage extends HomePage{
    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Name")
    private WebElement processNameTxt;

    @FindBy(id = "Description")
    private WebElement processDescriptionTxt;

    @FindBy(id = "Notes")
    private WebElement processNotesTxt;

    @FindBy(linkText = "Back to List")
    private WebElement backToListBtn;

    @FindBy(css = "button[type=reset]")
    private WebElement resetBtn;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    public CreateProcessPage typeName(String name)  {
        processNameTxt.clear();
        processNameTxt.sendKeys(name);
        return this;
    }

    public CreateProcessPage typeDescription (String desc){
        processDescriptionTxt.clear();
        processDescriptionTxt.sendKeys(desc);
        return this;
    }

    public CreateProcessPage typeNotes(String notes){
        processNotesTxt.clear();
        processNotesTxt.sendKeys(notes);
        return this;
    }

    public ProcessesPage createProcess(){
        createBtn.click();
        return new ProcessesPage(driver);
    }

}
