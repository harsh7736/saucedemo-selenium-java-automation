
package harshsingh.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import harshsingh.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".complete-header")
    private WebElement confirmationMessage;

    @FindBy(id = "back-to-products")
    private WebElement backHomeBtn;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public ProductCatalogue clickBackHome() {
        waitForWebElementToAppear(backHomeBtn);
        backHomeBtn.click();
        return new ProductCatalogue(driver);
    }
}