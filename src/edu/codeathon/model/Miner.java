package edu.codeathon.model;

import java.util.Random;

public class Miner implements Runnable {


  private boolean running;
  private BlockChain currentChain;

  public Miner(BlockChain chain) {
    currentChain = chain;
  }

  @Override
  public void run() {
    int nonce = new Random().nextInt()*100000;
    while (running){
      String prevHash = currentChain.getMostRecentBlock().toString();




    }
  }
}
