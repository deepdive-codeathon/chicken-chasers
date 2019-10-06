package edu.codeathon.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

public class Pool {

  private Queue<Comment> commentPool = new LinkedList<>();;
  private SynchronousQueue<Comment> commentQueue = new SynchronousQueue<>();


  public void setCommentPool(List<Comment> commentsFromTwitter){
    commentPool.addAll(commentsFromTwitter);
  }



  public synchronized List<Comment> getFromPool(int number){

    while (commentQueue.size() < number){
      commentQueue.add(commentPool.remove());
    }
    List<Comment> returnComments = new ArrayList<>(commentQueue);
    commentQueue.clear();
    return returnComments;
  }





}
