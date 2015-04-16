package io.github.aggumati.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean hasUpperCase(String str) {
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	public static int indexOfUpper(String str) {
		int idxUpper = 0;
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return idxUpper;
			}
			idxUpper++;
		}
		return -1;
	}

	public static String fieldToCol(String str) {
		String result = "";
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				result += ("_" + Character.toLowerCase(c));
			} else {
				result += c;
			}
		}

		return result;
	}

	/**
	 * example : [1, 2]
	 * 
	 * @return
	 */
	public static List<String> stringToListString(String str) {
		str = str.replace("[", "");
		str = str.replace("]", "");
		return Arrays.asList(str.split("\\s*,\\s*"));
	}

	public static List<Integer> stringToListInt(String str) {
		List<String> listStr = stringToListString(str);
		List<Integer> listInt = new ArrayList<Integer>();

		for (String strObj : listStr) {
			listInt.add(new Integer(strObj));
		}

		return listInt;
	}

	public static List<Long> stringToListLong(String str) {
		List<String> listStr = stringToListString(str);
		List<Long> listLong = new ArrayList<Long>();

		for (String strObj : listStr) {
			listLong.add(new Long(strObj));
		}

		return listLong;
	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean isEmail(final String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString = camelCaseString + toProperCase(part);
		}
		return removeSpace(camelCaseString);
	}

	public static String toProperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	public static String capitalizeFirst(String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
	
	public static String lowerFirst(String line) {
		return Character.toLowerCase(line.charAt(0)) + line.substring(1);
	}
	
	public static String removeSpace(String line) {
		return line.replace(" ", "");
	}
	
	public static String getSha1 (String str) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(str.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}
	
	public static Boolean isBoolean (String str) {
		return "true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str) ;
	}
	
	public static Boolean isJavaClass (String str) {
		return ".class".equals(getFileExtension(str));
	}
	
	public static String getFileExtension(String file) {
	    int lastIndexOf = file.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return file.substring(lastIndexOf);
	}
	
	public static String splitCamelCase(String s) {
	   return removeSpace(s.replaceAll(
	      String.format("%s|%s|%s",
	         "(?<=[A-Z])(?=[A-Z][a-z])",
	         "(?<=[^A-Z])(?=[A-Z])",
	         "(?<=[A-Za-z])(?=[^A-Za-z])"
	      ),
	      " "
	   ));
	}
	
	public static String splitCamelCaseWithSpace(String s) {
	   return s.replaceAll(
	      String.format("%s|%s|%s",
	         "(?<=[A-Z])(?=[A-Z][a-z])",
	         "(?<=[^A-Z])(?=[A-Z])",
	         "(?<=[A-Za-z])(?=[^A-Za-z])"
	      ),
	      " "
	   );
	}
}
