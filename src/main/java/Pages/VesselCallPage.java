package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class VesselCallPage extends PageBase {
    public VesselCallPage(WebDriver driver) {
        super(driver);
    }

    public By btnUploadPan = By.id("btnExcelUpload");
    public By txtUploadPan = By.id("attachment");
    public By btnSaveUpload = By.xpath("//input[@onclick=\"UploadPanDocument()\"]");
    public By btnOK = By.xpath("//input[@value='OK' and contains(@onclick,'performOperations')]");
    public By btnCargo = By.id("btn_cargo");
    public By btnLoadingOperations = By.xpath("//label[@for='POC_Cargo_0__Checked']");
    public By txtLoadingOperations = By.xpath("(//input[@class='k-formatted-value k-input'])[2]");
    public By btnDischargeOperations = By.xpath("//label[@for='POC_Cargo_1__Checked']");
    public By txtDischargeOperations = By.xpath("(//input[@class='k-formatted-value k-input'])[3]");
    public By btnCloseCargo = By.id("btn_close_voyagevesselcall_cargo");
    public By btnNonCargo = By.id("btn_noncargo");
    public By btnRepairMaintenanceActivities = By.xpath("//label[@for='POC_Repairs_0__Checked']");
    public By btnCrewChange = By.xpath("//label[@for='POC_Services_0__Checked']");
    public By btnCICPAInspection = By.xpath("//label[@for='POC_Services_1__Checked']");
    public By btnWeatherShelter = By.xpath("//label[@for='POC_Services_2__Checked']");
    public By btnCloseNonCargo = By.id("btn_close_voyagevesselcall_Noncargo");
    public By btnLayup = By.id("btn_layup");

    public By ddlFromDay = By.id("From_Date");

    public By btnFromDay = By.xpath("//body[1]/div[81]/div[3]/table[1]/tbody[1]/tr[2]//td[@class='day today active']");

    public By btnFromHour = By.xpath("//body[1]/div[81]/div[2]/table[1]/tbody[1]/tr[1]/td[1]//span[@class='hour active']");

    public By btnFromMinute = By.xpath("//body[1]/div[81]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[12]");
    public By txtNumberOfCrew = By.xpath("(//input[@class='k-formatted-value k-input'])[1]");
    public By tabInsuranceContract = By.xpath("//a[@id='collapse5']");
    public By txtPortOfRegistery = By.id("txtPortRegistry");
    public By tabAttachments = By.xpath("//a[@id='collapse6']");
    public By btnAttach = By.xpath("//input[@id='fileupload']");
    public By btnAttachToClick = By.id("VoyageVslCallDoc_Attach");
    public By btnDDLSelectDocumentType = By.xpath("//span[@class='k-input' and contains(.,'Select Document')]");
    public By btnSelectDocumentType =
            By.xpath("(//li[@data-offset-index='17' and text()='Maritime Declaration of Health Form'])[1]");
    public By btnUploadFiles = By.xpath("//button[@id='btnUpload']");
    public By btnClose = By.xpath("(//span[@role='presentation' and .='Close' and @class='k-icon k-i-close'])[30]");
    public By waitUploading = By.xpath("//td[@style='vertical-align: middle; color: green;']");
    public By btnSave = By.id("divVesselCallSave");
    public By btnOK2 = By.xpath("/html[1]/body[1]/div[84]/div[2]/div[1]/input[1]");
    public By btnAdd = By.id("btnPlus");
    public By btnSend = By.xpath("//a[@id='btnSend']");
    public By btnConfirm = By.xpath("//input[@value='Confirm' and contains(@onclick,'performOperations')]");
    public By btnYes = By.xpath("//input[@value='Yes' and contains(@onclick,'performOperations')]");
    public By btnConfirmDisclaimer = By.xpath("//input[@id='btnYes' and @onclick='YESDesclaimer();']");
    public By btnOKVesslCallSent = By.xpath("//input[@type='button' and @value='OK']");
    public By lblCallStatus = By.id("spnCallStatus");

    public void clickPan() {
        click(btnUploadPan);
    }

    public void uploadPan() {
        uploadFile(txtUploadPan,
                "C:\\Users\\bishoy.sanad\\IdeaProjects\\Marsa\\TestData\\Upload_PAN Template updated sharaf.xlsx");
    }

    public void clickUpload() {
        click(btnSaveUpload);
    }

    public void clickOK() throws AWTException {
        click(btnOK);
        Robot r = new Robot();
        r.delay(10000);
    }

    public void clickCargo() {
        click(btnCargo);
    }

    public void clickLoadingOperations() {
        click(btnLoadingOperations);
    }

    public void setLoadingOperations(int loadingOperations) {
        setText(txtLoadingOperations, String.valueOf(loadingOperations));
    }

    public void clickDischargesOperations() {
        click(btnDischargeOperations);
    }

    public void setDischargeOperations(int dischargeOperations) {
        setText(txtDischargeOperations, String.valueOf(dischargeOperations));
    }

    public void clickCloseCargo() {
        click(btnCloseCargo);
    }

    public void clickNonCargo() {
        click(btnNonCargo);
    }

    public void clickRepairMaintenanceActivities() {
        click(btnRepairMaintenanceActivities);
    }

    public void clickCrewChange() {
        click(btnCrewChange);
    }

    public void clickCICPAInspection() {
        click(btnCICPAInspection);
    }

    public void clickWeatherShelter() {
        click(btnWeatherShelter);
    }

    public void clickCloseNonCargo() {
        click(btnCloseNonCargo);
    }

    public void clickLayup() {
        click(btnLayup);
    }

    public void selectFromDate() {
        click(ddlFromDay);
        click(btnFromDay);
        click(btnFromHour);
        click(btnFromMinute);
    }

    public void setNumberOfCrew(int crewNumber) {
        setText(txtNumberOfCrew, String.valueOf(crewNumber));
    }

    public void openInsuranceContractTab() {
        click(tabInsuranceContract);
    }

    public void setPortOfRegistery(String portOfRegistery) {
        setText(txtPortOfRegistery, portOfRegistery);
    }

    public void openAttachmentsTab() {
        click(tabAttachments);
    }

    public void clickAttach() {
        click(btnAttachToClick);
    }

    public void uploadAttachmentForMaritime() {
        uploadFile(btnAttach, "C:\\Users\\bishoy.sanad\\IdeaProjects\\Marsa\\TestData\\dummy.pdf");
    }

    public void clickDDLSelectDocumentType() {
        click(btnDDLSelectDocumentType);
    }

    public void clickSelectDocumentType() throws AWTException {
        Robot robot = new Robot();
        robot.delay(1000);
        click(btnSelectDocumentType);
    }

    public void clickUploadFiles() {
        click(btnUploadFiles);
    }

    public void waitUploading() {
        waitElement(waitUploading);
    }


    public void clickClose() {
        click(btnClose);
    }

    public void clickSave() {
        click(btnSave);
    }

    public void clickAdd() {
        click(btnAdd);
    }

    public void clickSend() {
        click(btnSend);
    }

    public void clickOK2() {
        click(btnOK2);
    }

    public void clickConfirm() {
        click(btnConfirm);
    }

    public void clickYes() {
        click(btnYes);
    }

    public void clickConfirmDisclaimer() {
        click(btnConfirmDisclaimer);
    }

    public String lblCallStatus() {
        return action(lblCallStatus).getText();
    }

    public void clickOKVesselCallSent() {
        click(btnOKVesslCallSent);
    }
}
