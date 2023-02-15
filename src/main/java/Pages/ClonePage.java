package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClonePage extends PageBase{
    public ClonePage(WebDriver driver) {
        super(driver);
    }

    public By txtVoyageNum = By.xpath("//input[@name='VoyageNumber']");
    public By txtETA = By.id("VoyageETA");

    public By btnSave = By.id("btnSaveButton");
    public By btnOKForBunker = By.xpath("(//input[@value='OK'])[1]");
    public By btnYes = By.xpath("//input[@value='Yes']");
    public By btnOK = By.xpath("//input[@value='OK']");

    public void setVoyageNumber(int voyageNumber){
        setText(txtVoyageNum, String.valueOf(voyageNumber));
    }

    public void setETA(String eta){
        setText(txtETA, eta);
    }

    public void clickSave(){
        click(btnSave);
    }
    public void clickOKBunker(){
        clickIfFound(btnOKForBunker);
    }

    public void clickYes(){
        click(btnYes);
    }

    public void clickOK(){
        click(btnOK);
    }

}
