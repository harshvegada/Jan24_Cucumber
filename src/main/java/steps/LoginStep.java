package steps;

import org.junit.Assert;

import constant.ConstantPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPageMethod;
import pages.DashboardPage;
import pages.LoginPage;
import utility.PropOperation;

public class LoginStep {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CommonPageMethod commonPageMethod;

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		commonPageMethod = new CommonPageMethod();
	}

	@When("User enter username as {string}")
	public void user_enter_username_as(String username) {
		System.out.println("STEP - Enter valid username");
		loginPage.enterUsername(username);
	}

	@When("User enter password as {string}")
	public void user_enter_password_as(String password) {
		System.out.println("STEP - Enter valid password");
		loginPage.enterPassword(password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		System.out.println("STEP - Click on login button");
		loginPage.clickOnLoginBtn();
	}

	@Then("User is on dashboard Page")
	public void user_is_on_dashboard_page() {
		boolean isDashBoardVisible = dashboardPage.isDashboardMenuVisible();
		Assert.assertEquals("Dashboard Page is not visible", isDashBoardVisible, true);

		System.out.println("VERIFY - Dashboard page is displayed");
		String currentURL = commonPageMethod.getCurrentPageURL();
		Assert.assertEquals("Dashboard Page is not visible", currentURL.contains("dashboard"), true);
	}

	@Then("User verify authentication failure popup is displayed")
	public void user_verify_authentication_failure_popup_is_displayed() {
		System.out.println("VERIFY - Authentication failure popup is displayed");
		boolean isAuthPopUpDisplayed = loginPage.isAuthenticationFailurePopupDisplayed();
		Assert.assertEquals("Authentication failure popup was not dispalyed", isAuthPopUpDisplayed, true);
	}

	@Then("User verify user is on Login Page")
	public void user_verify_user_is_on_login_page() {
		System.out.println("VERIFY - Login page is still visible");
		String currentURL = loginPage.getCurrentPageURL();
		Assert.assertTrue(currentURL.endsWith("login"));
	}

	@When("User login using valid credentials")
	public void user_login_using_valid_credentials() {
		PropOperation propOperation = new PropOperation(ConstantPath.CONFIG_FILEPATH);
		String username = propOperation.getValue("username");
		String password = propOperation.getValue("password");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginBtn();
	}
	
	@Then("User verify login is {string}")
	public void verifyLogin(String status) {
		if(status.equalsIgnoreCase("successful")) {
			user_is_on_dashboard_page();
		}else {
			user_verify_user_is_on_login_page();
		}
	}
	
	@Then("User verify username empty message {string} displayed")
	public void verifyUserNameEmptyMessage(String status) {
		boolean usernameEmptyFlag = false;
		if(status.equalsIgnoreCase("is not")) {
			usernameEmptyFlag = loginPage.isEmailEmptyPopupDisplayed(ConstantPath.QUICKWAIT);
			Assert.assertFalse(usernameEmptyFlag);
		}else {
			usernameEmptyFlag = loginPage.isEmailEmptyPopupDisplayed(ConstantPath.FASTWAIT);
			Assert.assertTrue(usernameEmptyFlag);
		}
	}
	
	@Then("User verify password empty message {string} displayed")
	public void verifyPasswordEmptyMessage(String status) {
		boolean passwordEmptyFlag = false;
		if(status.equalsIgnoreCase("is not")) {
			passwordEmptyFlag = loginPage.isPasswordEmptyPopupDisplayed(ConstantPath.QUICKWAIT);
			Assert.assertFalse(passwordEmptyFlag);
		}else {
			passwordEmptyFlag = loginPage.isPasswordEmptyPopupDisplayed(ConstantPath.FASTWAIT);
			Assert.assertTrue(passwordEmptyFlag);
		}
	}
	
	@Then("User verify message {string} is displayed")
	public void verifyMessageIsDisplayed(String expectedMessage) {
		System.out.println(expectedMessage);
		if(!expectedMessage.isEmpty()) {
			String actualMessage = loginPage.getErrorPopupMessage();
			System.out.println(actualMessage);
			Assert.assertEquals("Expected Message : " + expectedMessage + " is different then actual message : " + actualMessage,expectedMessage, actualMessage);
		}
	}
}
