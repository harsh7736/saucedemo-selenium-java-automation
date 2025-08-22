package harshsingh.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import harshsingh.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".inventory_item")
    private List<WebElement> products;

    private By productsBy = By.cssSelector(".inventory_item");
    private By addToCart = By.cssSelector("button.btn_inventory");
    private By toastMessage = By.cssSelector(".shopping_cart_link");
    private By sortDropdownBy = By.cssSelector("select.product_sort_container");

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortByPriceHighToLow() {
        waitForElementToAppear(sortDropdownBy);
        WebElement sortDropdown = driver.findElement(sortDropdownBy);
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Price (high to low)");
        waitForElementToAppear(productsBy);
    }

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return products.stream()
                .filter(product -> product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
    }
}