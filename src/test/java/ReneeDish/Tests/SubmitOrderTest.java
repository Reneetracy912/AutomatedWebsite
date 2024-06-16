package ReneeDish.Tests;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ReneeDish.TestComponent.BaseComponent;
import ReneeDishPractice.CartPage;
import ReneeDishPractice.Confirmationpage;
import ReneeDishPractice.LandingPage;
import ReneeDishPractice.OrderPage;
import ReneeDishPractice.ProductCatalog;
import ReneeDishPractice.checkoutpage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SubmitOrderTest extends BaseComponent{
	String ProductName = "ZARA COAT 3";
	@Test(dataProvider = "getData",groups = {"purchaseOrder"})
	public void submitOrder(HashMap<String,String> input ) throws InterruptedException, IOException{
		
		
	
		ProductCatalog prodCatalog=landPage.loginApplication(input.get("email"),input.get("password"));
		
		List<WebElement> products = prodCatalog.getProducts();
		prodCatalog.addProductToCart(input.get("product"));
		CartPage cartpge = prodCatalog.clickCartheaderPage();

		Boolean match = cartpge.checkCart(input.get("product"));
		Assert.assertTrue(match);
		checkoutpage checkout = cartpge.gotocheckout();
		checkout.selectCountry("india");
		Confirmationpage confirmpage = checkout.submitOrder();
		String ConfirmMessage = confirmpage.verifyConfirmationMessage();
		
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
	}
	@Test (dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalog prodCatalog=landPage.loginApplication("anshika@gmail.com","Iamking@000");
		OrderPage OrderPage =prodCatalog.clickOrderPage();
		Assert.assertTrue(OrderPage.OrdersToDisplay(ProductName));
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "anshika@gmail.com");
//		map.put("password", "Iamking@000");
//		map.put("product", "ZARA COAT 3");
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "shettygmail.com");
//		map1.put("password", "Iamkingg");
//		map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String,String>> data=jasonDataToMap(System.getProperty("user.dir")+"C:\\Users\\reneetracy.vr\\eclipse-workspace\\SeleniumPractice\\src\\test\\java\\ReneeDishData\\PurchaseOrder.json");
		
		
		return new Object[][]{{data.get(0)},{data.get(0)}};
	}
	
	
//	public  String getScreenshot(String testcasename)throws IOException{
//		TakeScreenshot ts = (TakeScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir")+"//reports//" +testcasename+".png");
//		FileUtils.copyFile(source,file);
//		return System.getProperty("user.dir")+"//reports//" +testcasename+".png";
//		
//		
//	}
	
	

}
