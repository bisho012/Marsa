package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewVoyagePage extends PageBase{
    public NewVoyagePage(WebDriver driver) {
        super(driver);
    }

    public By txtVoyageNoIn = By.id("VoyageNumber");
    public By txtMasterName = By.id("InboundMasterName");
    public By btnDdlPort = By.id("s2id_VoyagePortID");
    public By vlPort = By.xpath("(//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"])[1]");

    public By btnTerminal = By.id("s2id_VoyagePortID");
    public By vlTerminal = By.xpath("(//li[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"])[1]");

    public void setVoyageNoIn(int VoyageNoIn){
        setText(txtVoyageNoIn, String.valueOf(VoyageNoIn));
    }

    public void setMasterName(String MasterName){
        setText(txtMasterName, MasterName);
    }

    public void clickPortDDL(){
        click(btnDdlPort);
    }

    public void selectPort(){
        click(vlPort);
    }
}
