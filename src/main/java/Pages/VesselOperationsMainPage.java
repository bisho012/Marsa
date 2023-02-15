package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VesselOperationsMainPage extends PageBase {

    public VesselOperationsMainPage(WebDriver driver) {
        super(driver);
    }

    int column_to_clone = 2;
    public By btnNew = By.id("addbutton");
    public By btnClone = By.xpath("//button[@id='clonebutton']");
    public By btnEdit = By.id("modifybutton");
    public By btnrow = By.xpath("(//td[@role='gridcell' and @title='BX071022023'])");
    public By btnFirstRow = By.xpath("(//td[@role='gridcell'])[2]");


    public void clickNew() {
        click(btnNew);
    }

    public void clickEdit() {
        click(btnEdit);
    }

    public void doubleClickCol(){
        if(driver.findElements(By.xpath("(//tr[@role='row'])[" + column_to_clone + "]")).size()!=0)
        {
            doubleClick(btnFirstRow);
        }
        else refresh();
    }

    public void clickRow(){
        click(btnrow);
    }

    public void refresh() {
        driver.navigate().refresh();
    }
    public void clickFirstCol(){
        click(btnFirstRow);
    }

    public void clickClone(){
        click(btnClone);
    }
}
