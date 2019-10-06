package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.List;
import java.util.Random;

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
    List<Comment> tweets = Utils.parseComment("resources/comments");
    int i = 0;

    while (running) {
      String message = "Hello World";
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

//        System.out.println(block.toString());
        nonce = new Random().nextLong()*100000;

        Utils.saveBlock(block,"blocks");
        i++;
      }
      nonce++;
    }
  }
}
