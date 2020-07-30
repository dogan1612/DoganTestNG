package Component.Pages;

import Framework.Core.Driver;
import Framework.Core.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LandingPage extends TestBase {


    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_count")
    public WebElement userCount;

    @FindBy(xpath = "//a[@id='navbarDropdown']//span")
    public WebElement username;

    @FindBy(xpath = "//a[@id='navbarDropdown']//span")
    public WebElement title;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logoutButton;

    public void logout() {
        WebElement step1 = Driver.getDriver().findElement(By.xpath("//a[@id='navbarDropdown']"));
        step1.click();
        logoutButton.click();
    }

    public void verifyPageTitle(String title) {
        Assert.assertEquals(Driver.getDriver().getTitle(), title);
    }

    public void waitForLandingPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) Driver.getDriver()).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            wait.until(expectation);
        } catch (StaleElementReferenceException | InterruptedException e) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
        System.out.println("waited");
    }


}
