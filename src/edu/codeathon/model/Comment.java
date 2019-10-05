package edu.codeathon.model;

import java.lang.String;

public class Comment {

  private String author;
  private String timestamp;
  private String content;

  public Comment(String timestamp, String author, String content) {
    this.author = author;
    this.timestamp = timestamp;
    this.content = content;
  }


  @Override
  public String toString() {
    return timestamp + ":" + author + ":" + content;
  }

}


