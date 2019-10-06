package edu.codeathon.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

public class Main {


  public static void main(String[] args) throws InterruptedException, IOException {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    BlockChain blockChain = new BlockChain();
    Block genesis = new Block("genesis",0L,"", System.currentTimeMillis(),0L);

    blockChain.add(genesis);
    Thread t = new Thread(new Miner(blockChain));
    t.start();
    t.join();
    System.out.println(gson.toJson(blockChain));
    System.out.println(blockChain.isValid());
  }

}
