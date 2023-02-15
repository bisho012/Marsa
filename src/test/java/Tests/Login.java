package Tests;

import Utils.ExcelFileManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends TestBase {

    @Test
    public void LoginWithValid() throws IOException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickLogin();
    }
}
