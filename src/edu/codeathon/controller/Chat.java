package edu.codeathon.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class Chat extends HBox {


  private TextArea textBox;
  private Button enterButton;

  public Chat() {
    textBox = new TextArea();
    enterButton = new Button("Send");
    textBox.setMaxHeight(40D);
    getChildren().add(textBox);
    getChildren().add(enterButton);
  }


}
