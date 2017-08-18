package log4;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	private final static Logger logger = LoggerFactory.getLogger(Log.class);

	public static void Init(String path) {
		PropertyConfigurator.configure(path + "/mvndemo/conf/log4j.properties");
		Log.info(System.getProperty("wtp.deploy"));
	}

	public static void main(String[] args) {
		Log.info(System.getProperty("wtp.deploy"));
	}

	public static void error(Logger logger, String str, Throwable throwable) {
		logger.error(str, throwable);
	}

	public static void error(String str, Throwable throwable) {
		logger.error(str, throwable);
	}

	public static void error(Logger logger, String info) {
		logger.error(info);
	}

	public static void error(String str) {
		logger.error(str);
	}

	public static void info(Logger logger, String info) {
		logger.info(info);
	}

	public static void info(String info) {
		logger.info(info);
	}

	public static void debug(String str) {
		logger.debug(str);
	}

	public static void debug(Logger logger, String info) {
		logger.debug(info);
	}
}
