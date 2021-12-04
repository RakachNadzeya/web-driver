package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePagePF extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    public GoogleCloudHomePagePF(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudSearchResultsPagePF searchForTerms(String term) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.sendKeys(term);
        searchInput.submit();
        return new GoogleCloudSearchResultsPagePF(driver);
    }

}