package edu.codeathon.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {


  public static void main(String[] args) throws InterruptedException {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    BlockChain blockChain = new BlockChain();
    blockChain.add(new Block("genesis",""));
    Thread t = new Thread(new Miner(blockChain));
    t.start();
    t.join();
    System.out.println(gson.toJson(blockChain));
  }

}
