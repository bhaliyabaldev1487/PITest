package stepdefinations;

import base.Base;
import context.StackOverFlowContext;
import helpers.WebActions;
import helpers.WebDriverWaitManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.WebDriverManagers;

/**
 * Setting up Before And After Hooks for initialization of Drivers And managers
 * @author baldevbhaliya
 *
 */
public class CommonActions extends Base{

	@Before
	public void initDriverManagers() {
		Base.driver = WebDriverManagers.getInstance();
		Base.actions = WebActions.getInstance(Base.driver);
		Base.waitManager = WebDriverWaitManager.getInstance(Base.driver);
		Base.stkContext = new StackOverFlowContext();
				
	}
	
	@After
	public void exit() {
		Base.driver.quit();
	}

}
