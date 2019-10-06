package edu.codeathon.twitterreader;

import edu.codeathon.model.Comment;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Read {

  static Twitter twitter = new TwitterFactory().getInstance();
  static ArrayList<Status> statuses = new ArrayList<>();

  public static List<Comment> getTweets(){

    try {

      statuses.addAll(twitter.getUserTimeline("ChickenChasers3"));
      //System.out.println("total got : " + statuses.size());

    }
    catch (TwitterException e) {
      System.out.println(e.getErrorMessage());
    }

    List<Comment> returnList = new ArrayList<>();
    for (Status status : statuses) {
      returnList.add(new Comment(String.valueOf(status.getCreatedAt()),status.getUser().getName(),status.getText()));
    }
    return returnList;

  }


}
