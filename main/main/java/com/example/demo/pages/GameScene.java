package com.example.demo.pages;

import com.example.demo.Cell;
import com.example.demo.Main;
import com.example.demo.TextMaker;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;
import util.GameUtil;
/**
 * This is the class initializing the variables for the GameScene
 * @author Hemanth Avinash - modified
 *
 */
public class GameScene {
    private static int HEIGHT = 700;
    private static int n ;
    private final static int distanceBetweenCells = 10;
    private static double LENGTH;
    private TextMaker textMaker;
    private Cell[][] cells;
    private Group root;
    private long score = 0;
    private GameUtil game_util;

    public GameScene(int i) {
        
        n=i;
        cells = new Cell[n][n];
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
        textMaker = TextMaker.getSingleInstance();
        game_util = new GameUtil(i,cells,textMaker);
    }


    static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    public static double getLENGTH() {
        return LENGTH;
    }



    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");
//         Button restartButton = new Button("RESTART");
//        restartButton.setPrefSize(100,30);
//        restartButton.setTextFill(Color.RED);
//        root.getChildren().add(restartButton);
//        restartButton.relocate(750,250);
        Button homeButton = new Button("Home");
        homeButton.setPrefSize(100,30);
        homeButton.setTextFill(Color.RED);
        root.getChildren().add(homeButton);
        homeButton.relocate(750,300);
        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
        	
			@Override
			public void handle(MouseEvent arg0) {
				 //System.out.print("InsideHomeBUtton");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Home");
                alert.setHeaderText("Back to Home");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
//                    Platform.exit();
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));

                    primaryStage.setTitle("2048 Game");
                    Scene testScene = null;
                    try {
                        testScene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    primaryStage.setScene(testScene);
                    primaryStage.show();


                }
            }

        });
//       restartButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent arg0) {
//
//			}
//
//        });
        game_util.randomFillNumber(1,root);
        game_util.randomFillNumber(1,root);
        /**
         * To alert the user when wrong key is inputted.
         */
        Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Warning");
                warning.setHeaderText("OOPS!! You cant do that!");
                warning.setContentText("Please use only WASD keys");
               // System.out.print("Final Pass");
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                   System.out.println("key.getCode()");
                   System.out.println(key.getCode());
                    int haveEmptyCell;
                    if (null != key.getCode()) switch (key.getCode()) {
                        case S:
                            score = game_util.sumCellNumbersToScore(score);
                            game_util.moveDown(score);
                            
                            break;
                        case W:
                            score = game_util.sumCellNumbersToScore(score);
                            game_util.moveUp();
                            
                            break;
                        case A:
                            score=game_util.sumCellNumbersToScore(score);
                            game_util.moveLeft();
                            
                            break;
                        case D:
                            score=game_util.sumCellNumbersToScore(score);
                            game_util.moveRight();
                            
                            break;
                        default:
                            warning.showAndWait();
                            break;
                    }
                    int temp_score = Integer.parseInt(scoreText.getText());
                        scoreText.setText(score+"");                    
                    haveEmptyCell = game_util.haveEmptyCell();
                    if (haveEmptyCell == -1) {
                        if (game_util.canNotMove()) {
                            primaryStage.setScene(endGameScene);

                            EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                            root.getChildren().clear();
                            score = 0;
                        }
                    } else if(haveEmptyCell == 1)
                        game_util.randomFillNumber(2,root);
                });
            });
    }
}
