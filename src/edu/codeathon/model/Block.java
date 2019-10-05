package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.Date;


public class Block {

  public String hash; // hash of current block
  public String lastHash; // hash of previous block
  public String message; // (author, tweet, timestamp)
  private long blockTimestamp; // timestamp of block upon creation

  public String calculatedHash() {
    return Utils.hash(
        lastHash + Long.toString(blockTimestamp) + message
    );
  }

  public Block(String message, String lastHash){
    this.message = message;
    this.lastHash = lastHash;
    this.blockTimestamp = new Date().getTime();
    this.hash = calculatedHash();
  }


}