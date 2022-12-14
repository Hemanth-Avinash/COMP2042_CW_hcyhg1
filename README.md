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
    - Implemented
    - Not Implemented
 - [Class Changes](#class-changes)
    - Added Classes
    - Modified Classes
 - [Additions](#additions)
    - [MenuController](#menucontroller)
    - [EndGame](#endgame)
 - [Maintenance](#maintenance)
    - [Main](#main)
    - [GameScene](#gamescene)
 </details>
<!-- ⛔️ MD-MAGIC-EXAMPLE:END --> 

## Author
I am *Hemanth Avinash* of the University of Nottingham Malaysia BSc Computer Science course. My student id is *20414672*.
## Installation
You will need to install *Javafx, Eclipe or IntellJ* IDE for Java. You will also need to add *Javafx* into your user library in your IDE. This can be done by going to Run Configurations and adding the Javafx root directory into your VN Arguments.
## Code Compilation 
You will need to download my src files for this code to compile them before adding the Javafx library.
## Features
Here I will document a list of features i have implemented, whether working or not and also features i chose not to implement.
Features Implemented(Working) | Featured Implemeted(Not Working)
-------------------- | -------------------------------
Restart button in the game |  
Logout function when pressing quit game | 
Additional levels to the game | 
Fixing the score system | 

Features Not Implemeted | Explanation
----------------------- | -----------
## Class Changes
List of added classes:
* MenuController.java
* Menu.fxml

List of modified classes:
* Main.java
* GameScene.java
* Controller.java
* EndGame.java

## Additions
Additions | Explanation
--------- | -----------
Restart button | Allows users to restart the game even while mid game
Logout button | Allows user to logout of the game instead of the screen just clearing
Additional levels | Allows user to choose a difficulty level 
Start button | User can access the game from the menu through a button

### MenuController
```java
public void switchToScene1(ActionEvent event) throws IOException
```
This created the methods for the button to push to `GameScene.java`.
```java
public void changeColour() {
    Color myColor = myColorPicker.getValue();
```
This allows for user to change all the screens colors including the `EndGame.java` screen.
### EndGame
```java
primaryStage.close();
```
This allows the user to logout of the stage.
## Maintenance 
### Main
```java
Parent testRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
primaryStage.setTitle("2048 Game");
```
This code is to allow the access to my Menu page and setting the title to "2048". 

I moved the code from start method in `main.java` to my method in `MenuController.java` to make it more accessible. I only left the launch method in `main.java` as it should function more of an overview for the project and should not have any code for the menu n game scene itself.

I removed the initialization of the variables in main as well.
### GameScene
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
This code fixes the bug where the player can use any input in game to increase the score. Now, the player can only input the arrow keys to increase the score.


      
     

