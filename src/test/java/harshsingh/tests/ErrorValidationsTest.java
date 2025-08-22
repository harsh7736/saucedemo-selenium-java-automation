package harshsingh.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import harshsingh.TestComponents.BaseTest;
import harshsingh.TestComponents.Retry;
import harshsingh.pageobjects.CartPage;
import harshsingh.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

    // ✅ Negative test - Will pass if the error message appears correctly
    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException {
        SoftAssert soft = new SoftAssert();

        landingPage.loginApplication("invalid_user", "secret_sauce");

        soft.assertEquals(
            landingPage.getErrorMessage(),
            "Epic sadface: Username and password do not match any user in this service"
        );

        soft.assertAll(); // If assertion fails, only this test fails
    }

    // ✅ Negative test - product mismatch should return false
    @Test(groups = {"ErrorHandling"})
    public void ProductErrorValidation() throws IOException {
        String productName = "Sauce Labs Backpack";

        ProductCatalogue productcatalogue = landingPage.loginApplication("standard_user", "secret_sauce");

        List<WebElement> products = productcatalogue.getProductList();
        productcatalogue.sortByPriceHighToLow();
        productcatalogue.addProductToCart(productName);
        CartPage cartPage = productcatalogue.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay("Sauce Labs Backpack");
        Assert.assertTrue(match, "Expected product was not found in cart!");
    }

    
}