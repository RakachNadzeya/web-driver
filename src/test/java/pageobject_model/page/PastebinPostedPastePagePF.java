package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPostedPastePagePF extends AbstractPage{

    @FindBy(xpath = "//a[contains (@href, '/archive/')]")
    private WebElement highlighting;

    @FindBy(xpath = "//textarea")
    private WebElement enteredCode;

    public PastebinPostedPastePagePF(WebDriver driver) {
        super(driver);
    }

    public String getBrowserPageTitle(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(highlighting));
        return driver.getTitle();
    }

    public String getCurrentHighlightingOption(){
        return highlighting.getText();
    }

    public String getPastedCode(){
        return enteredCode.getText();
    }
}