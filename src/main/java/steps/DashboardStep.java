package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import pages.DashboardPage.Menu;

public class DashboardStep {
	
	private DashboardPage dashboardPage;
	
	public DashboardStep() {
		dashboardPage = new DashboardPage();
	}
	
	@And("User wait for dashboardpage to be loaded")
	public void user_wait_for_dashboardpage_to_be_loaded() {
		dashboardPage.waitForDashboardPageToBeLoaded();
	}
	
	@Then("User verify Invites Used, Total Assessments, Total Appeared, Total Qualified is visible")
	public void verifyInvitesAndAssessmentsAndAppearedAndQualified() {
		Assert.assertTrue("Invites Used is not displayed", dashboardPage.isCardDisplayed("Invites Used"));
		Assert.assertTrue("Total Assessments is not displayed", dashboardPage.isCardDisplayed("Total Assessments"));
		Assert.assertTrue("Total Appeared is not displayed", dashboardPage.isCardDisplayed("Total Appeared"));
		Assert.assertTrue("Total Qualified is not displayed", dashboardPage.isCardDisplayed("Total Qualified"));
	}
	
	@Then("User verify Total Assessments, Total Appeared, Total Qualified card must have value 0 or more")
	public void verifyCardValuesMustBeZeroOrMore() {
		int totalAssessment = dashboardPage.getValueFromCards("Total Assessments");
		Assert.assertTrue("Total Assessments value was not 0 or more, displayed value was " + totalAssessment,totalAssessment>=0);
		Assert.assertTrue("Total Appeared was not 0 or more", dashboardPage.getValueFromCards("Total Appeared")>=0);
		Assert.assertTrue("Total Qualified was not 0 or more",dashboardPage.getValueFromCards("Total Qualified")>=0);
	}
	
	@Then("User verify Assessments, Library, Candidates, Interviews tabs are visible")
	public void verifyTabsVisibile() {
		Assert.assertTrue("Assessments card is not displayed", dashboardPage.isMenuVisible(Menu.ASSESSMENT));
		Assert.assertTrue("Library card is not displayed", dashboardPage.isMenuVisible(Menu.LIBRARY));
		Assert.assertTrue("Candidates card is not displayed", dashboardPage.isMenuVisible(Menu.CANDIDATES));
		Assert.assertTrue("Interviews card is not displayed", dashboardPage.isMenuVisible(Menu.INTERVIEWS));
	}
	
	@Then("User verify Create Assessments and Create Question button is clickable")
	public void verifyBtnIsClickable() {
		Assert.assertTrue(dashboardPage.isCreateAssessmentBtnClickable());
		Assert.assertTrue(dashboardPage.isCreateQuestionBtnClickable());
	}
}
