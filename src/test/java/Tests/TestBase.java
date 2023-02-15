package Tests;

import Pages.*;
import com.github.javafaker.Faker;
import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static Utils.ExcelFileManager.file;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TestBase {
    public LocalDateTime date = LocalDateTime.now();
    public int VoyageNum = date.toLocalTime().toSecondOfDay();
    Faker faker = new Faker();
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    VesselOperationsMainPage vesselOperationsMainPage;
    NewVoyagePage newVoyagePage;
    ClonePage clonePage;
    EditVoyagePage editVoyagePage;
    VesselCallPage vesselCallPage;
    private final String url = "http://10.0.131.21/MARSA2/Web/Account/Login";
    private final String stgUrl = "https://loginstaging.atlp.ae/en/Account/Login";

    @BeforeSuite
    void setEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "97.0.4692.71")
                        .put("URL", stgUrl)
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }

    @BeforeMethod
    public void setUp() {
        String browserName = "chrome";
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(stgUrl);
            loginPage = new LoginPage(driver);
            dashboardPage = new DashboardPage(driver);
            vesselOperationsMainPage = new VesselOperationsMainPage(driver);
            newVoyagePage = new NewVoyagePage(driver);
            clonePage = new ClonePage(driver);
            editVoyagePage = new EditVoyagePage(driver);
            vesselCallPage = new VesselCallPage(driver);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to(stgUrl);
            loginPage = new LoginPage(driver);
            dashboardPage = new DashboardPage(driver);
            vesselOperationsMainPage = new VesselOperationsMainPage(driver);
            newVoyagePage = new NewVoyagePage(driver);
            clonePage = new ClonePage(driver);
            editVoyagePage = new EditVoyagePage(driver);
            vesselCallPage = new VesselCallPage(driver);
        }
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @AfterClass
    public void generateReport() throws IOException {
        //onGenerateAllureReport();
        FileUtils.deleteDirectory(new File("target/allure-results"
        ));
    }

    public void switchTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void switchFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Clone')]")));
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
    }
    public void refresh() {
        driver.navigate().refresh();
    }

    public void jsonReader() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("TestData\\data.json"));
    }

//    private void onGenerateAllureReport() {
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            public void run() {
//                try {
//                    final List<Extension> extensions;
//                    extensions = (List<Extension>) Arrays.asList(new JacksonContext(), new MarkdownContext(),
//                            new FreemarkerContext(), new RandomUidContext(), new MarkdownDescriptionsPlugin(),
//                            new RetryPlugin(), new RetryTrendPlugin(), new TagsPlugin(),
//                            new SeverityPlugin(), new OwnerPlugin(), new IdeaLinksPlugin(), new CategoriesPlugin(),
//                            new CategoriesTrendPlugin(), new HistoryPlugin(), new HistoryTrendPlugin(),
//                            new DurationPlugin(), new DurationTrendPlugin(), new StatusChartPlugin(),
//                            new TimelinePlugin(), new SuitesPlugin(), new TestsResultsPlugin(),
//                            new AttachmentsPlugin(), new MailPlugin(), new InfluxDbExportPlugin(),
//                            new PrometheusExportPlugin(), new SummaryPlugin(), new ExecutorPlugin(),
//                            new LaunchPlugin(), new Allure1Plugin(), new Allure1EnvironmentPlugin(),
//                            new Allure2Plugin(), new ReportWebPlugin());
//                    Configuration configuration = (new ConfigurationBuilder()).fromExtensions(extensions).build();
//                    Path resultDi = Paths.get("user.dir/allure-results");
//                    Path outDir = Paths.get("target/allure-report");
//                    new ReportGenerator(configuration).generate(outDir, resultDi);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}