package util;

public class StringUtil {
	/**
	 * 
	 * @param str
	 * @param message
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null || str.trim().equals("")) {
			return true;
		}
		return false;
	}

}
