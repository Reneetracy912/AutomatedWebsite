package ReneeDishPractice.reusableComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReneeDishPractice.CartPage;
import ReneeDishPractice.OrderPage;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "[routerLink*='cart']")
	WebElement cartheaderClick;
	
	@FindBy(css="[routerLink*='myorders']")
	WebElement orderHeadersclick;

	public void waitForElementToAppear( By findby) {
		WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//if we are giving visibility of element located then no need to giver driver.findelemnt 
		//we are not locating by driver we are locating by BY element so we are writing generic element By
		Wait.until(ExpectedConditions.visibilityOfElementLocated(findby));


		
	}
	public void waitForElementToDisAppear( WebElement findby) throws InterruptedException {
		Thread.sleep(1000);
		//WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//if we are giving visibility of element located then no need to giver driver.findelemnt 
		//we are not locating by driver we are locating by BY element so we are writing generic element By
		//Wait.until(ExpectedConditions.invisibilityOf(findby));
}
	  public CartPage clickCartheaderPage() {
		  cartheaderClick.click();
	     CartPage cartpge = new CartPage(driver);
	     return cartpge;
	    	
			
		}
	  
	  public OrderPage clickOrderPage() {
		  orderHeadersclick.click();
		  OrderPage orderPage = new OrderPage(driver);
	     return orderPage;
	    	
			
		}
	
}
