package Study.Annotations.DataProvider_fromExcel;

import Framework.Utilities.ExcelUtil;
import Framework.Core.Pages;
import Framework.Core.TestBase;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTLoginTests extends TestBase {

    @Test(dataProvider = "credentials_info")
    public void loginTestWithDataProvider(String execute, String username, String email, String password){
        Pages page = new Pages();
        test = extent.createTest("Data Driven Testing with excel file");    // Rapor basligi
        if(execute.equalsIgnoreCase("y")){
            page.loginPage().login(email, password);
            page.landingPage().logout();
            test.pass("Login as "+username+" successful");
        }else{
            throw new SkipException("Test ignored");
        }
    }

    @DataProvider(name="credentials_info")
    public Object[][] credentials(){
        ExcelUtil qa = new ExcelUtil("src/test/resources/Library user data.xlsx", "Sheet1");
        return qa.getData();
    }
}