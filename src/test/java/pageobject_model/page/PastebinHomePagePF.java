package pageobject_model.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class PastebinHomePagePF extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement newPasteInput;

    @FindBy(id = "select2-postform-format-container")
    private WebElement highlightingList;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement optionFromHighlightingList;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationList;

    @FindBy(xpath = "//li[text() = '10 Minutes']")
    private WebElement optionFromPasteExpirationList;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement submitButton;

    public PastebinHomePagePF(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PastebinHomePagePF enterCode(String code) {
        newPasteInput.sendKeys(code);
        return this;
    }

    public PastebinHomePagePF selectHighlighting() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newPasteInput);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(highlightingList));
        highlightingList.click();
        optionFromHighlightingList.click();
        return this;
    }

    public PastebinHomePagePF selectExpiration() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", highlightingList);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(pasteExpirationList));
        pasteExpirationList.click();
        optionFromPasteExpirationList.click();
        return this;
    }

    public PastebinHomePagePF enterName(String pasteName) {
        pasteNameInput.sendKeys(pasteName);
        return this;
    }

    public PastebinPostedPastePagePF savePaste() {
        submitButton.click();
        return new PastebinPostedPastePagePF(driver);
    }

}
