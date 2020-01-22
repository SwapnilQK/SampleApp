package utils;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.Timer;

import static com.qaprosoft.carina.core.foundation.utils.mobile.MobileUtils.getDriver;

public class MobileContextUtils {

    private static final Logger LOGGER = Logger.getLogger(DriverHelper.class);

    private WebDriver getDriverSafe() {
        WebDriver driver = getDriver();
        if (driver instanceof EventFiringWebDriver) {
            driver = ((EventFiringWebDriver) driver).getWrappedDriver();
        }
        return driver;
    }

    public void switchMobileContext(View context) {
        AppiumDriver<?> driver = (AppiumDriver<?>) getDriverSafe();
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles = help.performIgnoreException(driver::getContextHandles);
        String desiredContext = "";
        boolean isContextPresent = false;
        LOGGER.info("Existing contexts: ");
        for (String cont : contextHandles) {
            if (cont.contains(context.getView())) {
                desiredContext = cont;
                isContextPresent = true;
            }
            LOGGER.info(conttest);
        }
        if (!isContextPresent) {
            throw new NotFoundException("Desired context is not present");
        }
        LOGGER.info("Switching to context : " + context.getView());
        driver.context(desiredContext);
    }

    public enum View {
        NATIVE("NATIVE_APP"),
        WEB("WEBVIEW_unknown");

        String viewName;

        View(String viewName) {
            this.viewName = viewName;
        }

        public String getView() {
            return this.viewName;
        }
    }
    
    
    

	 public void textFileGenerationChecker(String data, String fileName)
	    {
	        try
	        {
	            // Get the output file absolute path.
	            String filePath = fileName;
	            
	            Timer timer;
	            boolean txtFile = false;
	            
	            do
	            {
	            // Create File, FileWriter and BufferedWriter object.
	            File file = new File(filePath);

	            FileWriter fw = new FileWriter(file);

	            BufferedWriter buffWriter = new BufferedWriter(fw);

	            // Write string data to the output file, flush and close the buffered writer object.
	            buffWriter.write(data);

	            buffWriter.flush();

	            buffWriter.close();

	            System.out.println(filePath + " has been created.");
	            txtFile = true;
	            
	            }while(txtFile = false);

	        }catch(IOException ex)
	        {
	            System.err.println(ex.getMessage());
	        }
	    }

}