package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class LoginPage extends ControlActions{
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement signInElement;
	
	@FindBy(xpath="//input[@placeholder='Enter email']")
	private WebElement emailElement;
	
	@FindBy(xpath="//input[@placeholder='Enter password']")
	private WebElement passwordElement;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[text()='Authentication failed, please check your username and password.']")
	private WebElement authenticationFailedElement;
	
	@FindBy(xpath = "//div[@role='alert']/div[contains(text(),'email')]")
	private WebElement emailEmptyAlertElement;
	
	@FindBy(xpath = "//div[@id='root']/div[@class='Toastify'][1]//div[@role='alert']/div[contains(text(),'password')]")
	private WebElement passwordEmptyAlertElement;
	
	@FindBy(xpath = "(//div[@role='alert']/div)[1]")
	private WebElement genericErrorPopUpElement;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isSignInVisibile() {
		return isElementDisplayed(signInElement, true);
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginBtn();
	}
	
	public void enterUsername(String username) {
		//emailElement.sendKeys(username);
		setText(emailElement, username);
	}
	
	public void enterPassword(String password) {
		//passwordElement.sendKeys(password);
		setText(passwordElement,password);
	}
	
	public void clickOnLoginBtn() {
		//loginBtn.click();
		clickOnElement(loginBtn);
	}
	
	public String getCurrentPageURL() {
		return super.getCurrentPageURL();
	}
	
	public boolean isAuthenticationFailurePopupDisplayed() {
		return isElementDisplayed(authenticationFailedElement, true);
	}
	
	public boolean isEmailEmptyPopupDisplayed(int timeout) {
		try {
			return isElementDisplayed(emailEmptyAlertElement, timeout);			
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isPasswordEmptyPopupDisplayed(int timeout) {
		try {
			return isElementDisplayed(passwordEmptyAlertElement, timeout);			
		}catch(Exception e) {
			return false;
		}
	}
	
	public String getErrorPopupMessage() {
		isElementDisplayed(genericErrorPopUpElement, 5);
		return getElementText(genericErrorPopUpElement);
	}
}
