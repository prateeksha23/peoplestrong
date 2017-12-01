public class SecondaryPasswordPageActions {

	WebDriver driver;	

	public SecondaryPasswordPageActions (WebDriver driver){
		PageFactory.initElements(driver, this.class);
		this.driver = driver;
	}

	@FindBy(xpath="//input[contains(@name,'sp')]")
	List<WebElement> inp_secondaryPassword;

	@FindBy(css="[value='Continue']")
	WebElement btn_continue;

	@FindBy(css="[type='Reset']")
	WebElement btn_reset;

	public void verify6InputFieldsAreDisabled(){
		int count = 0;
		for(WebElement secPassElement : inp_secondaryPassword){
			if(!secPassElement.isEnabled()){
				count++;
			}
		}
		Assert.assertEquals(count, 6, "Assertion Failed : Count of disabled field is not correct");
		Reporter.log("Assertion Passed : Count of disabled field is correct", true);
	}

	public void verify4InputFieldsAreEnabled(){
		int count = 0;
		for(WebElement secPassElement : inp_secondaryPassword){
			if(secPassElement.isEnabled()){
				count++;
			}
		}
		Assert.assertEquals(count, 4, "Assertion Failed : Count of enabled field is not correct");
		Reporter.log("Assertion Passed : Count of enabled field is correct", true);
	}	

	public SuccessPageActions enterSecondaryPassword(String secPassword){
		for(int i=0; i<inp_secondaryPassword.size(),i++){
			if(secPassElement.get(i).isEnabled()){
				secPassElement.get(i).sendKeys(secPassword.charAt(i)+"");
			}
		}
		btn_continue.click();
		Reporter.log("Clicked on continue button", true);
		return new SuccessPageActions(driver);
	}

}