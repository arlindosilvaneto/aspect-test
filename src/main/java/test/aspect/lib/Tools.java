package test.aspect.lib;

import java.util.logging.Logger;

import test.aspect.annotations.Validate;

public class Tools {
	final Logger logger = Logger.getAnonymousLogger();
	
	public void callFirstTool(String first, String last) {
		logger.info("FIRST TOOL: " + first + " - " + last);
	}
	
	@Validate
	public void callSecondTool(String first, String last) {
		logger.info("SECOND TOOL: " + first + " - " + last);
	}
}
