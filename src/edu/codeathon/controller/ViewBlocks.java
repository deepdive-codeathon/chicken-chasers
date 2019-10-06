package edu.codeathon.controller;

import edu.codeathon.model.Block;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class ViewBlocks extends ListView<Block> {


  public ViewBlocks(ObservableList<Block> items) {


    super(items);

  }




}
