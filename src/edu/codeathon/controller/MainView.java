package edu.codeathon.controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
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
    listView.setPrefSize(500, 350);
    listView.setEditable(true);

    content.addAll(
        "Hash: 0008c087247aa2f07ee1c5956b8e1a9f4c7f892a70e324f1bb3d161e05ca107b", "John McAfee", " ", "       I will eat my d if Bitcoin isn't $1,000,000 by 2020."," ", "                                                                                29 November 2017"
    );

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
}
