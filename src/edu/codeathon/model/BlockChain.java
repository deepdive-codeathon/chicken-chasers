package edu.codeathon.model;

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

  public void add(Block block){
    chain.add(block);
  }


  public synchronized Block getMostRecentBlock(){
    return chain.get(chain.size()-1);
  }

  public Long getCurrentNumber() {
    return chain.get(chain.size()-1).blockNumber;
  }
}
