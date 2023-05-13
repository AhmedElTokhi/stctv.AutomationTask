package Utils;

//::Reference:: http://toolsqa.com/selenium-webdriver/factory-design-principle-in-frameworks/

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;

public class WebDriverFactory {

	private static WebDriver driver;

	public WebDriverFactory(WebDriver driver) {

		// Make class driver= method input driver that will be sent from test Case (that create object from this class)
		WebDriverFactory.driver = driver;
		//OR
//		this.driver = driver;
	}

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	public static WebDriver Driver_Default(@Optional("Chrome") String browserName) {
		System.out.println("@Start Factory Driver");

		switch (browserName.toLowerCase()) {
		case "chrome":
			// get recently opened driver if it exist
			driver = drivers.get("chrome");

			// Create new driver
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\ChromeDriver.exe");
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;

		case "firefox":
			// get recently opened driver if it exist
			driver = drivers.get("firefox");

			// Create new driver
			if (driver == null) {
				System.setProperty("webdriver.gecko.driver", ".\\WebDriver\\geckodriver.exe");			
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
			
		case "ie":
			// get recently opened driver if it exist
			driver = drivers.get("ie");

			// Create new driver
			if (driver == null) {
				System.setProperty("webdriver.ie.driver", ".\\WebDriver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				drivers.put("IE", driver);
			}
			break;			
			}
			driver.manage().window().maximize();
			return driver;
	}
}
