package com.example.demo.controller;

import java.io.File;
import java.io.IOException;


import com.example.demo.pages.GameScene;
import com.example.demo.pages.ScoreCard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * This class holds the methods for the buttons on the Menu Page.
 * @author Hemanth Avinash
 *
 */
public class MenuController {

    @FXML
    private ColorPicker myColorPicker;
    @FXML
	private Pane myPane;
    @FXML
    private Parent testroot;
    private Stage primaryStage;
  //private Scene gameScene;
    @FXML
    private Color thiscolor;
   
    /**
     * this allows for button to move to gameScene
     * @param event the event to switch scenes
     * @throws IOException
     */
    
    void gameLevel(ActionEvent event,int i )
    {
          primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Group gameRoot = new Group();
        Scene gameScene = new Scene(gameRoot, 900, 900, this.thiscolor);
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, 900, 900, this.thiscolor);
        GameScene game = new GameScene(i);
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
        primaryStage.setScene(gameScene);
    }
    /**
     * this allows to button to switch to event 5
     * @param event this is the event given to the level
     * @throws IOException
     */
    public void switchToScene2(ActionEvent event) throws IOException {

      gameLevel(event,5);

    }
    /**
     * this allows for a button to switch to event 4
     * @param event event given to the level
     * @throws IOException
     */
    public void switchToScene1(ActionEvent event) throws IOException {
 gameLevel(event,4);
    }
    /**
     * this allows for a button to switch to event 6
     * @param event event given to the level
     * @throws IOException
     */
    public void switchToScene3(ActionEvent event) throws IOException {
gameLevel(event,6);

    }
/**
 * method for the score card 
 * @param event event the scorescene
 * @throws IOException
 */
    public void switchToScene4(ActionEvent event) throws IOException {
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Group gameRoot = new Group();
        Scene scoreScene = new Scene(gameRoot, 500, 500, this.thiscolor);
        ScoreCard game = new ScoreCard();
        game.start(gameRoot,primaryStage,scoreScene);
        primaryStage.setScene(scoreScene);

    }

    /**
     * this methods allows button to switch Color for the user
     */
   public void changeColour() {
    	
		Color myColor = myColorPicker.getValue();
		thiscolor = myColorPicker.getValue();
   
		myPane.setBackground(new Background(new BackgroundFill(myColor, CornerRadii.EMPTY, Insets.EMPTY)));

    }

}
