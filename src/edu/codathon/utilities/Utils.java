package edu.codathon.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

  public static List<List<String>> parseComment(String fileName) {
    List<List<String>> parsed = new ArrayList<>();
    BufferedReader reader;
    final String USER = "@therealDonaldTrump";
    final int TEXT = 1; // Known value for the tweet
    final int TIME = 2; // Known value for time stamp

    try {
      reader = new BufferedReader(new FileReader(fileName));
      String line = reader.readLine();
      while(line != null) {
        List<String> temp = new ArrayList<>();
        String[] split = line.split(",");
        temp.add(split[TEXT]);
        temp.add(split[TIME]);
        temp.add(USER);
        parsed.add(temp);
        line = reader.readLine();
      }
      reader.close();
    }catch (IOException e) {
      //Ignored
    }
    return parsed;
  }



  private static MessageDigest digest;

  static {
    try {
      digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException ignored) {
    }
  }

  public Utils() throws NoSuchAlgorithmException {
  }

  public static String hash(String... tohash) {

    digest.reset();

    for (String string : tohash) {
      digest.update(string.getBytes(StandardCharsets.UTF_8));
    }

    byte[] byteString = digest.digest();

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
