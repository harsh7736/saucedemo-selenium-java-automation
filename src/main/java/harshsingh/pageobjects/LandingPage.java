
package harshsingh.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import harshsingh.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passwordEle;

    @FindBy(id = "login-button")
    private WebElement submitBtn;

    @FindBy(css = ".error-message-container")
    private WebElement errorMessage;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductCatalogue loginApplication(String name, String password) {
        userName.sendKeys(name);
        passwordEle.sendKeys(password);
        submitBtn.click();
        return new ProductCatalogue(driver);
    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo() {
        driver.get("https://www.saucedemo.com/");
    }
}