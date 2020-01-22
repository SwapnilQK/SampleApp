/**
 * 
 */
package com.test.mobile.gui.pagesobjects;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.AccessibilityId;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qk.automation.helper.RTA;
import com.test.mobile.gui.page.LoginAndDashboardBasePage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



/**
 * @author UT
 *
 *	This class will store all the locators and methods of Login Page
 */
@DeviceType(pageType=Type.ANDROID_PHONE, parentClass=LoginAndDashboardBasePage.class)
public class LoginAndDashboardPage extends LoginAndDashboardBasePage{
	
	static Logger logger = Logger.getLogger(LoginAndDashboardPage.class);
	private int timeout = 100;
	@FindBy(id = "com.fullerton.digitalhl:id/imgLogo")
	private ExtendedWebElement txtLogo;
	//public  By txtLogo = By.id("com.fullerton.digitalhl:id/imgLogo");
	//public static By txtUserName=By.id("com.fullerton.digitalhl:id/etUserName");
	 @FindBy(xpath = "//android.widget.EditText[@resource-id='com.fullerton.digitalhl:id/etUserName']")
	 private ExtendedWebElement editUserName;
	 @FindBy(id = "com.fullerton.digitalhl:id/etPassword")
	 private ExtendedWebElement editPassword;
	 @FindBy(id = "com.fullerton.digitalhl:id/btnLogin")
	 private ExtendedWebElement btnsignIn;
	 @FindBy(xpath = "//*[@text='Dashboard']")
	 private ExtendedWebElement txtdashboard;
	 @FindBy(id = "com.fullerton.digitalhl:id/fabAddLead")
	 private ExtendedWebElement btncreateLead;
	 /*iMobility Page*/
	 @FindBy(id = "com.fullerton.digitalhl:id/etSearchLead")
	 private ExtendedWebElement editSearchLID;
	 @FindBy(id = "com.fullerton.digitalhl:id/approved_tenure")
	 private ExtendedWebElement txtApproveTennure;
	 
	 @FindBy(id = "com.fullerton.digitalhl:id/approved_loan")
	 private ExtendedWebElement txtApploanAmt;
	 
	 @FindBy(id = "com.fullerton.digitalhl:id/tvNewLeadId")
	 private ExtendedWebElement txtLeadID;
	 
	 @FindBy(id = "com.fullerton.digitalhl:id/tvNewLeadCustomerName")
	 private ExtendedWebElement txtNameLead;
	 
	 @FindBy(xpath = "//*[@text='FCU Status']")
	 private ExtendedWebElement txtFCUDetail;
	 
	 @FindBy(xpath = "//*[@text='Final FCU Status']//following::android.widget.TextView[1]")
	 private ExtendedWebElement txtFinalFCUStatus;
	 
	 @FindBy(xpath = "//*[@text='Final Hunter Status']//following::android.widget.TextView[1]")
	 private ExtendedWebElement txtFinalHunterStatus;
	 @FindBy(xpath = "//*[@text='ID PROOF']")
	 private ExtendedWebElement idProof;
	 @FindBy(xpath = "//*[@text='ADDRESS PROOF']")
	 private ExtendedWebElement txtAddProof;
	 /*Document Upload */
	 
	 @FindBy(xpath = "//*[@text='Document Upload']")
	 private ExtendedWebElement txtdocUpload;
	 @FindBy(id = "com.fullerton.digitalhl:id/tvNewLeadCustomerName")
	 private ExtendedWebElement txtCustomeraName;
	 @FindBy(id = "com.fullerton.digitalhl:id/tvNewLeadId")
	 private ExtendedWebElement txtLeadId;
	 @FindBy(id = "com.fullerton.digitalhl:id/spnSelectDocumentType")
	 private ExtendedWebElement selectDocType;
	 @FindBy(id = "com.fullerton.digitalhl:id/btnTakePhoto")
	 private ExtendedWebElement btnTakePhoto;
	 @FindBy(id = "com.fullerton.digitalhl:id/textCount")
	 private ExtendedWebElement txtPhotoCount;
	 @FindBy(id = "com.fullerton.digitalhl:id/btnUpload")
	 private ExtendedWebElement btnUpload;
	 @FindBy(id = "com.fullerton.digitalhl:id/tvThankYouLabel")
	 private ExtendedWebElement txtSuccess;
	 @FindBy(id = "com.fullerton.digitalhl:id/btnBackToHome")
	 private ExtendedWebElement btnBackToDash;
	 @FindBy(id = "com.fullerton.digitalhl:id/btnSnap")
	 private ExtendedWebElement camerasnap;
	 @FindBy(id = "com.fullerton.digitalhl:id/buttonSave")
	 private ExtendedWebElement savebutton;
	 
	 /*Burger menu*/
	 @FindBy(xpath = "//*[@class='android.widget.ImageButton']")
	 private ExtendedWebElement burgerMenu;
	 @FindBy(xpath = "//*[@text='Home']")
	 private ExtendedWebElement home;
	 @FindBy(id = "android:id/button1")
	 private ExtendedWebElement yesbtn;
	 @FindBy(xpath = "//*[@text='My Leads']")
	 private ExtendedWebElement txtmyLead;
	 public LoginAndDashboardPage(WebDriver driver) 
		{
			super(driver);
		}
	
	 AndroidDriver<MobileElement> andDriver = (AndroidDriver<MobileElement>) getDriver();
	 
	public void loginActivity(String sUser, String sPwd) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.fullerton.digitalhl:id/etUserName")));
//		editUserName.isPresent(timeout);
		editUserName.type(sUser);
		editPassword.type(sPwd);
		btnsignIn.click();
		
		if (driver instanceof EventFiringWebDriver) {

            ((EventFiringWebDriver) driver).getWrappedDriver();

          }

            Screenshot.capture(driver, "<screenshot description>");
	}
	
	public String successfullogin() 
	{
		txtdashboard.isPresent(timeout);
		String vActualRes=txtdashboard.getText();
		txtdashboard.isElementWithTextPresent(vActualRes);
		return vActualRes;				
	}
	
	public String unSuccessfulLogin() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnsignIn.isPresent(timeout);
			 String vActualRes=btnsignIn.getText();
			 System.out.println(vActualRes);
			 btnsignIn.isElementWithTextPresent(vActualRes);
			 return vActualRes;		
	}
	public void searchLead(String sLeadID) 
	{
		editSearchLID.click();
		
		editSearchLID.type(sLeadID);
		
		((JavascriptExecutor) driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
		
		txtLeadID.isPresent(timeout);
		
	}
	
	//////help and support functionality//////////
	
	public String helpAndSupport(String sPass,String sTitle,String sIncidentCategory,String sMobileNo,String sDesc) throws Exception
	{
		
	
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/action_more\"))")).click();
		
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().text(\"Help and Support\"))")).click();
		 new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.id("com.fullerton.digitalhl:id/raiseticket")));
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/raiseticket\"))")).isDisplayed();
		 
	
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/raiseticket\"))")).click();
		 
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/etPassword\"))")).isDisplayed();
		 
		 
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/etPassword\"))")).sendKeys(sPass);
		 
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/btn_validate\"))")).click();
		 
		 new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.id("com.fullerton.digitalhl:id/etcategorytitle")));
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/etcategorytitle\"))")).isDisplayed();
		 
		try {
			andDriver.hideKeyboard();
		}
		catch(Exception e){
			System.out.println("Exception for keyboard"+e);
		}
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/etcategorytitle\"))")).sendKeys(sTitle); 
		 
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/spnSelectIncidentCategory\"))")).click();
		 
		 
	    clickByText(sIncidentCategory);
		 
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/etMobileNumber\"))")).sendKeys(sMobileNo); 
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/description\"))")).sendKeys(sDesc); 
		 
		 
		 driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.fullerton.digitalhl:id/scrollView\")).scrollIntoView("
					+ "new UiSelector().resourceId(\"com.fullerton.digitalhl:id/btnConfirmticket\"))")).click();
		 
		 
		 
		 WebElement toastView =new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[contains(@text,'ticket created successfully')]")));
		
		 String toastMsg = toastView.getAttribute("name");
		 
		return toastMsg;
	}
	
	public String getAllValues() 
	{
		txtLeadID.isPresent(timeout);
		String sLeadId=txtLeadID.getText();
		logger.info("Lead Id is-:"+sLeadId);
		String sNameLead=txtNameLead.getText();
		logger.info("Name Lead"+sNameLead);
		String sApproveTenure=txtApproveTennure.getText();
		logger.info("Approve tenure is-:"+sApproveTenure);
		String sLoanAmt=txtApploanAmt.getText();
		logger.info("Approve Loan Amount is-:"+sLoanAmt);
		String sFCUDetails=txtFCUDetail.getText();
		logger.info("FCU Detail-:"+sFCUDetails);
		String sFCUStatus=txtFinalFCUStatus.getText();
		logger.info("FCU Status is-:"+sFCUStatus);
		String sFinalHunterStatus=txtFinalHunterStatus.getText();
		logger.info("Final Hunter Status is-:"+sFinalHunterStatus);;
		return sLeadId;
	}
	//doc upload
	public String dashboardDocumentUpload(String sLeadID) throws InterruptedException 
	{
		txtdocUpload.click();
		editSearchLID.click();
		editSearchLID.type(sLeadID);
		((JavascriptExecutor) driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
		String sCusName=txtCustomeraName.getText();
		logger.info("Customer Nmae is-:"+sCusName);
		selectDocType.click();
		idProof.click();
		btnTakePhoto.click();
		camerasnap.click();
		Thread.sleep(6000);
		savebutton.click();
		selectDocType.click();
		txtAddProof.click();
		btnTakePhoto.click();
		camerasnap.click();
		Thread.sleep(6000);
		savebutton.click();
		btnUpload.click();
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.id("com.fullerton.digitalhl:id/tvThankYouLabel")));
//		waitforElement(By.id("com.fullerton.digitalhl:id/tvThankYouLabel"), timeout)
		String sSucess =txtSuccess.getText();
		btnBackToDash.click();
		return sSucess;
	}
	
	// break journey
	
	public String breakJourney(String sLeadID) 
	{
		burgerMenu.click();
		home.click();
		yesbtn.click();
		txtmyLead.click();
//		String[] lead= sLeadID.split("#");
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text,'"+sLeadID+"')]")));
		driver.findElement(By.xpath("//*[contains(@text,'"+sLeadID+"')]")).click();
		yesbtn.click();
		return sLeadID;
	}
	
	
	 public void clickByText(String sText) throws Exception
	 {  try 
	 {
		 Thread.sleep(1000);
	    	
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
	                + ".scrollable(true)).scrollIntoView("
	                + "new UiSelector().textContains(\""+sText+"\"));")).click();	 
		 logger.info("Click on Element Successfully with text "+sText);
		 Thread.sleep(1000);
	 }
	 catch (Exception sere) {

	       logger.error("Element not found with text "+sText);
	       throw new Exception("Element not found with text "+sText);
	    }
	 }
	
	
	public void quitdriver()
	{
		driver.quit();
		
	}
	public boolean waitforElement(By by , int itimesec) {
        boolean sflag = false;
         try {
                       for (int i = 1; i <= itimesec; i++) {                                      
                                      List<WebElement> oListObject = driver.findElements(by);
                                      if (oListObject.size() == 1 && oListObject.get(0).isDisplayed()) {
                                         sflag = true;
                                         break;
                                    } 
                                      else {
                                           Thread.sleep(1000);}
                         }
                          
           } catch (Exception e) {
                     
              }
              return sflag;

    }
	
	public   WebDriver getDriver() {
		WebDriver drv = driver;
		if (drv instanceof EventFiringWebDriver) {
			return ((EventFiringWebDriver) drv).getWrappedDriver();
		} else {
			return drv;
		}
	}
}
