package edu.codeathon.controller;

import edu.codeathon.model.Comment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChatData {

  private ObservableList <Comment> data;

  public ChatData(){
    data = FXCollections.observableArrayList();
  }

  public Comment getLastMessage(){
    return data.get(data.size()-1);
  }


}