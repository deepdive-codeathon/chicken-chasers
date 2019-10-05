package edu.codeathon.model;

import java.util.Random;

public class Mine implements Runnable {


  boolean running;
  BlockChain currentChain;

  public Mine(BlockChain chain) {
    currentChain = chain;
  }

  @Override
  public void run() {
    int nonce = new Random().nextInt()*100000;
    while (running){

      currentChain.getMostRecentBlock();
    }
  }
}
