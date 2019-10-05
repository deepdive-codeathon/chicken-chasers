package edu.codathon.utilities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

  private static MessageDigest digest;

  static {
    try {
      digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException ignored) {
    }
  }

  public Utils() throws NoSuchAlgorithmException {
  }

  public static String hash(String string) {

    byte[] byteString = digest.digest(string.getBytes(StandardCharsets.UTF_8));

    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < byteString.length; i++) {
      String hex = Integer.toHexString(0xff & byteString[i]);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }

}
