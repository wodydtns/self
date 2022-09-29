package self.project.study.common.util;

import java.security.MessageDigest;

public class EncryptUtil {

	public static String getSHA256Encrypt(String text, String salt) throws Exception {
		String encryptedStr = "";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(salt.getBytes("UTF-8"));
		byte[] bytes = md.digest(text.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		encryptedStr = sb.toString();
		return encryptedStr;
	}
}
