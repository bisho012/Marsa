package Tests;

import Pages.DashboardPage;
import Pages.PageBase;
import Utils.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class VesselOperations extends TestBase {

//    @Test
//    public void CreateNewVoyage() throws IOException {
//        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
//        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
//        loginPage.clickLogin();
//        dashboardPage.clickMainMenu();
//        dashboardPage.clickVesselOperation();
//        vesselOperationsMainPage.clickNew();
//        newVoyagePage.setVoyageNoIn(VoyageNum);
//        newVoyagePage.setMasterName(ExcelFileManager.setDataFromExcelFile(2,2));
//        newVoyagePage.clickPortDDL();
//        newVoyagePage.selectPort();
//    }

    @Test(priority = 0)
    public void CloneVoyageCargoAndNonCargo() throws IOException, AWTException, InterruptedException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickLogin();
        dashboardPage.clickMainMenu();
        dashboardPage.clickPCS();
        dashboardPage.clickVesselOperation();
        vesselOperationsMainPage.clickRow();
        vesselOperationsMainPage.clickClone();
        switchFrame();
        clonePage.setVoyageNumber(VoyageNum);
        scrollDown();
        clonePage.clickSave();
        //clonePage.clickOKBunker();
        clonePage.clickYes();
        clonePage.clickOK();
        refresh();
        vesselOperationsMainPage.clickFirstCol();
        vesselOperationsMainPage.doubleClickCol();
        editVoyagePage.setMasterName(faker.name().firstName());
        editVoyagePage.setMaxDraft(faker.hashCode());
        editVoyagePage.clickSave();
        editVoyagePage.clickYesProceed();
        editVoyagePage.clickOK();
        editVoyagePage.clickSend();
        editVoyagePage.clickBoth();
        editVoyagePage.clickOK2();
        //editVoyagePage.clickOKBunker();
        editVoyagePage.clickVesselCall();
        vesselCallPage.clickPan();
        vesselCallPage.uploadPan();
        vesselCallPage.clickUpload();
        vesselCallPage.clickOK();
        refresh();
        vesselCallPage.clickCargo();
        vesselCallPage.clickLoadingOperations();
        vesselCallPage.setLoadingOperations(100);
        vesselCallPage.clickDischargesOperations();
        vesselCallPage.setDischargeOperations(100);
        vesselCallPage.clickCloseCargo();
        vesselCallPage.clickNonCargo();
        vesselCallPage.clickRepairMaintenanceActivities();
        vesselCallPage.clickCrewChange();
        vesselCallPage.clickCICPAInspection();
        vesselCallPage.clickWeatherShelter();
        vesselCallPage.clickCloseNonCargo();
        scrollDown();
        vesselCallPage.setNumberOfCrew(299);
        vesselCallPage.openInsuranceContractTab();
        vesselCallPage.setPortOfRegistery(faker.aviation().airport());
        scrollDown();
        vesselCallPage.openAttachmentsTab();
        scrollDown();
        vesselCallPage.clickAttach();
        vesselCallPage.uploadFileFromExplorer(vesselCallPage.btnAttachToClick,
                "C:\\Users\\bishoy.sanad\\IdeaProjects\\Marsa\\TestData\\dummy.pdf");
        vesselCallPage.clickDDLSelectDocumentType();
        vesselCallPage.clickSelectDocumentType();
        vesselCallPage.clickUploadFiles();
        vesselCallPage.waitUploading();
        vesselCallPage.clickClose();
        vesselCallPage.clickSave();
        vesselCallPage.clickOK2();
        vesselCallPage.clickAdd();
        vesselCallPage.clickSend();
        vesselCallPage.clickConfirm();
        vesselCallPage.clickYes();
        vesselCallPage.clickConfirmDisclaimer();
        vesselCallPage.clickOKVesselCallSent();
        Assert.assertEquals(vesselCallPage.lblCallStatus(),"Sent");
    }

    @Test(priority = 1)
    public void CloneVoyageCargo() throws IOException, AWTException, InterruptedException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickLogin();
        dashboardPage.clickMainMenu();
        dashboardPage.clickPCS();
        dashboardPage.clickVesselOperation();
        vesselOperationsMainPage.clickRow();
        vesselOperationsMainPage.clickClone();
        switchFrame();
        clonePage.setVoyageNumber(VoyageNum);
        scrollDown();
        clonePage.clickSave();
        //clonePage.clickOKBunker();
        clonePage.clickYes();
        clonePage.clickOK();
        refresh();
        vesselOperationsMainPage.clickFirstCol();
        vesselOperationsMainPage.doubleClickCol();
        editVoyagePage.setMasterName(faker.name().firstName());
        editVoyagePage.setMaxDraft(faker.hashCode());
        editVoyagePage.clickSave();
        editVoyagePage.clickYesProceed();
        editVoyagePage.clickOK();
        editVoyagePage.clickSend();
        editVoyagePage.clickBoth();
        editVoyagePage.clickOK2();
        //editVoyagePage.clickOKBunker();
        editVoyagePage.clickVesselCall();
        vesselCallPage.clickPan();
        vesselCallPage.uploadPan();
        vesselCallPage.clickUpload();
        vesselCallPage.clickOK();
        refresh();
        vesselCallPage.clickCargo();
        vesselCallPage.clickLoadingOperations();
        vesselCallPage.setLoadingOperations(100);
        vesselCallPage.clickDischargesOperations();
        vesselCallPage.setDischargeOperations(100);
        vesselCallPage.clickCloseCargo();
        scrollDown();
        vesselCallPage.setNumberOfCrew(299);
        vesselCallPage.openInsuranceContractTab();
        vesselCallPage.setPortOfRegistery(faker.aviation().airport());
        scrollDown();
        vesselCallPage.openAttachmentsTab();
        scrollDown();
        vesselCallPage.clickAttach();
        vesselCallPage.uploadFileFromExplorer(vesselCallPage.btnAttachToClick,
                "C:\\Users\\bishoy.sanad\\IdeaProjects\\Marsa\\TestData\\dummy.pdf");
        vesselCallPage.clickDDLSelectDocumentType();
        vesselCallPage.clickSelectDocumentType();
        vesselCallPage.clickUploadFiles();
        vesselCallPage.waitUploading();
        vesselCallPage.clickClose();
        vesselCallPage.clickSave();
        vesselCallPage.clickOK2();
        vesselCallPage.clickAdd();
        vesselCallPage.clickSend();
        vesselCallPage.clickConfirm();
        vesselCallPage.clickYes();
        vesselCallPage.clickConfirmDisclaimer();
        vesselCallPage.clickOKVesselCallSent();
        Assert.assertEquals(vesselCallPage.lblCallStatus(),"Sent");
    }

    @Test(priority = 1)
    public void CloneVoyageNonCargo() throws IOException, AWTException, InterruptedException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickLogin();
        dashboardPage.clickMainMenu();
        dashboardPage.clickPCS();
        dashboardPage.clickVesselOperation();
        vesselOperationsMainPage.clickRow();
        vesselOperationsMainPage.clickClone();
        switchFrame();
        clonePage.setVoyageNumber(VoyageNum);
        scrollDown();
        clonePage.clickSave();
        //clonePage.clickOKBunker();
        clonePage.clickYes();
        clonePage.clickOK();
        refresh();
        vesselOperationsMainPage.clickFirstCol();
        vesselOperationsMainPage.doubleClickCol();
        editVoyagePage.setMasterName(faker.name().firstName());
        editVoyagePage.setMaxDraft(faker.hashCode());
        editVoyagePage.clickSave();
        editVoyagePage.clickYesProceed();
        editVoyagePage.clickOK();
        editVoyagePage.clickSend();
        editVoyagePage.clickBoth();
        editVoyagePage.clickOK2();
        //editVoyagePage.clickOKBunker();
        editVoyagePage.clickVesselCall();
        vesselCallPage.clickPan();
        vesselCallPage.uploadPan();
        vesselCallPage.clickUpload();
        vesselCallPage.clickOK();
        refresh();
        vesselCallPage.clickNonCargo();
        vesselCallPage.clickRepairMaintenanceActivities();
        vesselCallPage.clickCrewChange();
        vesselCallPage.clickCICPAInspection();
        vesselCallPage.clickWeatherShelter();
        vesselCallPage.clickCloseNonCargo();
        scrollDown();
        vesselCallPage.setNumberOfCrew(299);
        vesselCallPage.openInsuranceContractTab();
        vesselCallPage.setPortOfRegistery(faker.aviation().airport());
        scrollDown();
        vesselCallPage.openAttachmentsTab();
        scrollDown();
        vesselCallPage.clickAttach();
        vesselCallPage.uploadFileFromExplorer(vesselCallPage.btnAttachToClick,
                "C:\\Users\\bishoy.sanad\\IdeaProjects\\Marsa\\TestData\\dummy.pdf");
        vesselCallPage.clickDDLSelectDocumentType();
        vesselCallPage.clickSelectDocumentType();
        vesselCallPage.clickUploadFiles();
        vesselCallPage.waitUploading();
        vesselCallPage.clickClose();
        vesselCallPage.clickSave();
        vesselCallPage.clickOK2();
        vesselCallPage.clickAdd();
        vesselCallPage.clickSend();
        vesselCallPage.clickConfirm();
        vesselCallPage.clickYes();
        vesselCallPage.clickConfirmDisclaimer();
        vesselCallPage.clickOKVesselCallSent();
        Assert.assertEquals(vesselCallPage.lblCallStatus(),"Sent");
    }

//    @Test
//    public void TestUploadDocument() throws IOException, AWTException {
//        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
//        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
//        loginPage.clickLogin();
//        dashboardPage.clickMainMenu();
//        dashboardPage.clickVesselOperation();
//        vesselOperationsMainPage.clickFirstCol();
//        vesselOperationsMainPage.clickEdit();
//        editVoyagePage.clickVesselCall();
//        scrollDown();
//        vesselCallPage.openAttachmentsTab();
//        scrollDown();
//        vesselCallPage.clickAttach();
//        vesselCallPage.uploadFileFromExplorer(vesselCallPage.btnAttachToClick,
//                "C:\\Users\\bishoy.sanad\\IdeaProjects\\Marsa\\TestData\\dummy.pdf");
//        vesselCallPage.clickDDLSelectDocumentType();
//        vesselCallPage.clickSelectDocumentType();
//        vesselCallPage.clickUploadFiles();
//        vesselCallPage.waitUploading();
//        vesselCallPage.clickClose();
//        vesselCallPage.clickSave();
//        vesselCallPage.clickOK();
//        vesselCallPage.clickAdd();
//        vesselCallPage.clickSend();
//    }

    @Test
    public void TestLayup() throws IOException, AWTException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickLogin();
        dashboardPage.clickMainMenu();
        dashboardPage.clickPCS();
        dashboardPage.clickVesselOperation();
        vesselOperationsMainPage.clickRow();
        vesselOperationsMainPage.clickClone();
        switchFrame();
        clonePage.setVoyageNumber(VoyageNum);
        scrollDown();
        clonePage.clickSave();
        clonePage.clickYes();
        clonePage.clickOK();
        refresh();
        vesselOperationsMainPage.clickFirstCol();
        vesselOperationsMainPage.doubleClickCol();
        editVoyagePage.setMasterName(faker.name().firstName());
        editVoyagePage.setMaxDraft(faker.hashCode());
        editVoyagePage.clickSave();
        editVoyagePage.clickYesProceed();
        editVoyagePage.clickOK();
        editVoyagePage.clickSend();
        editVoyagePage.clickBoth();
        editVoyagePage.clickOK2();
        editVoyagePage.clickVesselCall();
        vesselCallPage.clickPan();
        vesselCallPage.uploadPan();
        vesselCallPage.clickUpload();
        vesselCallPage.clickOK();
        refresh();
        editVoyagePage.clickVesselCall();
        vesselCallPage.clickLayup();
        vesselCallPage.selectFromDate();
    }
}
