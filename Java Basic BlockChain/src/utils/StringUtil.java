package utils;

import java.security.MessageDigest;

public class StringUtil {
	
	public static String applySHA256String(String input) {
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for(int i=0; i<hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
			
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
