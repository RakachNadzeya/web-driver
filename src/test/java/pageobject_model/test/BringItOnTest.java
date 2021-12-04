package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.PastebinHomePagePF;
import pageobject_model.page.PastebinPostedPastePagePF;

public class BringItOnTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Scenario for Bring It On task")
    public void newBasicPasteCreationWithNameExpirationAndHighlighting() {

        PastebinPostedPastePagePF pastebinPostedPastePage;
        pastebinPostedPastePage = new PastebinHomePagePF(driver)
                .openPage()
                .enterCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .selectHighlighting()
                .selectExpiration()
                .enterName("how to gain dominance among developers")
                .savePaste();

        Assert.assertTrue(pastebinPostedPastePage.getBrowserPageTitle().contains("how to gain dominance among developers"));

        Assert.assertTrue(pastebinPostedPastePage.getCurrentHighlightingOption().contains("Bash"));

        Assert.assertTrue(pastebinPostedPastePage.getPastedCode().contentEquals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force"));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}