package ReneeDishPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ReneeDishPractice.reusableComponent.AbstractComponents;

public class checkoutpage extends AbstractComponents{
		WebDriver driver;
		public checkoutpage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(css=".action__submit")
		WebElement submit;
		@FindBy(css="[placeholder='Select Country']")
		WebElement country;
		@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement selectCountry;
		By results = By.cssSelector(".ta-results");
		public void selectCountry(String countryname) {
			Actions a = new Actions(driver);
			a.sendKeys(country,countryname).build().perform();
			waitForElementToAppear(results);
			driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
			selectCountry.click();
		}
		public Confirmationpage submitOrder() {
			submit.click();
			return new Confirmationpage(driver);
		}
		

}
