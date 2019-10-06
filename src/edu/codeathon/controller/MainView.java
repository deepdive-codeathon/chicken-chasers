package edu.codeathon.controller;

import edu.codeathon.model.Block;
import edu.codeathon.model.BlockChain;
import edu.codeathon.model.Miner;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

  public static final ObservableList content =
      FXCollections.observableArrayList();
  public static final ObservableList data =
      FXCollections.observableArrayList();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {


    stage.setTitle("Block Display UI");

    BlockChain blockChain = new BlockChain();
    Miner miner = new Miner(blockChain);
    ViewBlocks viewBlocks = new ViewBlocks(blockChain.getChain());
    blockChain.add(Block.getGenesis());
    new Thread(miner).start();

    stage.setScene(createScene(viewBlocks));

    stage.show();
  }


  private Scene createScene(Node...nodes){
    VBox root = new VBox();
    root.getChildren().addAll(nodes);

    Scene scene = new Scene(root);

    return scene;

  }

}
