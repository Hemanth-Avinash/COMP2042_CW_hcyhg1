# COMP2042_CW_hcyhg1
## About
This is a code of the famous 2048 game in Java. The purpose of this assignment is to *maintain* and *improve* the already given code. You can view the raw file of this `README.md` [here](https://raw.githubusercontent.com/Hemanth-Avinash/COMP2042_CW_hcyhg1/main/README.md?token=GHSAT0AAAAAAB3DNFL4VHKLZZMONL7QBSNMY4Z5SWA).
## Table of Contents
<!-- ⛔️ MD-MAGIC-EXAMPLE:START (TOC:collapse=true&collapseText=Click to expand) -->
<details>
<summary>Click to expand</summary>
  
 - [About](#about)
 - [Author](#author)
 - [Installation](#installation)
 - [Code Compilation](#code-compilation)
 - [Features](#features)
    - [Implemented](#implemented)
    - [Not Implemented](#not-implemented)
 - [Changes](#changes)
    - [Classes](#classes)
    - [Additions](#additions)
      - [MenuController](#menucontroller)
      - [EndGame](#endgame)
      - [GameUtil](#gameutil)
    - [Maintenance](#maintenance)
      - [Main](#main)
      - [GameScene](#gamescene)
 </details>
<!-- ⛔️ MD-MAGIC-EXAMPLE:END --> 

## Author
I am *Hemanth Avinash* of the University of Nottingham Malaysia BSc Computer Science course. My student id is *20414672*.
## Installation
You will need to install *Javafx, Eclipe or IntellJ* IDE for Java. You will also need to add *Javafx* into your user library in your IDE. This can be done by going to Run Configurations and adding the Javafx root directory into your VN Arguments. You will also need to download *SceneBuilder* if you wish to configure the code.
## Code Compilation 
You will need to download my src files for this code to compile them before adding the Javafx library.
## Features
### Implemented
Features Implemented(Working) | Featured Implemeted(Not Working)
-------------------- | -------------------------------
Restart button in the game | Progress circle does not spin
Logout function when pressing quit game | Restart button is supposed to bring the game back to its original state
Additional levels to the game |
Fixing the score system | 
High Score Button |
### Not Implemented
Features Not Implemeted | Explanation
----------------------- | -----------
The single start button | I replaced one single start button to 3 buttons, so the user can choose the levels to the game.
Quit button | The Quit button is removed as the user might want to go back to menu to see high score. The user can press the 'x' symbol to quit the GUI.
`Account.java` | This class was not required as I didnt use an account system
## Changes
### Classes
| Added | Modified |
| ----- | -------- |
| MenuController.java | Main.java |
| Menu.fxml | GameScene.java |
| GameUtil | Controller.java |
| text.csv | EndGame.java |

### Additions
Additions | Explanation
--------- | -----------
Restart button | Allows users to restart the game even while mid game
Logout button | Allows user to logout of the game instead of the screen just clearing
Additional levels | Allows user to choose a difficulty level 
Start button | User can access the game from the menu through a button
High Score text field | User can input name and the score will be stored
High Score Button | User can press button to see highscore list
Alert | Alert will show up when user press other keys during game scene

#### MenuController
```java
public void switchToScene1(ActionEvent event) throws IOException
```
This created the methods for the button to push to `GameScene.java`.
```java
public void changeColour() {
    Color myColor = myColorPicker.getValue();
```
This allows for user to *change all the screens colors* including the `EndGame.java` screen.
#### EndGame
```java
primaryStage.close();
```
This allows the user to *logout* of the stage.
#### GameUtil
```java
```

## Maintenance 
#### Main
```java
Parent testRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
primaryStage.setTitle("2048 Game");
```
This code is to allow the *user to access my Menu page* and setting the title to "2048". 

I moved the code from start method in `main.java` to my method in `MenuController.java` to make it more *accessible*. I only left the launch method in `main.java` as it should function more of an *overview for the project* and should not have any code for the menu n game scene itself.

I removed the *initialization* of the variables in main as well.
#### GameScene
```java
if (key.getCode() == KeyCode.DOWN) {
    GameScene.this.sumCellNumbersToScore();
    GameScene.this.moveDown();
 } else if (key.getCode() == KeyCode.UP) {
    GameScene.this.sumCellNumbersToScore();
    GameScene.this.moveUp();
 } else if (key.getCode() == KeyCode.LEFT) {
    GameScene.this.sumCellNumbersToScore();
    GameScene.this.moveLeft();
 } else if (key.getCode() == KeyCode.RIGHT) {
    GameScene.this.sumCellNumbersToScore();
     GameScene.this.moveRight();
```
This code fixes the bug where the player can use any input in game to increase the score. Now, the player can *only input the arrow keys* to increase the score.


      
     

