WebDriver driver;
LoginPageActions loginPage;
SecondaryPasswordPageActions secondaryPasswordPage;
SuccessPageActions successPage;

@BeforeTest
public void setUp(){
	System.setProperty("webdriver.chrome.driver", "C:/Users/pstraining.PSNET/Desktop/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("file:///C:/Users/pstraining.PSNET/Desktop/New%20folder/login_page.html");
}


@Test
public void Step01_VerifyUserIsOnLoginScreen(){
	loginPage = new LoginPageActions(driver);
	loginPage.verifyUserIsOnLoginPage();
	loginPage.verifyPageElementsDisplayedOnScreen();
}

@Test(dependsOnMethods="Step01_VerifyUserIsOnLoginScreen")
public void Step02_LoginToTheApplication(){
	secondaryPasswordPage = loginPage.enterUserNameAndPassword("user@example.com", "eW5PEXgz");
}

@Test(dependsOnMethods="Step02_LoginToTheApplication")
public void Step03_VerifyInputFieldsDisabledOnSecondaryPasswordScreen(){
	secondaryPasswordPage.verify6InputFieldsAreDisabled();
}

@Test(dependsOnMethods="Step03_VerifyInputFieldsDisabledOnSecondaryPasswordScreen")
public void Step04_VerifyInputFieldsEnabledOnSecondaryPasswordScreen(){
	secondaryPasswordPage.verify4InputFieldsAreEnabled();
}

@Test(dependsOnMethods="Step04_VerifyInputFieldsEnabledOnSecondaryPasswordScreen")
public void Step05_UserEntersSecondaryPassword(){
	successPage = secondaryPasswordPage.enterSecondaryPassword("JcdmAB677B");
}

@Test(dependsOnMethods="Step05_UserEntersSecondaryPassword")
public void Step06_VerifySuccessPageIsDisplayed(){
	successPage.verifySuccessPageIsDisplayed();
}

@AfterTest
public void tearDown(){
	driver.quit();
}
