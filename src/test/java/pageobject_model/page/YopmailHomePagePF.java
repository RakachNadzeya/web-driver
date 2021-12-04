package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class YopmailHomePagePF extends AbstractPage {

    @FindBy(xpath = "//*[@id='listeliens']/a[@href='email-generator']")
    private WebElement emailGeneratorLink;

    @FindBy(id = "cprnd")
    private WebElement copyToClipboardButton;

    @FindBy(xpath = "//button [@onclick='egengo();']")
    private WebElement checkEmailButton;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//h3[contains (., 'USD')]")
    private WebElement totalSumInEmail;

    public YopmailHomePagePF(WebDriver driver) {
        super(driver);
    }

    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

    public GoogleCloudPricingCalculatorPagePF copyGeneratedEmail() {
        driver.switchTo().window(tabs.get(1));
        emailGeneratorLink.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(copyToClipboardButton));
        copyToClipboardButton.click();
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        return new GoogleCloudPricingCalculatorPagePF(driver);
    }

    public YopmailHomePagePF waitForEmail() {
        checkEmailButton.click();
        refreshButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(totalSumInEmail));
        return this;
    }

    public String getTotalSumInEmail(){
        return totalSumInEmail.getText();
    }

}