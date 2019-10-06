package edu.codeathon.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Chat extends HBox {


  private TextField textBox;
  private Button enterButton;
  private StringProperty message;

  public Chat() {
    message = new SimpleStringProperty();
    textBox = new TextField();
    textBox.setPrefWidth(1000);
    enterButton = new Button("Send");
    textBox.setMaxHeight(40D);
    enterButton.setDefaultButton(true);
    enterButton.setOnAction((event)->{
      message.setValue(textBox.getText());
      textBox.clear();

    });
    getChildren().add(textBox);
    getChildren().add(enterButton);
  }


  public StringProperty getMessage() {
    return message;
  }
}
