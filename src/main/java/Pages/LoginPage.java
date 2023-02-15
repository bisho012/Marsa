package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By txtUsername = By.id("Username");
    public By txtPassword = By.id("Password");
    public By btnLogin = By.id("step-btn");



    public void setUsername(String username){
        setText(txtUsername, username);
    }

    public void setPassword(String password){
        setText(txtPassword, password);
    }

    public void clickLogin(){
        click(btnLogin);
    }
}