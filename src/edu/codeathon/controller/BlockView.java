package edu.codeathon.controller;

import edu.codeathon.model.Block;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

public class BlockView extends ListView<Block> {

  private static ObservableList<Block> observableBlockList = FXCollections.observableArrayList();

  private BlockView(){
  }

  static BlockView setBlockChain(ObservableList<Block> blocks){
    BlockView blockView = new BlockView();
    blockView.setItems(observableBlockList);
    blockView.setPrefHeight(900);

      try {
        blocks.addListener((ListChangeListener<Block>) c -> {

          while (c.next()){
            Platform.runLater(()->{
              observableBlockList.addAll(c.getAddedSubList());

            });
          }
        });

      } catch (Exception e) {
        e.printStackTrace();
      }

    return blockView;
  }



}
