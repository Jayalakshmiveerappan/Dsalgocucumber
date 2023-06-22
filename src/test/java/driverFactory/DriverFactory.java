package driverFactory;

	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.safari.SafariDriver;

	import io.cucumber.java.Scenario;
	import io.github.bonigarcia.wdm.WebDriverManager;


	public class DriverFactory {

		public static WebDriver driver;

		public WebDriver initializeDrivers(String browser) {

			if (browser.equalsIgnoreCase("firefox")) {
				//Loggerload.info("Testing on firefox");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else  /*(browser.equalsIgnoreCase("chrome")) {
				//Loggerload.info("Testing on chrome");
				WebDriverManager.chromedriver().browserVersion("114.0.0").setup();
				//.browserVersion("108.0.0")
				driver = new ChromeDriver();*/
			if (browser.equals("chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				
				option.addArguments("--disable-dev-shm-usage");
				option.addArguments("--ignore-ssl-errors=yes");
				option.addArguments("--ignore-certificate-errors");
				WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
				driver = new ChromeDriver(option);

			} else if (browser.equalsIgnoreCase("safari")) {
				//Loggerload.info("Testing on safari");
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				//Loggerload.info("Testing on Edge");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			}
			// Set Page load timeout
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

			driver.manage().window().maximize();

			return driver;
		}

		public static WebDriver getdriver() {
			return driver;

		}

		public void closeallDriver() {
			driver.close();
		}

	}


