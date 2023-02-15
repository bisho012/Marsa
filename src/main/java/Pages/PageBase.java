package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageBase {

    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement action(By locator) {
        return driver.findElement(locator);
    }

    protected void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitElementLongTime(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(locator)));
    }

    protected void setText(By locator, String data) {
        waitElement(locator);
        action(locator).isEnabled();
        action(locator).clear();
        action(locator).sendKeys(data);
    }

    protected void click(By locator) {
        waitElement(locator);
        action(locator).click();
    }

    protected void doubleClick(By locator){
        Actions act = new Actions(driver);
        waitElement(locator);
        act.doubleClick(action(locator)).perform();
    }

    protected void clickIfFound(By Locator){
        List<WebElement> x = driver.findElements(By.xpath("(//input[@value='OK'])[1]"));

        if (x.size() > 0)
        {
            x.get(0).click();
        }
    }

    protected void clickOnPage(By locator){
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    protected void clickWithInteraction(String locatorXpath){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("$x(\""+locatorXpath+"\").click()");
    }

    public void selectData(By locator, int index) {
        Select select;
        select = new Select(action(locator));
        select.selectByIndex(index);
    }

    public boolean isDisplayed(By locator) {
        return action(locator).isDisplayed();
    }

    public String getContent(By locator) {
        waitElement(locator);
        return action(locator).getText();
    }

    public void scrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)", "");
    }

    public void hover(By locator){
        WebElement ele = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
    }

    public void uploadFile(By locator, String url) {
        waitElement(locator);
        action(locator).sendKeys(url);
    }

    public void uploadFileFromExplorer(By locator, String filepath) throws AWTException {
        waitElement(locator);

        File file = new File(filepath);
        StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
        //Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = new Robot();
        //Paste
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        //Press Enter
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //StringSelection stringSelection = new StringSelection(filepath);
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
}