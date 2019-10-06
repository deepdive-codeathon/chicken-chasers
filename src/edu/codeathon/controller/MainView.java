package edu.codeathon.controller;

import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
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
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Block Display UI");

    final ListView listView = new ListView(data);

    for (int i = 0; i < 18; i++) {
      data.add("Block " + i);
    }

    listView.setItems(data);
    listView.setCellFactory(ComboBoxListCell.forListView(content));

    StackPane root = new StackPane();
    root.getChildren().add(listView);
    primaryStage.setScene(new Scene(root, 400, 350));
    primaryStage.show();


  }


  private Scene createScene(Node...nodes){
    VBox root = new VBox();
    root.getChildren().addAll(nodes);

    Scene scene = new Scene(root);

    return scene;

  }

}
