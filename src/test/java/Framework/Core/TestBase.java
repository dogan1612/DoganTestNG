package Framework.Core;

import Framework.Utilities.BrowserUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //should be public/protected !!!!
    protected WebDriver driver;
    protected Pages pages;
    protected SoftAssert softAssert;

    // To generate reports, we need to instantiate these classes in test base
    protected static ExtentReports extent;
    protected static ExtentSparkReporter spark;
    protected static ExtentTest test;
    private static final Logger logger = LogManager.getLogger();


    @BeforeSuite(alwaysRun = true)
    @Parameters("test")
    public void setUpTest(@Optional String test) {
        if (test == null) {
            test = "reports";
        }
        extent = new ExtentReports();
    /*
        To generate the report under project folder (/Users/kubilaydogan/IdeaProjects/SeleniumProject/test-output/... )
        System.getProperty("user.dir") ---> get the path to current project -->
           Example:  /Users/kubilaydogan/IdeaProjects/SeleniumProject
    */
        String filePath = System.getProperty("user.dir") + "/test-output/" + test + "/" + LocalDate.now().format(DateTimeFormatter.ofPattern("MM_dd_yyyy")) + "/report.html";
        spark = new ExtentSparkReporter(filePath);
        logger.info("Report path: "+filePath);
//        spark = new ExtentSparkReporter("target/Spark.html");       // alternative to line 47-49
        extent.attachReporter(spark);

        spark.config().setDocumentTitle("Library Test automation");
        spark.config().setReportName("Library Test Report");

        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));

        if (System.getenv("runner") != null) {
            TestBase.test.info("Running: " + System.getenv("runner"));
        }
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional String browser) {
        driver = Driver.getDriver(browser);
        pages = new Pages();
        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String URL = ConfigurationReader.getProperty("url"+ConfigurationReader.getProperty("environment"));
        driver.get(URL);
        logger.info("URL: "+URL);
    }

    @AfterMethod(alwaysRun = true)
    @Parameters("browser")
    public void teardown(@Optional String browser, ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {            // if test fails,
            // get screenshot using the utility method and save the location of the screenshot
            String screenshotLocation = BrowserUtils.getScreenshot(result.getName());
            test.fail(result.getName());                            // capture the name of test method
            test.addScreenCaptureFromPath(screenshotLocation);      // add the screenshot to the report
//            test.fail(result.getThrowable());                       // capture the exception thrown
            test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Case Skipped in " + result.getName());
        }
        if(browser == null){
            browser = ConfigurationReader.getProperty("browser");
        }
        test.log(Status.INFO, MarkupHelper.createLabel("Browser: "+browser, ExtentColor.ORANGE));
        softAssert.assertAll();
        Driver.closeDriver();
    }

    // Flush method is used to erase any previous data on the report and create a new report.
    @AfterSuite(alwaysRun = true)
    public void tearDownTest() {
        logger.info(":: FLUSHING REPORT ::");
        extent.flush();
    }
}
