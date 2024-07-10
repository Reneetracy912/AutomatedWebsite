package ReneeDishPractice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReneeDishPractice.reusableComponent.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
    //pageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement passwordEle;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(id="flyIn0ut")
	WebElement ErrorMessage;
	public ProductCatalog loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalog prodCatalog = new ProductCatalog(driver);
		return prodCatalog;
		
	}
	public String ErrorMessageText() {
		waitForWebElementToAppear(ErrorMessage);
		return ErrorMessage.getText();
	}
	private void waitForWebElementToAppear(WebElement errorMessage2) {
		// TODO Auto-generated method stub
		
	}
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
