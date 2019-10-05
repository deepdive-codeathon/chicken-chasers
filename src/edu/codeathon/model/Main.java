package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.ArrayList;
import java.util.List;

public class Main {


  public static void main(String[] args) {

    List<Comment> comments = new ArrayList<>();

    for (List<String> comment : Utils.parseComment("resources/comments")) {
      comments.add(new Comment(comment.get(1),comment.get(2),comment.get(0)));
    }

    for (Comment comment : comments) {
      System.out.println(comment);
    }

  }

}
