package harshsingh.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import harshsingh.TestComponents.BaseTest;
import harshsingh.pageobjects.CartPage;
import harshsingh.pageobjects.CheckoutPage;
import harshsingh.pageobjects.ConfirmationPage;
import harshsingh.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
    String productName = "Sauce Labs Backpack";
    private ConfirmationPage confirmationPage;

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws IOException {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("name"), input.get("password"));

        productCatalogue.sortByPriceHighToLow();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match, "Expected product was not found in cart!");

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.enterUserInfo("Harsh", "Singh", "12345");
        confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
    }

    @Test
    public void VerifyBackHomeNavigation() throws IOException {
        landingPage = launchApplication();
        ProductCatalogue productCatalogue = landingPage.loginApplication("standard_user", "secret_sauce");

        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Assert.assertTrue(cartPage.verifyProductDisplay(productName));

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.enterUserInfo("Harsh", "Singh", "560050");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        ProductCatalogue homeCatalogue = confirmationPage.clickBackHome();
        List<WebElement> products = homeCatalogue.getProductList();
        Assert.assertTrue(products.size() > 0, "Products not visible after Back Home navigation!");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\harshsingh\\data\\PurchaseOrder.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
}