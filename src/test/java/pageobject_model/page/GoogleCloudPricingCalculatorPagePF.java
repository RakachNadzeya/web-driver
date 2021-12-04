package pageobject_model.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class GoogleCloudPricingCalculatorPagePF extends AbstractPage {

    @FindBy(xpath = "//md-input-container [contains (.,'Number of instances')]//input")
    private WebElement inputNumberOfInstances;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClassList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='regular']")
    private WebElement optionFromMachineClassList;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[contains(.,'N1')]")
    private WebElement optionFromListSeries;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeList;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement optionFromMachineTypeList;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsList;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeList;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement optionFromGPUTypeList;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDList;

    @FindBy(xpath = "//md-option[@class='ng-scope md-ink-ripple']//div[contains(.,'2x375')]")
    private WebElement optionFromLocalSSDList;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocationList;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer' and contains(.,'Frankfurt (europe-west3)')]")
    private WebElement optionFromDatacenterLocationList;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsageList;

    @FindBy(xpath = "//md-select-menu[contains (@style, 'transform')]//md-option[contains (., '1 Year')]")
    private WebElement optionFromCommittedUsageList;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//form[@name = 'emailForm']")
    private WebElement emailYourEstimateForm;

    @FindBy(xpath = "//input[@type= 'email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button [@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']//div[contains(.,'VM class')]")
    private WebElement vMClassResult;

    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy']//div[contains(.,'Instance type')]")
    private WebElement instanceTypeResult;

    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy']//div[contains(.,'Region')]")
    private WebElement regionResult;

    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']//div[contains(.,'Local SSD')]")
    private WebElement localSSDResult;

    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']//div[contains(.,'Commitment term')]")
    private WebElement commitmentTermResult;

    @FindBy(xpath = "//b[@class = 'ng-binding' and contains (.,'Total Estimated Cost')]")
    private WebElement totalEstimatedCost;

    @FindBy(id = "email_quote")
    private WebElement emailEstimateButton;

    public GoogleCloudPricingCalculatorPagePF(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPagePF enterNumberOfInstances(String number) {
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        inputNumberOfInstances.click();
        inputNumberOfInstances.sendKeys(number);
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF enterVMClass() {
        machineClassList.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(optionFromMachineClassList));
        optionFromMachineClassList.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF enterSeries() {
        seriesList.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(optionFromListSeries));
        optionFromListSeries.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF enterInstanceType() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", machineTypeList);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(machineTypeList));
        machineTypeList.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionFromMachineTypeList));
        optionFromMachineTypeList.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectAddGPUs() {
        addGPUsCheckBox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF enterNumberOfGPUs(String number) {
        numberOfGPUsList.sendKeys(number);
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectGPUType() {
        GPUTypeList.click();
        optionFromGPUTypeList.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectLocalSSD() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(localSSDList));
        localSSDList.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionFromLocalSSDList));
        optionFromLocalSSDList.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectDatacenterLocation() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", machineTypeList);
        datacenterLocationList.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionFromDatacenterLocationList));
        optionFromDatacenterLocationList.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectCommittedUsage() {
        committedUsageList.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(optionFromCommittedUsageList));
        optionFromCommittedUsageList.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF estimate() {
        addToEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF sendEstimateToEmail() {
        emailEstimateButton.click();
        return this;
    }

    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

    public YopmailHomePagePF openMailGeneratorPage() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://yopmail.com/')");
        return new YopmailHomePagePF(driver);
    }

    public GoogleCloudPricingCalculatorPagePF enterEmail() throws IOException, UnsupportedFlavorException {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailYourEstimateForm);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(inputEmail));
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        inputEmail.click();
        inputEmail.sendKeys(myText);
        return this;
    }

    public YopmailHomePagePF sendEmail() {
        sendEmailButton.click();
        driver.switchTo().window(tabs.get(1));
        return new YopmailHomePagePF(driver);
    }


    public String getVMClass() {
        return vMClassResult.getText();
    }

    public String getInstanceTypeResult() {
        return instanceTypeResult.getText();
    }

    public String getRegionResult() {
        return regionResult.getText();
    }

    public String getLocalSSDResult() {
        return localSSDResult.getText();
    }

    public String getCommitmentTermResult() {
        return commitmentTermResult.getText();
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }

}