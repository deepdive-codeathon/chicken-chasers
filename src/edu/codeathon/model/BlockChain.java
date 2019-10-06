package edu.codeathon.model;

import edu.codeathon.utilities.Utils;
import java.util.LinkedList;
import java.util.List;

public class BlockChain {


  private List<Block> chain;

  public BlockChain() {
    chain = new LinkedList<>();
  }

  public List<Block> getChain() {
    return chain;
  }

  public void add(Block block) {
    chain.add(block);
  }

  public synchronized Block getMostRecentBlock() {
    return chain.get(chain.size() - 1);
  }

  public Long getCurrentNumber() {
    return chain.get(chain.size() - 1).blockNumber;
  }

  public boolean isValid() {
    Block currentBlock;
    Block previousBlock;

    //loop through blockchain to check hashes:
    for (int i = 1; i < chain.size(); i++) {
      currentBlock = chain.get(i);
      previousBlock = chain.get(i - 1);
      //compare registered hash and calculated hash:
      if (!currentBlock.hash.equals(Utils.hash(currentBlock.prevHash,
          currentBlock.blockNumber, currentBlock.blockTimestamp, currentBlock.message,
          currentBlock.nonce))) {
        System.out.println("Current Hashes not equal");
        return false;
      }
      //compare previous hash and registered previous hash
      if (!previousBlock.hash.equals(currentBlock.prevHash)) {
        System.out.println("Previous Hashes not equal");
        return false;
      }
    }
    return true;
  }
}
