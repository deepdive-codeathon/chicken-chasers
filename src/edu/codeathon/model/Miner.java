package edu.codeathon.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.webkit.network.Util;
import edu.codeathon.utilities.Utils;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

public class Miner implements Runnable {


  private boolean running;
  private BlockChain currentChain;
  private String diff;

  public Miner(BlockChain chain) {
    currentChain = chain;
  }

  @Override
  public void run() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    running = true;
    Long nonce = new Random().nextLong()*10000000;
    Long blockTimestamp;

    List<List<String>> tweets = Utils.parseComment("resources/comments");
    int i = 0;
    PrintWriter writer;

    while (running) {
      Comment comment = new Comment(tweets.get(i).get(1), tweets.get(i).get(2), tweets.get(i).get(0));
      String message = comment.toString();
      String prevHash = currentChain.getMostRecentBlock().toString();
      Long blockNumber = currentChain.getCurrentNumber();
      blockTimestamp = System.currentTimeMillis();
      String nextBlock = Utils.hash(prevHash, blockNumber+1, blockTimestamp,message,nonce);

      diff = Network.getDifficulty(currentChain);

      if (nextBlock.startsWith(diff)) {
        Block block = new Block(prevHash, blockNumber + 1, message, blockTimestamp, nonce);
        currentChain.add(block);
        System.out.println("Next Block: " + 1/Math.pow(16, diff.length()));
        System.out.println(block.hash);

        nonce = new Random().nextLong() * 100000;
        i++;
      }
      nonce++;
    }
  }
}
