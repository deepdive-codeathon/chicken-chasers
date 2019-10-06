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


      try {
        blocks.addListener((ListChangeListener<Block>) c -> {

          while (c.next()){
            Platform.runLater(()->{
              observableBlockList.addAll(c.getAddedSubList());

//              blockView.scrollTo(observableBlockList.size()-1);
            });
          }
        });

      } catch (Exception e) {
        e.printStackTrace();
      }

    return blockView;
  }



}
