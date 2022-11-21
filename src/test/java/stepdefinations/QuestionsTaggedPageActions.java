package stepdefinations;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.Base;
import helpers.WebActions;
import io.cucumber.java.en.When;
import pom.QuestionsTaggedPage;
import utils.CommonUtilities;

/**
 * All Questions Tagged Page step definations provided here
 * @author baldevbhaliya
 *
 */
public class QuestionsTaggedPageActions extends Base{

	WebElement moreRelatedTagsLink, feedLink;
	List<WebElement>  listOfRelatedTags;
	HashMap<String, Integer> relatedTagNameCountMap = new HashMap<String, Integer>();
	ListIterator<WebElement> lit;
	public final String TAG_NAME = "python";
	
	/**
	 * Using HashMap<String, Integer> to store Related Tags name & count
	 * @throws Throwable
	 */
	@When("^List down all related tags$")
	public void list_down_all_related_tags() throws Throwable {		
		listOfRelatedTags = waitManager.waitForAllElementToBeLocatedBy(By.xpath(QuestionsTaggedPage.LIST_RELATED_TAGS));
		lit = listOfRelatedTags.listIterator();

		moreRelatedTagsLink = waitManager.waitForElementToBeLocatedBy(By.xpath(QuestionsTaggedPage.MORE_RELATED_SEARCH_LINK));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", moreRelatedTagsLink);
		actions.scrollToElement(moreRelatedTagsLink, driver);
		
		moreRelatedTagsLink.click();
		
		// Iterating over a list of Related Tags to get Data-Name & it's Count 
		WebElement tag;
		while(lit.hasNext()) {
			tag = lit.next();
			String title = tag.getAttribute("data-name");
			String count = waitManager.waitForElementToAppear(tag.findElement(By.xpath(QuestionsTaggedPage.RELATED_TAGS_COUNT))).getText();
			System.out.println("Title: \t"+ title +"\tCount: "+ count);
			relatedTagNameCountMap.put(title, Integer.parseInt(count));
		}
		
		// Just to print iterating over a Map
		CommonUtilities.displayTitleAndCount(relatedTagNameCountMap);
	}

}
