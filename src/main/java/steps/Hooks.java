package steps;

import base.ControlActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Scenario Name : "+scenario.getName());
		System.out.println("Scenario Tags : "+scenario.getSourceTagNames());
		ControlActions.launchBrowser();
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			scenario.attach("byte format","media type -> jpeg or png","SS title");
		}
		ControlActions.closeBrowser();
	}
}
