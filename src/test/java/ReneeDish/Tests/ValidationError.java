package ReneeDish.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ReneeDish.TestComponent.BaseComponent;
import ReneeDishPractice.CartPage;
import ReneeDishPractice.ProductCatalog;

public class ValidationError extends BaseComponent {
	@Test(groups={"Error validation"})
	public void landingPageValidation() {
		
		String ProductName = "ZARA COAT 3";
		
	//invalidemail
		landPage.loginApplication("anshigmail.com","Iamking@000");
		Assert.assertEquals("Incorrect email or password", landPage.ErrorMessageText());

}
	
	@Test
	//negative test case to sending wrong value
	public void cartpageValidation() throws InterruptedException, IOException{
		
		String ProductName = "ZARA COAT 3";
	
		ProductCatalog prodCatalog=landPage.loginApplication("anshika@gmail.com","Iamking@000");
		
		List<WebElement> products = prodCatalog.getProducts();
		prodCatalog.addProductToCart(ProductName);
		CartPage cartpge = prodCatalog.clickCartheaderPage();

		Boolean match = cartpge.checkCart("ZARACOAT 23");
		Assert.assertFalse(match);
}
}