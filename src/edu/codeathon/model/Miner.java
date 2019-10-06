package edu.codeathon.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.codeathon.utilities.Utils;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Platform;
import javax.rmi.CORBA.Util;

public class Miner implements Runnable {


  private boolean running;
  private BlockChain currentChain;

  public Miner(BlockChain chain) {
    currentChain = chain;
  }

  @Override
  public void run() {
    running = true;
    Long nonce = new Random().nextLong() * 10000000;
    Long blockTimestamp;
    List<List<String>> tweets = Utils.parseComment("resources/comments");
//    Comment comment = new Comment(tweets.get(i).get(1), tweets.get(i).get(2),tweets.get(i).get(0));
//    List<Comment> comments = new ArrayList<>();
//    int bytelim = 1999800;

    int i = 0;
    while (running) {
      /*while (bytelim - (32 +   comment.toString().length() * 2) >= 0) {
        comments.add(comment);
        bytelim -= (32 +   comment.toString().length() * 2);
        i++;
        comment.setAuthor(tweets.get(i).get(2));
        comment.setTimestamp(tweets.get(i).get(1));
        comment.setContent(tweets.get(i).get(0));
      }*/
      //Utils.constructBlockMess(comments);
      Comment comment = new Comment(tweets.get(i).get(1), tweets.get(i).get(2), tweets.get(i).get(0));
      String message = comment.toString();
      String prevHash = currentChain.getMostRecentBlock().hash;
      Long blockNumber = currentChain.getCurrentNumber();
      blockTimestamp = System.currentTimeMillis();

      String nextBlock = Utils.hash(prevHash,
          blockNumber + 1,
          blockTimestamp,
          message,
          nonce);


      if (nextBlock.startsWith(Network.getDifficulty(currentChain))) {

        Block block = new Block(prevHash, blockNumber + 1, blockTimestamp, message, nonce);
        currentChain.add(block);

        nonce = new Random().nextLong()*100000;

//        Utils.saveBlock(block,"blocks");
        i++;
      }
      nonce++;
    }
  }

  public void stop() {
    running = false;
  }
}
