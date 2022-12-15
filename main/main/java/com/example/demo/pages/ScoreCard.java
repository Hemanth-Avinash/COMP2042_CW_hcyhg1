package com.example.demo.pages;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class is the store the scores and player names
 * @author Hemanth Avinash 
 */



public class ScoreCard  {

    public static class Record {
        //Assume each record have 6 elements, all String

        private SimpleStringProperty f1, f2, f3, f4, f5, f6;

        public String getF1() {
            return f1.get();
        }

        public String getF2() {
            return f2.get();
        }



        Record(String f1, String f2) {
            this.f1 = new SimpleStringProperty(f1);
            this.f2 = new SimpleStringProperty(f2);
        }

    }

    private final TableView<Record> tableView = new TableView<>();
    private static ScoreCard singleInstance = null;

    private final ObservableList<Record> dataList
            = FXCollections.observableArrayList();
    public static ScoreCard getInstance() {
        if (singleInstance == null)
            singleInstance = new ScoreCard();
        return singleInstance;
    }
    public void start(Group root,Stage primaryStage, Scene scoreScene) {
      
        primaryStage.setTitle("Score Card");       
        TableColumn columnF1 = new TableColumn("Name");
        columnF1.setCellValueFactory(
               new PropertyValueFactory<>("f1"));

        TableColumn columnF2 = new TableColumn("Score");
        columnF2.setCellValueFactory(
                new PropertyValueFactory<>("f2"));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.prefHeightProperty().bind(primaryStage.heightProperty());
        tableView.prefWidthProperty().bind(primaryStage.widthProperty());
        tableView.setItems(dataList);
        tableView.getColumns().addAll(
                columnF1, columnF2);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().add(tableView);

        root.getChildren().add(vBox);

        primaryStage.setScene(scoreScene);
        primaryStage.show();
        
        
        readCSV();
    }
/**
 * this displays the string send to this csv file.
 */
    public void readCSV() {

        String CsvFile = "C:\\Users\\Dragonfade\\git\\COMP2042_CW_hcyhg1\\main\\java\\com\\example\\demo\\pages\\test.csv";
        
        String FieldDelimiter = ",";
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);
                System.out.println(fields[0]+" : "+fields[1]);
                Record record = new Record(fields[0], fields[1]);
                dataList.add(record);

            }

        } catch (FileNotFoundException ex) {
            
       
        } catch (IOException ex) {
           
        }

    }


}