package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.PastebinHomePagePF;
import pageobject_model.page.PastebinPostedPastePagePF;

public class ICanWinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Scenario for I Can Win task")
    public void newBasicPasteCreationWithNameAndExpirationScenario() {
        PastebinPostedPastePagePF pastebinPostedPastePage;
        pastebinPostedPastePage = new PastebinHomePagePF(driver)
                .openPage()
                .enterCode("Hello from WebDriver")
                .selectExpiration()
                .enterName("helloweb")
                .savePaste();
        //there can be some assert method

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}