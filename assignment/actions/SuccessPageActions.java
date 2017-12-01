public class SuccessPageActions{

	WebDriver driver;	

	public SuccessPageActions(WebDriver driver){
		PageFactory.initElements(driver, this.class);
		this.driver = driver;
	}

	@FindBy(id="step3")
	WebElement successMessage;

	public void verifySuccessPageIsDisplayed(){
		Assert.assertTrue(successMessage.isDisplayed(), "Assertion Failed : Success message is not displayed");
		Reporter.log("Success message is not displayed", true);
		Assert.assertEquals(successMessage.getText(), "Success", "Assertion Failed : Success message is not correct");
		Reporter.log("Success message is correct", true);
	}
}