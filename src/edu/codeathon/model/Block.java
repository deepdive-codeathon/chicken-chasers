package edu.codeathon.model;

import java.util.Date;

public class Block {

  public String hash;
  public String lastHash;
  public String message;
  private long blockTimestamp;

  public Block(String message, String lastHash){
    this.message = message;
    this.lastHash = lastHash;
    this.blockTimestamp = new Date().getTime();
  }


}
