package edu.codeathon.model;

import java.lang.String;

public class Comment {

  String author;
  String timestamp;
  String content;

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


