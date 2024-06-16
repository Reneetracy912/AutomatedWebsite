package ReneeDish.TestComponent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;

import ReneeDishData.ObjectMapper;
import ReneeDishPractice.LandingPage;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseComponent {
	public WebDriver driver; 
	public LandingPage landPage;
	public WebDriver initializeDriver() throws IOException{
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ReneeDishPractice\\resources\\Globaldata.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
		else if(browsername.equalsIgnoreCase("firefox")) {
			//firefox
		}
        else if(browsername.equalsIgnoreCase("edge")) {
			//edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> jasonDataToMap(String filePath) throws IOException {
		//read json content to string
		String JsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	//convert string to hash map 
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap<String,String>> data = mapper.readValue(JsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
		
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
	
	@BeforeMethod(alwaysRun=true)
	 public LandingPage LaunchApplication() throws IOException {
		driver = initializeDriver();
		LandingPage landPage=new LandingPage(driver);
		landPage.Goto();
		return landPage;
		 
	 }
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.close();
		
	}
	
}


