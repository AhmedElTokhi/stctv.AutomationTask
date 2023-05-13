//Reference: https://chercher.tech/java/log4j-java-selenium-webdriver
package Utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerFile {
//    private final List<Exception> es;

	 Logger loggg;
	 public LoggerFile (Class Classname)
	 {
		loggg=Logger.getLogger(Classname);
	 }
	 
	 public void WriteLog (String string1,Exception ex) {
		 Logger.getLogger(loggg.getClass());
		System.setProperty("log_dir", loggg.getClass().getSimpleName());
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure(".\\ReadFrom\\log4j.properties");
        //log the message to file
        loggg.debug(string1,ex);
        
//        loggg.debug(" Sorry, there is an error: "+ string1,ex);
        //loggg.error( "Exceptions happen!",  messageDetails); //this will put all the details in log file configured earlier   
//        System.out.println(string.getStackTrace().length);
//         
//        for (int i=0; i>=string.getStackTrace().length; i++ ){
//        	
//        log.error(string.getStackTrace()[i].getClassName());
//        log.error(string.getStackTrace()[i].getFileName());
//        log.error(string.getStackTrace()[i].getMethodName());
//        log.error(string.getStackTrace()[i].getLineNumber());
//        }
	}
	 
	public void WriteLog (String string1) {
		 Logger.getLogger(loggg.getClass());
		System.setProperty("log_dir", loggg.getClass().getSimpleName());
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure(".\\ReadFrom\\log4j.properties");
        //log the message to file
        loggg.info(string1);
        
        //loggg.error( "Exceptions happen!",  messageDetails); //this will put all the details in log file configured earlier   
//        System.out.println(string.getStackTrace().length);
//          
//        for (int i=0; i>=string.getStackTrace().length; i++ ){
//        	
//        log.error(string.getStackTrace()[i].getClassName());
//        log.error(string.getStackTrace()[i].getFileName());
//        log.error(string.getStackTrace()[i].getMethodName());
//        log.error(string.getStackTrace()[i].getLineNumber());
//        }
	}
}