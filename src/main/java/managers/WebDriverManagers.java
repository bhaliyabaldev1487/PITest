package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.Base;
import constant.WaitConstant;
import helpers.WebActions;
import helpers.WebDriverWaitManager;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * WebDriverManager to handle Driver
 * @author baldevbhaliya
 *
 */
public class WebDriverManagers extends Base{
	
	private WebDriverManagers() {
	}
	
	/**
	 * Single instance of Class
	 * @return
	 */
	public static WebDriver getInstance() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			WebDriverManagers.driver = WebDriverManagers.setup();
			new WebDriverWaitManager(WebDriverManagers.driver);
			new WebActions(WebDriverManagers.driver);
			return driver;
		} else {
			return driver;
		}
	}
	/**
	 * Setting up driver
	 * @return
	 */
	public static WebDriver setup() {
		driver = getInstance();
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * Quitting after excution
	 */
	public static void Close() {
		driver.quit();
	}
}
