package test.aspect;

import test.aspect.lib.Tools;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Tools tools = new Tools();
        
        try {
	        tools.callFirstTool("hello", "world");
	        tools.callSecondTool("hello", "");
	        tools.callSecondTool("hello", "world");
        } catch(Exception ex) {
        	
        }
    }
}
