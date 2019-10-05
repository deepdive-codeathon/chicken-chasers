package edu.codeathon.model;

import java.util.List;

public class Main {


  public static void main(String[] args) {

    Block genesisBlock  = new Block("First Block Tweet", "genesisyaboi");
    System.out.println(genesisBlock.hash);
    Block secondBlock  = new Block("Second Block Tweet", genesisBlock.hash);
    System.out.println(secondBlock.hash);


  }

}
