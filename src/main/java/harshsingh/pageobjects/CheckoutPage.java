
package harshsingh.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import harshsingh.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement submitBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserInfo(String name, String lname, String pcode) {
        firstName.sendKeys(name);
        lastName.sendKeys(lname);
        postalCode.sendKeys(pcode);
        continueBtn.click();
    }

    public ConfirmationPage submitOrder() {
        submitBtn.click();
        return new ConfirmationPage(driver);
    }
}