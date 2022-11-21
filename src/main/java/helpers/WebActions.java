package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * All web related actions provided here like scrolling, hovering
 * @author baldevbhaliya
 *
 */
public class WebActions {

	Actions actions;
	
	public static WebActions webActions = null;
	
	public WebActions(WebDriver driver) {
		actions = new Actions(driver);
	}
	
	public static WebActions getInstance(WebDriver driver) {
		if(webActions == null) {
			return new WebActions(driver);
		}
		else 
			return webActions;
	}
	
	public static WebActions getInstance() {
			return webActions;
	}

	public void scrollToElement(WebElement element, WebDriver driver) {
		getInstance();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);	}
}
