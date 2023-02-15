package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends PageBase{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public By btnMainMenu = By.id("search");
    public By btnVesselOperation = By.xpath("//span[normalize-space()='Vessel Operation']");
    public By btnPCS = By.xpath("//div[@data-target='#demo']");

    public void clickMainMenu(){
        click(btnMainMenu);
    }

    public void clickVesselOperation(){
        click(btnVesselOperation);
    }
    public void clickPCS(){
        click(btnPCS);
    }
}
