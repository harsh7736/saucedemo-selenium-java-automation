
package harshsingh.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import harshsingh.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> cartProducts;

    @FindBy(css = "#checkout")
    private WebElement checkoutEle;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductDisplay(String productName) {
        return cartProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckout() {
        checkoutEle.click();
        return new CheckoutPage(driver);
    }
}