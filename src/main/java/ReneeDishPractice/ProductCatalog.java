package ReneeDishPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ReneeDishPractice.reusableComponent.AbstractComponents;

public class ProductCatalog extends AbstractComponents{
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    //pageFactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement disappear;
	
	@FindBy(css=".catSection h3")
	List <WebElement> cartProducts;
	
	By productBy =By.cssSelector(".mb-3");
	 By addtocart = By.cssSelector(".card-body button:last-of-type");
	 By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(productBy);
		return products;
	}
	public WebElement getProductByName(String ProductName) {

		WebElement Prod = getProducts().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return Prod;
	}
	public void addProductToCart(String ProductName) throws InterruptedException {
		WebElement Prod = getProductByName(ProductName);
		Prod.findElement(addtocart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisAppear(disappear);
		

	}
  
    public boolean checkCart(String ProductName) {
    	
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
    }

}
