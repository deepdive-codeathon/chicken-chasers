package edu.codeathon.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utils {

  private static MessageDigest digest;

  static {
    try {
      digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException ignored) {
    }
  }


  public static List<List<String>> parseComment(String fileName) {
    List<List<String>> parsed = new ArrayList<>();
    BufferedReader reader;
    final String USER = "@therealDonaldTrump";
    final int TEXT = 1; // Known value for tweet
    final int TIME = 2; // Known value for time stamp

    String line;
    try {
      reader = new BufferedReader(new FileReader(fileName));
      reader.readLine();
      while((line=reader.readLine()) != null) {
        List<String> temp = new ArrayList<>();
        String[] split = line.split(",");
        System.out.println(Arrays.toString(split));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        Date date = dateFormat.parse(split[TIME]);
        Long unixTime = (long) date.getTime()/1000;
        temp.add(split[TEXT]);
        temp.add(unixTime.toString());
        temp.add(USER);
        parsed.add(temp);
      }
      reader.close();
    }catch (IOException | ParseException e) {
      return null;
    }
    return parsed;
  }


  public Utils() throws NoSuchAlgorithmException {
  }

  public static String hash(Object... tohash) {

    // reset the hash digest between multiple hashes
    digest.reset();
    // add the tostrings of the input object to the digest
    for (Object obj : tohash) {
      digest.update(obj.toString().getBytes(StandardCharsets.UTF_8));
    }
    // get the sha256 hash value of the input and store as byte array
    byte[] byteString = digest.digest();


    // output to convert the byte values into hex equivalents
    StringBuilder hexString = new StringBuilder();
    // loop over the values in the byte array
    for (int i = 0; i < byteString.length; i++) {
      // AND the byte value to produce the hex equiv
      String hex = Integer.toHexString(0xff & byteString[i]);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      // add the hexvalue to the returned string
      hexString.append(hex);
    }
    // return the hexvalue as a string
    return hexString.toString();
  }

}
