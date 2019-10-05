package edu.codeathon.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Miner implements Runnable {


  private boolean running;
  private BlockChain currentChain;
  private String difficulty = "000";

  public Miner(BlockChain chain) {
    currentChain = chain;
  }

  @Override
  public void run() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    running = true;
    long startTime = System.currentTimeMillis();
    Block nextBlock;
    while (running && System.currentTimeMillis()-startTime < 60*1000) {
      String prevHash = currentChain.getMostRecentBlock().toString();
      nextBlock = new Block(prevHash,"Hello World");
      if (nextBlock.toString().startsWith(difficulty)) {
        currentChain.add(nextBlock);
        System.out.println("Next Block:");
        System.out.println(gson.toJson(nextBlock));
      }
    }
  }
}
