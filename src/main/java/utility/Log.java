package utility;

import org.apache.log4j.Logger;

public class Log {
	
	
	public static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void starttest(String testname) {
		log.info("==============="+testname+ "TEST START===========");
	}
	
	public static void endtest(String testname) {
		log.info("==============="+testname+ "TEST START===========");
	}
	
   public static void info(String message) {log.info(message);}
   public static void warn(String message) {log.warn(message);}
//   public static void info(String message) {log.info(message);}
//   public static void info(String message) {log.info(message);}
//   public static void info(String message) {log.info(message);}

}
