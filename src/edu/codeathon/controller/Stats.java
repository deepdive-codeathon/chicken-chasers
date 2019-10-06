package edu.codeathon.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Stats extends GridPane {


  public Stats(BooleanProperty valid, DoubleProperty time) {
    Text validText = new Text();
    Text hashtime = new Text();

    validText.textProperty().bind(valid.asString());
    hashtime.textProperty().bind(time.asString());
    Text ccv = new Text("Current Chain valid: ");
    Text cah = new Text("Current Average Block time: ");
    Text ms = new Text("ms");
    validText.setFill(Color.WHITE);
    hashtime.setFill(Color.WHITE);
    ccv.setFill(Color.WHITE);
    cah.setFill(Color.WHITE);
    ms.setFill(Color.WHITE);
    add(ccv, 0,0);
    add(cah,0,1);
    add(ms,2,1);
    add(validText,1,0);
    add(hashtime,1,1);

    setHgap(10);
    setPadding(new Insets(10));
  }
}
