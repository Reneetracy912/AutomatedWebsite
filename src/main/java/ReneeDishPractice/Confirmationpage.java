package ReneeDishPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReneeDishPractice.reusableComponent.AbstractComponents;

public class Confirmationpage extends AbstractComponents{
	WebDriver driver;
	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	public String verifyConfirmationMessage() {
		return confirmationMessage.getText();
		
	}
}
