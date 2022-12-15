# COMP2042_CW_hcyhg1
## About
This is a code of the famous 2048 game in Java. The purpose of this assignment is to *maintain* and *improve* the already given code. You can view the raw file of this `README.md` [here](https://raw.githubusercontent.com/Hemanth-Avinash/COMP2042_CW_hcyhg1/main/README.md?token=GHSAT0AAAAAAB3DNFL4W2MKTPBQD4HUUE64Y43HM7A)
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
      - [ScoreCard](#scorecard)
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
You will find the code in main/main. Use the internal main folder as your project. 
You will need to install *Javafx, Eclipe or IntellJ* IDE for Java. You will also need to add *Javafx* into your user library in your IDE. This can be done by going to Run Configurations and adding the Javafx root directory into your VN Arguments. You will also need to download *SceneBuilder* if you wish to configure the code.
## Code Compilation 
You will need to download my src files for this code to compile them before adding the Javafx library. You will also need to replace the path directory for your `test.csv` with your own directory. This has to be done in 2 places.
### ScoreCard.java
```java
public void readCSV() {
        String CsvFile = "C:\\Users\\Dragonfade\\git\\COMP2042_CW_hcyhg1\\main\\java\\com\\example\\demo\\pages\\test.csv";
        String FieldDelimiter = ",";
```
### EndGame.java
```java
 try {
 String file_name = "C:\\Users\\Dragonfade\\git\\COMP2042_CW_hcyhg1\\main\\java\\com\\example\\demo\\pages\\test.csv";
 writer.writeToCsvFile(createCsvDataSpecial(file_name, user_name), new File(file_name));
 FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
```
This is to ensure the right path is chosen when trying to store the player names and score.
## Features
### Implemented
Features Implemented(Working) | Featured Implemeted(Not Working)
-------------------- | -------------------------------
Restart button in the game | Progress circle does not spin
Logout function when pressing quit game | Restart button is supposed to bring the game back to its original state
Additional levels to the game | `GameModel.java`
Fixing the score system | 
High Score Button |
Level Difficulty Function |
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
| GameUtil.java | Controller.java |
| text.csv | EndGame.java |
| GameModel.java | |
| ScoreCard.java | |

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
Home Button | Allows user to access the menu page from the game screen

#### MenuController
```java
public void switchToScene1(ActionEvent event) throws IOException
public void switchToScene1(ActionEvent event) throws IOException {
 gameLevel(event,4);
public void switchToScene3(ActionEvent event) throws IOException {
  gameLevel(event,6);
```
This created the methods for the button to push to different events leading to `GameScene.java`.
```java
public void changeColour() {
    Color myColor = myColorPicker.getValue();
```
This allows for user to *change all the screens colors* including the `EndGame.java` screen.
#### ScoreCard
```java
 public void readCSV() {

        String CsvFile = "C:\\Users\\Dragonfade\\git\\COMP2042_CW_hcyhg1\\main\\java\\com\\example\\demo\\pages\\test.csv";
        
        String FieldDelimiter = ",";
        BufferedReader br;
```
This allows for the User to read the scores on the highscore page.
#### EndGame
```java
try {
  String file_name = "C:\\Users\\Dragonfade\\git\\COMP2042_CW_hcyhg1\\main\\java\\com\\example\\demo\\pages\\test.csv";
  writer.writeToCsvFile(createCsvDataSpecial(file_name, user_name), new File(file_name));
```
This allows the user to input name after completing the game to store high score.
#### GameUtil
This class contains all the method needed to run the game.
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
if (null != key.getCode()) switch (key.getCode()) {
                        case S:
                            score = game_util.sumCellNumbersToScore(score);
                            game_util.moveDown(score);
                            
                            break;
                        case W:
                            score = game_util.sumCellNumbersToScore(score);
                            game_util.moveUp();

```
This code fixes the bug where the player can use any input in game to increase the score. Now, the player can *only input the WASD keys* to increase the score and the calculation of the score is more accurate.

`GameScene.java` only contains the GUI interface for the screen. This is to make it more maintanable.

I have also repackaged the classes into meaningful packages; 
* `com.example.demo`
* `com.example.demo.controller`
* `com.example.demo.model`
* `com.example.demo.pages`
* `util`

This project also has a `module-info.java`.





      
     

