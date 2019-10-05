package edu.codeathon.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.codeathon.utilities.Utils;
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
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    running = true;
    Long nonce = new Random().nextLong()*10000000;

    Long blockTimestamp;
    while (running) {
      String message = "HELLO WORLD";
      String prevHash = currentChain.getMostRecentBlock().toString();
      blockTimestamp = System.currentTimeMillis();
      String nextBlock = Utils.hash(prevHash,blockTimestamp,message,nonce);

      if (nextBlock.startsWith(difficulty)) {


        Block block = new Block(prevHash, message, blockTimestamp, nonce);
        currentChain.add(block);
        System.out.println("Next Block:");
        System.out.println(gson.toJson(block));
        nonce = new Random().nextLong()*100000;

      }
      nonce++;
    }
  }
}
