package helpers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.WaitConstant;


public class WebDriverWaitManager {
	WebDriver driver;
	public static WebDriverWaitManager waitManager = null;
	
	public WebDriverWaitManager( WebDriver driver) {
		this.driver = driver;
	}
	
	public static WebDriverWaitManager getInstance(WebDriver driver) {
		if(waitManager == null) {
			waitManager = new WebDriverWaitManager(driver);
			return waitManager;
		}
		else 
			return waitManager;
	}
	
    public void waitForPageToLoad(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.TIMEOUT_LONG));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
    
    public WebElement waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.TIMEOUT_OVERLAY));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.TIMEOUT_LONG));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.TIMEOUT_OVERLAY));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public WebElement waitForElementToBeLocatedBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.TIMEOUT_OVERLAY));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    public List<WebElement> waitForAllElementToBeLocatedBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.TIMEOUT_OVERLAY));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    
    public List<WebElement> waitForAllElementToBeVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.TIMEOUT_OVERLAY));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
	
	
}
