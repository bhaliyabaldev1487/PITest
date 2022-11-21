package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;
import constant.Endpoints;
import io.cucumber.java.en.Given;
import pom.HomePage;

/**
 * All Home Page step definations provided here
 * @author baldevbhaliya
 *
 */
public class HomePageActions extends Base{
	WebElement menuOption, tagsSection, acceptCookies;
	public final String TAG_NAME = "python";
	
	@Given("^Visit Stackoverflow$")
	public void visit_Stackoverflow() throws Throwable {
			driver.get(Endpoints.URL);
			
			acceptCookies = waitManager.waitForElementToAppear(driver.findElement(By.xpath(HomePage.ACCEPT_COOKIES))); 
			acceptCookies.click();
			Thread.sleep(2000);
		System.out.println("TAGNAME================="+ System.getProperty("tagName"));
			stkContext.setTagName(System.getProperty("tagName"));
		}

	@Given("^Click on Side Top Menu Bar$")
	public void click_on_Side_Top_Menu_Bar() throws Throwable {
		
		menuOption = waitManager.waitForElementToBeClickable(driver.findElement(By.xpath(HomePage.TOPBAR_MENU)));
		menuOption.click();
	}

	@Given("^Select Tags option$")
	public void select_Tags_option() throws Throwable {
		tagsSection = waitManager.waitForElementToBeClickable(driver.findElement(By.id(HomePage.MENU_TAG_SECTION)));
		tagsSection.click();
	}
}
