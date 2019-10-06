package edu.codeathon.model;

import java.util.stream.Collectors;

public class Network {

  private static final int CHECK_N_BLOCKS = 100;
  private static final Long target = 2000L;

  public static String getDifficulty(BlockChain blockChain) {

    final StringBuilder difficulty = new StringBuilder("000000");
//    if(blockChain.size() % CHECK_N_BLOCKS == 0){
//
//      double avg = 0;
//      for (int i = blockChain.size()-CHECK_N_BLOCKS;i< blockChain.size()-1;i++) {
//          avg += blockChain.getChain().get(i+1).blockTimestamp-blockChain.getChain().get(i).blockTimestamp;
//      }
//
//
//      avg /= CHECK_N_BLOCKS;
//      if (avg < target){
//        while (avg<target){
//          avg *= 16;
//          difficulty.append("0");
//        }
//      }else {
//        while (avg > target){
//          avg /= 16;
//          difficulty.deleteCharAt(difficulty.length()-1);
//        }
//      }

//    }
    return difficulty.toString();
  }

}
