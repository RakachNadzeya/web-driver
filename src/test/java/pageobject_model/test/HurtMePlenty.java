package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.GoogleCloudHomePagePF;
import pageobject_model.page.GoogleCloudPricingCalculatorPagePF;

public class HurtMePlenty {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Scenario for Hurt Me Plenty task")
    public void filledFieldsAndTheResultAreCorrect() {

        GoogleCloudPricingCalculatorPagePF googleCloudPricingCalculatorPagePF;
        googleCloudPricingCalculatorPagePF = new GoogleCloudHomePagePF(driver)
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
                .estimate();

        Assert.assertTrue(googleCloudPricingCalculatorPagePF.getVMClass().contains("regular"));
        Assert.assertTrue(googleCloudPricingCalculatorPagePF.getInstanceTypeResult().contains("n1-standard-8"));
        Assert.assertTrue(googleCloudPricingCalculatorPagePF.getRegionResult().contains("Frankfurt"));
        Assert.assertTrue(googleCloudPricingCalculatorPagePF.getLocalSSDResult().contains("2x375"));
        Assert.assertTrue(googleCloudPricingCalculatorPagePF.getCommitmentTermResult().contains("1 Year"));
        Assert.assertTrue(googleCloudPricingCalculatorPagePF.getTotalEstimatedCost().contains("1,082.77 per 1 month"));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
