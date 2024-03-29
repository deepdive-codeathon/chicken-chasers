package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.List;
import java.util.Random;

public class Miner implements Runnable {


  private boolean running;
  private BlockChain currentChain;
  private Pool pool;


  public Miner(BlockChain chain, Pool pool) {
    currentChain = chain;
    this.pool = pool;
  }

  @Override
  public void run() {
    running = true;
    Long nonce = new Random().nextLong() * 10000000;
    Long blockTimestamp;
    String message;
    int i = 0;
    int comment_no = 1;
    message = pool.getFromPool(comment_no);


    while (running) {
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

        message = pool.getFromPool(comment_no);
        nonce = new Random().nextLong()*100000;

        Utils.saveBlock(block,"blocks");
        i++;
      }
      nonce++;
    }
  }


  public void stop() {
    running = false;
  }
}
