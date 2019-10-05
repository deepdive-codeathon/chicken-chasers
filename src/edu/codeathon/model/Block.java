package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.Date;


public class Block {

  String hash; // hash of current block
  String prevHash; // hash of previous block
  String message; // (author, tweet, timestamp)
  private long blockTimestamp; // timestamp of block upon creation

  public String calculatedHash() {
    return Utils.hash( prevHash + blockTimestamp + message);
  }

  public Block(String prevHash, String message){
    this.message = message;
    this.prevHash = prevHash;
    this.blockTimestamp = new Date().getTime();
    this.hash = calculatedHash();
  }

  @Override
  public String toString() {
    return hash;
  }




}