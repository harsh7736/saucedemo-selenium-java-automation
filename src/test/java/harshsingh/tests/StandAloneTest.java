package harshsingh.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import harshsingh.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {

		String productName = "Sauce Labs Backpack";
		
		// Setup WebDriver
		WebDriverManager.chromedriver().setup();
		
		// Configure Chrome options
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", java.util.Map.of(
		    "credentials_enable_service", false,
		    "profile.password_manager_enabled", false
		));
		
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement sortDropdown = wait.until(
		    ExpectedConditions.elementToBeClickable(By.cssSelector("select.product_sort_container"))
		);

		Select select = new Select(sortDropdown);
		select.selectByVisibleText("Price (high to low)");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item")));

		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
		
		WebElement prod = products.stream().filter(product ->
			product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)
		).findFirst().orElse(null);
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart_link"))).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> 
			cartProduct.getText().equalsIgnoreCase(productName)
		);
		Assert.assertTrue(match);
		
		driver.findElement(By.id("checkout")).click();  
		driver.findElement(By.id("first-name")).sendKeys("Harsh");
		driver.findElement(By.id("last-name")).sendKeys("singh");
		driver.findElement(By.id("postal-code")).sendKeys("560050");
		
		driver.findElement(By.id("continue")).click(); 
	    driver.findElement(By.id("finish")).click();
	    
	    String confirmMessage = driver.findElement(By.cssSelector(".complete-header")).getText();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
	    
	    driver.close();
	    
	    
	    
			
	}
}
