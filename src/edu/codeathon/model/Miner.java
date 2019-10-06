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

public class Miner implements Runnable {


  private boolean running;
  private BlockChain currentChain;
  private String difficulty = "0000";

  public Miner(BlockChain chain) {
    currentChain = chain;
  }

  @Override
  public void run() {
    running = true;
    Long nonce = new Random().nextLong()*10000000;
    Long blockTimestamp;
    List<List<String>> tweets = Utils.parseComment("resources/comments");
    int i = 0;
    /*Comment comment = new Comment(tweets.get(i).get(1), tweets.get(i).get(2),tweets.get(i).get(0));
    List<Comment> comments = new ArrayList<>();
    int bytelim = 1999800;*/

    while (running) {
      /*while (bytelim - (32 +   comment.toString().length() * 2) >= 0) {
        comments.add(comment);
        bytelim -= (32 +   comment.toString().length() * 2);
        i++;
        comment.setAuthor(tweets.get(i).get(2));
        comment.setTimestamp(tweets.get(i).get(1));
        comment.setContent(tweets.get(i).get(0));
      }*/
      Comment comment = new Comment(tweets.get(i).get(1), tweets.get(i).get(2), tweets.get(i).get(0));
      String message = comment.toString(); //Utils.constructBlockMess(comments);
      String prevHash = currentChain.getMostRecentBlock().toString();
      Long blockNumber = currentChain.getCurrentNumber();
      blockTimestamp = System.currentTimeMillis();
      String nextBlock = Utils.hash(prevHash, blockNumber + 1, blockTimestamp, message, nonce);


      if (nextBlock.startsWith(difficulty)) {

        Block block = new Block(prevHash, blockNumber + 1, message, blockTimestamp, nonce);
        currentChain.add(block);

        System.out.println(block.toString());
        nonce = new Random().nextLong()*100000;
        i++;
      }
      nonce++;
    }
  }
}
