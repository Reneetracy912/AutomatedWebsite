package ReneeDishPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ReneeDishPractice.reusableComponent.AbstractComponents;

public class OrderPage extends AbstractComponents{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    //pageFactory
	

	@FindBy(css="tr td:nth-child(3)")
	List <WebElement> productName ;
	
	
  
    public boolean OrdersToDisplay(String ProductName) {
    	
		Boolean match = productName.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
    }
    

}
