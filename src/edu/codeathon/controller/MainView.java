package edu.codeathon.controller;

import edu.codeathon.model.Block;
import edu.codeathon.model.BlockChain;
import edu.codeathon.model.Miner;
import edu.codeathon.model.Network;
import edu.codeathon.model.Pool;
import edu.codeathon.twitterreader.Read;
import edu.codeathon.utilities.Utils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JFrame;

public class MainView extends Application {

  public static void main(String[] args) {
    launch(args);
  }


  @Override
  public void start(Stage stage) {
    JFrame frame = new JFrame("Display");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,300);

    stage.setTitle("Block Display UI");
    BlockChain blockChain = new BlockChain();
    Pool pool = new Pool();

    pool.setCommentPool(Utils.parseComment("resources/comments"));
    try{
      pool.setCommentPool(Read.getTweets());
    } catch (Exception e){

    }
    Miner miner = new Miner(blockChain,pool);
    BlockView viewBlocks = BlockView.setBlockChain(blockChain.getChain());

    Chat chat = new Chat();

    Block genesis = Block.getGenesis();

    Utils.saveBlock(genesis, "blocks");

    pool.addInput(chat.getMessage());


    blockChain.add(Block.getGenesis());

    Stats stats = new Stats(blockChain.validProperty(), Network.getAverage());

    new Thread(miner).start();

    stage.setOnCloseRequest((value)->{
      miner.stop();
    });



    stage.setScene(createScene(stats,viewBlocks, chat));
    stage.setMaximized(true);
    stage.show();
  }


  private Scene createScene(Node...nodes){
    VBox root = new VBox();
    root.setSpacing(20);
    root.getChildren().addAll(nodes);

    Scene scene = new Scene(root);
    scene.getStylesheets().add("root.css");
    return scene;

  }

}
