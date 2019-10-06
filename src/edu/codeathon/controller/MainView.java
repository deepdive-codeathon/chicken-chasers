package edu.codeathon.controller;

import edu.codeathon.model.Block;
import edu.codeathon.model.BlockChain;
import edu.codeathon.model.Miner;
import edu.codeathon.model.Pool;
import edu.codeathon.utilities.Utils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {


    stage.setTitle("Block Display UI");
    BlockChain blockChain = new BlockChain();
    Pool pool = new Pool();

    pool.setCommentPool(Utils.parseComment("comments"));
    Miner miner = new Miner(blockChain,pool);
    BlockView viewBlocks = BlockView.setBlockChain(blockChain.getChain());
    Chat chat = new Chat();
    blockChain.add(Block.getGenesis());
    stage.setOnCloseRequest((value)->{
      miner.stop();
    });

    new Thread(miner).start();

    stage.setScene(createScene(viewBlocks, chat));

    stage.show();
  }


  private Scene createScene(Node...nodes){
    VBox root = new VBox();
    root.getChildren().addAll(nodes);

    Scene scene = new Scene(root);

    return scene;

  }

}
