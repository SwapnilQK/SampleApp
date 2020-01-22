package com.test.mobile.gui.page;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
public abstract class LoginAndDashboardBasePage extends AbstractPage{
	
	public LoginAndDashboardBasePage(WebDriver driver) {
		super(driver);
	}
	
	public abstract void loginActivity(String sUser, String sPwd);
	public abstract String successfullogin();
	public abstract String unSuccessfulLogin();
	public abstract void searchLead(String sLeadID) ;
	public abstract String getAllValues();
	public abstract String dashboardDocumentUpload(String sLeadID) throws InterruptedException;
	public abstract String breakJourney(String sLeadID);
	public abstract void quitdriver();
	public abstract String helpAndSupport(String sPass,String sTitle,String sIncidentCategory,String sMobileNo,String sDesc) throws Exception ;
	
}
