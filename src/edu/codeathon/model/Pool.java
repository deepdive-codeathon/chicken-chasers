package edu.codeathon.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.beans.property.StringProperty;

public class Pool {

  private LinkedList<Comment> commentPool = new LinkedList<>();
  private Queue<Comment> commentQueue = new LinkedList<>();


  public void setCommentPool(List<Comment> commentsFromTwitter){
    commentPool.addAll(commentsFromTwitter);
  }



  public synchronized String getFromPool(int number){
    StringBuilder sb = new StringBuilder("\n\t\t");
    while (commentQueue.size() < number){
      commentQueue.add(commentPool.removeLast());
    }
    List<Comment> returnComments = new ArrayList<>(commentQueue);
    commentQueue.clear();
    for (Comment comment : returnComments) {
      sb.append(comment).append("\n");
    }
    return sb.toString();
  }


  public void addInput(StringProperty message) {
    message.addListener((observable, oldValue, newValue) -> {
      commentQueue.add(new Comment(String.valueOf(System.currentTimeMillis()),
                                  "CURRENTUSER",
                                  newValue));
    });
  }
}
