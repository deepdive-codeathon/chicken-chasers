package edu.codeathon.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


/**
 * Dummy class meant to imitate a network
 */
public class Network {

  private static final int CHECK_N_BLOCKS = 10;
  private static final Long target = 2000L;
  private static DoubleProperty average = new SimpleDoubleProperty();
  private static final StringBuilder difficulty = new StringBuilder("00000");

  public static String getDifficulty(BlockChain blockChain) {

    if (blockChain.size() % CHECK_N_BLOCKS == 0) {

      double avg = 0;
      for (int i = blockChain.size() - CHECK_N_BLOCKS; i < blockChain.size() - 1; i++) {
        avg += blockChain.getChain().get(i + 1).blockTimestamp - blockChain.getChain()
            .get(i).blockTimestamp;
      }
      average.setValue(avg / CHECK_N_BLOCKS);

    }
    return difficulty.toString();
  }

  public static DoubleProperty getAverage() {
    return average;
  }
}
