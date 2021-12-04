package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleCloudSearchResultsPagePF extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'gsc-webResult')]")
    private List<WebElement> generalSearchResults;

    @FindBy(xpath = "//a[@class = 'gs-title' and contains(@href, 'https://cloud.google.com/products/calculator')]")
    private WebElement searchLink;

    public GoogleCloudSearchResultsPagePF(WebDriver driver) {
        super(driver);
    }


    public GoogleCloudPricingCalculatorPagePF openSearchResultPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .visibilityOfAllElements(generalSearchResults));
        searchLink.click();
        return new GoogleCloudPricingCalculatorPagePF(driver);
    }

}