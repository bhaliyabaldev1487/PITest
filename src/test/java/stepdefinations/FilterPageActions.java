package stepdefinations;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;
import io.cucumber.java.en.When;
import pom.TagsPage;

/**
 * All Filter page step definations provided here
 * @author baldevbhaliya
 *
 */
public class FilterPageActions extends Base {

	WebElement searchFilter, exactMatchTag;
	List<WebElement> listOfSearchTags;
	ListIterator<WebElement> lit;
//	public final String TAG_NAME = "javascript"; // for testing purpose
	
	
	@When("^Search for tagname in filter section$")
	public void search_for_tagname_in_filter_section() throws Throwable {
		searchFilter = waitManager.waitForElementToBeVisible(driver.findElement(By.id(TagsPage.FILTER_SEARCH)));
		searchFilter.sendKeys("");
		searchFilter.sendKeys(stkContext.getTagName());
//		searchFilter.sendKeys(TAG_NAME);
	}
	
	@When("^Select exact match tag$")
	public void select_exact_match_tag() throws Throwable {
		
		listOfSearchTags = waitManager.waitForAllElementToBeVisible(driver.findElements(By.xpath(TagsPage.LIST_SEARCH_TITLE)));
		lit = listOfSearchTags.listIterator();
		
		while(lit.hasNext()) {
			WebElement title = (WebElement)lit.next();
			//pass it from commandline
//			if(stkContext.getTagName().equalsIgnoreCase(title.getText())) {
			if(stkContext.getTagName().equalsIgnoreCase(title.getText())) {
				exactMatchTag = title;
				exactMatchTag.click();
				break;
			}
		}
	}
	
}
