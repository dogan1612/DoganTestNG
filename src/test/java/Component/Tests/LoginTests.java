package Component.Tests;

import Framework.Core.ConfigurationReader;
import Framework.Core.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test(description = "Login with valid credentials and verify successful login")
    public void loginTest() {
        test = extent.createTest("Login as student");
        String username = ConfigurationReader.getProperty("student95_user");
        String password = ConfigurationReader.getProperty("student95_pass");

        pages.loginPage().login(username, password);
        pages.landingPage().waitForLandingPageToLoad();
        pages.landingPage().verifyPageTitle("Library");
        test.pass("Page title verified");
    }

    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest() {
        test = extent.createTest("Negative login test");
        test.info("Login with wrong username and wrong password");
        pages.loginPage().login("wrongusername", "wrongpassword");

        Assert.assertEquals(pages.loginPage().getErrorMessage(), "Please enter a valid email address.");
        // or
        softAssert.assertEquals(pages.loginPage().getErrorMessage(), "Please enter a valid email address.");

        test.pass("Alert message verified : " + pages.loginPage().getErrorMessage());
    }

    // ******************************************************************************

    @Test(dataProvider = "credentials_info")        // get data from data provider
    public void loginWithDataProvider(String username, String password) {
        test = extent.createTest("Login using @DataProvider");
        pages.loginPage().login(username, password);
        pages.landingPage().waitForLandingPageToLoad();
        pages.landingPage().verifyPageTitle("Library");
        test.pass("Login successful");
    }

    @DataProvider(name = "credentials_info")
    public static Object[][] credentials() {
        return new Object[][]{{"student12@library", "UC0LC9Hj"},
                {"student13@library", "zcVbvUWH"}};
    }
    // ******************************************************************************

    @Parameters({"username", "password"})     // get data from testng.xml
    @Test
    public void loginWithParameters(@Optional String username, @Optional String password) {
        test = extent.createTest("Login using @Parameters");
        if (username == null) {
            username = ConfigurationReader.getProperty("student95_user");
            password = ConfigurationReader.getProperty("student95_pass");
        }
        test.info("Login as: " + username);
        pages.loginPage().login(username, password);
        pages.landingPage().waitForLandingPageToLoad();
        pages.landingPage().verifyPageTitle("Library");
        test.pass("Page title verified");
    }
}


