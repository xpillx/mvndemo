package log4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMvn {
	private static final Logger test1_logger = LoggerFactory.getLogger("test1");

	private static final Logger test2_logger = LoggerFactory.getLogger("test2");

	private static final Logger test3_logger = LoggerFactory.getLogger("test3");
	
	public static void infoTest1(String info) {
		test1_logger.info(info);
	}

	public static void infoTest2(String info) {
		test2_logger.info(info);
	}
	
	public static void infoTest3(String info) {
		test3_logger.info(info);
	}

}
