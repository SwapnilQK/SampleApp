package com.sample.tests;


import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qk.automation.helper.RTA;
import com.test.mobile.gui.page.LoginAndDashboardBasePage;
import com.test.mobile.gui.pagesobjects.LoginAndDashboardPage;

import ch.qos.logback.core.net.SyslogOutputStream;


public class LoginScenario extends AbstractTest {
	  
	static Logger logger = Logger.getLogger(LoginScenario.class);	
	 @Test(description = "FICC_HFC_SC02")
	public void invalidUserLogin(HashMap<String, Object> testinfo) throws Exception {		
		
		RTA rta = new RTA(testinfo);

		LoginAndDashboardBasePage loginPage = initPage(rta.getCarinaDriver(), LoginAndDashboardBasePage.class);
		try {
		logger.info("******************TEST STARTED**************************"+rta.getTestJobId());
	
		loginPage.loginActivity("Test1234","May@2019");
		String signIn = loginPage.unSuccessfulLogin();
		rta.assertEquals("Login_Screen", signIn);
		System.out.println("inside test job : " + rta.getTestJobId());
		logger.info("******************TEST ENDED**************************");
		}finally
		{
			loginPage.quitdriver();
		}
	
		
}
}