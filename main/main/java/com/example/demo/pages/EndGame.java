package com.example.demo.pages;

import com.example.demo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.fxml.FXMLLoader;

public class EndGame {

    private static final ObservableList<ScoreCard.Record> dataList
            = FXCollections.observableArrayList();
    private static final String COMMA = ",";
    private static final String DEFAULT_SEPARATOR = COMMA;
    private static final String DOUBLE_QUOTES = "";
    private static TextField nameField;
    private static final String EMBEDDED_DOUBLE_QUOTES = "";
    private static final String NEW_LINE_UNIX = "\n";
    private static final String NEW_LINE_WINDOWS = "\r\n";

    private static EndGame singleInstance = null;
    private static long scoreVal = 0;

    private EndGame() {

    }

    public static EndGame getInstance() {
        if (singleInstance == null) {
            singleInstance = new EndGame();
        }
        return singleInstance;
    }

    /**
     * method returns the end game page and a quit option
     *
     * @param endGameScene
     * @param root
     * @param primaryStage
     * @param score returns score to output
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage, long score) {
        Text text = new Text("GAME OVER");
        text.relocate(250, 250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);
        Text scoreText = new Text(score + "");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(250, 400);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);
        Button quitButton = new Button("Add Name");
        quitButton.setPrefSize(100, 30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(350, 550);
        nameField = new TextField();
        nameField.relocate(300, 500);
        nameField.setPrefSize(250, 40);

        // create a stack pane
        StackPane r = new StackPane();

        // add textfield
        root.getChildren().add(nameField);

        // create a scene
        Scene sc = new Scene(r, 200, 200);
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scoreVal = score;

                String user_name = nameField.getText();
                System.out.println(user_name);
                EndGame writer = new EndGame();
                try {
                    String file_name = "C:\\Users\\Dragonfade\\git\\COMP2042_CW_hcyhg1\\main\\java\\com\\example\\demo\\pages\\test.csv";
                    writer.writeToCsvFile(createCsvDataSpecial(file_name, user_name), new File(file_name));
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
                } catch (IOException e) {


                    throw new RuntimeException(e);
                }


            }
        });

    }
/**
 * Method writes to the csv file the score stored
 * @param list the string when the user inputs
 * @param file
 * @throws IOException
 */
    private void writeToCsvFile(List<String[]> list, File file) throws IOException {

        List<String> collect = list.stream()
                .map(this::convertToCsvFormat)
                .collect(Collectors.toList());

        // CSV is a normal text file, need a writer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : collect) {

                bw.append(line);
                bw.newLine();

            }

        }

    }
/**
 * method converts the string to csv form
 * @param line
 * @return
 */
    public String convertToCsvFormat(final String[] line) {
        return convertToCsvFormat(line, DEFAULT_SEPARATOR);
    }

    public String convertToCsvFormat(final String[] line, final String separator) {
        return convertToCsvFormat(line, separator, true);
    }

    // if quote = true, all fields are enclosed in double quotes
    public String convertToCsvFormat(
            final String[] line,
            final String separator,
            final boolean quote) {

        return Stream.of(line) // convert String[] to stream
                .map(l -> formatCsvField(l, quote)) // format CSV field
                .collect(Collectors.joining(separator));    // join with a separator

    }

    private String formatCsvField(final String field, final boolean quote) {

        String result = field;

        if (result.contains(COMMA)
                || result.contains(DOUBLE_QUOTES)
                || result.contains(NEW_LINE_UNIX)
                || result.contains(NEW_LINE_WINDOWS)) {

            // if field contains double quotes, replace it with two double quotes \"\"
            result = result.replace(DOUBLE_QUOTES, EMBEDDED_DOUBLE_QUOTES);

            // must wrap by or enclosed with double quotes
            result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;

        } else {
            // should all fields enclosed in double quotes
            if (quote) {
                result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;
            }
        }

        return result;

    }

    class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {

            Integer i = new Integer(Integer.parseInt((String) o1.get(1)));
            Integer j = new Integer(Integer.parseInt((String) o2.get(1)));
            if (i > j) {
                return -1;
            } else if (j > i) {
                return 1;
            }
            return 0;
        }

    }

    private List<String[]> createCsvDataSpecial(String file_name, String user_name) {
        List<String[]> list = new ArrayList<>();

        String CsvFile = file_name;
        String FieldDelimiter = ",";

        BufferedReader br;
        List<List<String>> temp_list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            String[] header = {"name", "score"};
            list.add(header);
            int o = 0;

            List<String> li = null;
            while ((line = br.readLine()) != null) {
                o += 1;

                String[] fields = line.split(FieldDelimiter, -1);

                ScoreCard.Record record = new ScoreCard.Record(fields[0], fields[1]);

                dataList.add(record);
                // embedded double quotes
                if (o != 1) {
                    li = new ArrayList();
                    li.add(fields[0]);
                    li.add(fields[1]);
                    temp_list.add(li);

                }
            }
            li = new ArrayList();
            li.add(user_name);
            li.add(String.valueOf(scoreVal));

            temp_list.add(li);
            Collections.sort(temp_list, new ListComparator<>());

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        String arr[] = new String[2];
        int size = Math.min(temp_list.size(), 10);
        for (int i = 0; i < size; i++) {
            arr[0] = temp_list.get(i).get(0);
            arr[1] = temp_list.get(i).get(1);
            list.add(new String[]{arr[0], arr[1]});
            System.out.println(arr[0] + " : " + arr[1]);
        }
        return list;

    }

    private void readCSV() {

    }

}
