package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditVoyagePage extends PageBase {
    public EditVoyagePage(WebDriver driver) {
        super(driver);
    }

    public By txtMasterName = By.id("InboundMasterName");
    public By txtMaxDraft = By.id("ActualDraft");
    public By btnSave = By.id("btnSave");
    public By btnOKForBunker = By.xpath("(//input[@value='OK'])[1]");
    public By btnOK = By.xpath("(//input[@value='OK'])");
    public By btnOK1 = By.xpath("(//input[@value='OK'])[1]");
    public By btnSend = By.id("btnPlus");
    public By btnSendBoth = By.id("sendboth");
    public By btnYesProceed = By.xpath("//input[@value='Yes, Proceed']");
    public By btnOK2 = By.xpath("//input[@value='OK' and contains(@onclick,'performOperations')]");
    public By btnVesselCall = By.xpath("(//a[@class='waves-color-blue waves-effect'])[2]");

    public void setMasterName(String masterName) {
        setText(txtMasterName, masterName);
    }

    public void setMaxDraft(int maxDraft) {
        setText(txtMaxDraft, String.valueOf(maxDraft));
    }

    public void clickSave() {
        click(btnSave);
    }

    public void clickOKBunker() {
        clickIfFound(btnOKForBunker);
    }

    public void clickOK() {
        click(btnOK1);
    }

    public void clickSend() {
        click(btnSend);
    }

    public void clickBoth() {
        click(btnSendBoth);
    }

    public void clickVesselCall() {
        click(btnVesselCall);
    }

    public void clickOK2() {
        click(btnOK2);
    }

    public void clickYesProceed(){
        if(driver.findElements(By.xpath("//input[@value='Yes, Proceed']")).size()!=0)
        {
            click(btnYesProceed);
        }
        else assert true;
    }
}
