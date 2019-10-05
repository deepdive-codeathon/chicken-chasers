package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.Date;


public class Block {

  public String hash; // hash of current block
  public String prevHash; // hash of previous block
  public String message; // (author, tweet, timestamp)
  public Long blockTimestamp; // timestamp of block upon creation
  public Long nonce;

  public String calculatedHash() {
    return Utils.hash(prevHash,blockTimestamp,message,nonce);
  }

  public Block(String prevHash, String message, Long blockTimestamp, Long nonce){
    this.prevHash = prevHash;
    this.message = message;
    this.blockTimestamp = blockTimestamp;
    this.nonce = nonce;
    this.hash = calculatedHash();
  }



  @Override
  public String toString() {
    return hash;
  }






}