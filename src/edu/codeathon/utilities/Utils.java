package edu.codeathon.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.codeathon.model.Block;
import edu.codeathon.model.Comment;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

  private static MessageDigest digest;
  public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

  static {
    try {
      digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException ignored) {
    }
  }

  public synchronized static String hash(Object... toHash) {

    // reset the hash digest between multiple hashes
    digest.reset();
    // add the tostrings of the input object to the digest
    for (Object obj : toHash) {
      digest.update(obj.toString().getBytes(StandardCharsets.UTF_8));
    }
    // get the sha256 hash value of the input and store as byte array
    byte[] byteString = digest.digest();

    return byteToString(byteString);
  }

  public static List<String> parseComment(String fileName) {
    List<Comment> parsed = new ArrayList<>();
    BufferedReader reader;
    //The only data we are pulling from includes tweets from donald trump so user is assumed to be @therealDonaldTrump
    final String USER = "@therealDonaldTrump";
    final int TEXT = 1; // Known value for tweet
    final int TIME = 2; // Known value for time stamp

    String line;
    try {
      reader = new BufferedReader(new FileReader(fileName));
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        List<String> temp = new ArrayList<>();
        String[] split = line.split(",");
        try {
          if (convertToUnix(split[TIME]) != null) {
            Comment comment = new Comment(convertToUnix(split[TIME]).toString(), USER, split[TEXT].toString());
            parsed.add(comment);
          }
        } catch (ArrayIndexOutOfBoundsException aiob) {
          //Ignored because some of the data we are pulling from is incomplete
        }
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("File not found!");
    }
    return parsed;
  }

  private static Long convertToUnix(String text) {
    Long unixTime;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
      Date dt = sdf.parse(text);
      long epoch = dt.getTime();
      unixTime = (epoch / 1000);
    } catch (ParseException e) {
      return null;
    }
    return unixTime;
  }

  private static String byteToString(byte[] byteString) {

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

  public static void saveBlock(Block block,String path) {
    try (PrintWriter writer = new PrintWriter(path+"/block" + block.blockNumber + ".dat",
        "UTF-8")) {
      writer.print(gson.toJson(block));
    } catch (FileNotFoundException | UnsupportedEncodingException ignored) {
    }
  }

  public void currentBlock(Block block) {
    try (PrintWriter writer = new PrintWriter("blocks/block" + block.blockNumber + ".dat",
        "UTF-8")) {
      writer.print(gson.toJson(block));
    } catch (FileNotFoundException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  public static String constructBlockMess(List<Comment> comments) {
    StringBuilder sb = new StringBuilder();
    for (Comment comment : comments) {
      sb.append(comment);
    }
    return sb.toString();
  }
}
