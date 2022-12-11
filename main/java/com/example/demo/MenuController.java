package com.example.demo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;

import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private ColorPicker myColorPicker;
    @FXML
	private Pane myPane;
    @FXML
    private Parent testroot;
    private Stage primaryStage;
    private Scene gameScene;
    
    public void switchToScene1(ActionEvent event) throws IOException {
    	 
    	  primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	  
    	  Group gameRoot = new Group();
          //setGameRoot(gameRoot);
          Scene gameScene = new Scene(gameRoot, 900, 900, Color.rgb(189, 177, 92));
          Group endgameRoot = new Group();
          Scene endGameScene = new Scene(endgameRoot, 900, 900, Color.rgb(250, 20, 100, 0.2));
//          setGameScene(gameScene);
          
          GameScene game = new GameScene();
          game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
          primaryStage.setScene(gameScene);
	
    }
    
   public void changeColour() {
    	
		Color myColor = myColorPicker.getValue();
    
		myPane.setBackground(new Background(new BackgroundFill(myColor, CornerRadii.EMPTY, Insets.EMPTY)));

    }

}
