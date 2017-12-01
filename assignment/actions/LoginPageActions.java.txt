public class LoginPageActions{

	WebDriver driver;	

	public LoginPageActions(WebDriver driver){
		PageFactory.initElements(driver, this.class);
		this.driver = driver;
	}

	@FindBy(name="email")
	WebElement inp_userName;

	@FindBy(name="pwd")
	WebElement inp_password;

	@FindBy(css="[value='Continue']")
	WebElement btn_continue;

	@FindBy(css="[type='Reset']")
	WebElement btn_reset;

	public void verifyUserIsOnLoginPage(){
		Assert.assertEquals(driver.getTitle(), "Login", "Assertion Failed : User is not on Login Page");
		Reporter.log("Assertion Passed : User is on Login Page", true);
	}

	public void verifyPageElementsDisplayedOnScreen(){
		Assert.assertTrue(inp_userName.isDisplayed(), "Assertion Failed : Email text box is not displayed on screen);
		Reporter.log("Assertion Passed : Email text box is displayed on Screen", true);
		Assert.assertTrue(inp_password.isDisplayed(), "Assertion Failed : Password text box is not displayed on screen);
		Reporter.log("Assertion Passed : Password text box is displayed on Screen", true);
		Assert.assertTrue(btn_continue.isDisplayed(), "Assertion Failed : Continue button is not displayed on screen);
		Reporter.log("Assertion Passed : Continue button is displayed on Screen", true);
		Assert.assertTrue(btn_reset.isDisplayed(), "Assertion Failed : Reset button is not displayed on screen);
		Reporter.log("Assertion Passed : Reset button is displayed on Screen", true);
	}

	public SecondaryPasswordPageActions enterUserNameAndPassword(String userName, String password){
		inp_userName.sendKeys(userName);
		Reporter.log("User inputs "+userName+" as username", true);
		inp_password.sendKeys(password);
		Reporter.log("User inputs "+password+" as password", true);
		btn_continue.click();
		Reporter.log("Clicked on Continue button", true);
		return new SecondaryPasswordPageActions(driver);
	}
}
