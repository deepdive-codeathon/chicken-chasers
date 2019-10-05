package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.Date;

public class Block {

  private String hash;
  private String lastHash;
  private String message;
  private long blockTimestamp;

  public Block(String message, String lastHash){
    this.message = message;
    this.lastHash = lastHash;
    this.blockTimestamp = new Date().getTime();
  }


}
