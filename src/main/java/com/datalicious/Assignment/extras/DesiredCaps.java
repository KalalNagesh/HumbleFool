package com.datalicious.Assignment.extras;

import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCaps {
public DesiredCapabilities setdesiredcaps(){
		
		DesiredCapabilities caps = new DesiredCapabilities(); 
		caps.setCapability(
	            PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
	            "G:\\com.datalicious.Assignment\\PhantomJs\\bin\\phantomjs.exe");
		
		return caps;
		
	}


}
