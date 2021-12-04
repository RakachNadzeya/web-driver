package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.GoogleCloudHomePagePF;
import pageobject_model.page.YopmailHomePagePF;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Hardcore {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Scenario for Hurt Me Plenty task")
    public void filledFieldsAndTheResultAreCorrect() throws IOException, UnsupportedFlavorException {


        YopmailHomePagePF yopmailHomePagePF = new GoogleCloudHomePagePF(driver)
                .openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .openSearchResultPage()
                .enterNumberOfInstances("4")
                .enterVMClass()
                .enterSeries()
                .enterInstanceType()
                .selectAddGPUs()
                .enterNumberOfGPUs("1")
                .selectGPUType()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .estimate()
                .sendEstimateToEmail()
                .openMailGeneratorPage()
                .copyGeneratedEmail()
                .enterEmail()
                .sendEmail()
                .waitForEmail();

        Assert.assertTrue(yopmailHomePagePF.getTotalSumInEmail().contains("1,082.77"));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
