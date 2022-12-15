package com.example.demo;



import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;

import java.util.Optional;
import java.util.Scanner;


/**
 * This is the main class for this code
 * @author Hemanth Avinash - modified
 *
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	
    	Parent testRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
    	primaryStage.setTitle("2048 Game");
    	Scene testScene = new Scene(testRoot);
    	primaryStage.setScene(testScene);
    	primaryStage.show();
    }
 static void main(String[] args) {
        launch(args);
    }
}
