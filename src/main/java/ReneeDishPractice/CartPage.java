package ReneeDishPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ReneeDishPractice.reusableComponent.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    //pageFactory
	

	@FindBy(css=".catSection h3")
	List <WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
  
    public boolean checkCart(String ProductName) {
    	
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
    }
    public checkoutpage gotocheckout() {
    	checkout.click();
    	checkoutpage checkout = new checkoutpage(driver);
    	return checkout;
    	
    }
    
}
