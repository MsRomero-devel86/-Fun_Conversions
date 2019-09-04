/*
 * Create a javaFX class that does exercises 18.12, 18.14, 18.25
* in these methods they will all be written recursivly , 
*method print characters in a string reversed.
* method prints numbers of uppercse letter in a string
* method that prints out all permutations of a string
* create a hBox to hold all labels, text fields, and buttons
 */
package mp_1;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author meghan
 */
public class StringClass extends Application {

    TilePane pane = new TilePane();

    private TextField input = new TextField();
    public Button reverseBtn = new Button("Reverse the Word!");
    private Button upperCaseBtn = new Button(" Count Uppercase Letters");
    private Button permutationsBtn = new Button("Show Permutations");
    private Button reset = new Button("Clear");

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane.getChildren().addAll(new Label("Enter String Here: "), input);
        pane.getChildren().addAll(new Label("Press Button to Being"), reverseBtn, upperCaseBtn, permutationsBtn, reset);
        pane.setStyle("-fx-border-color: orange");
        pane.setAlignment(Pos.TOP_CENTER);

        //handlers and resitgers
        reverseBtn.setOnAction(e -> reverseWord(String.valueOf(input.getText())));
        permutationsBtn.setOnAction(e -> stringPermutation(String.valueOf(input.getText())));

        upperCaseBtn.setOnAction((ActionEvent ee) -> {
            Scanner word = new Scanner(System.in);
            System.out.println("Enter a word: ");
            String s = word.nextLine();
            System.out.print("The amount of Upper case letter is = " + countUppercase(s));
        });
        reset.setOnAction((ActionEvent ex) -> input.clear());
        //scene for stage
        Scene scene = new Scene(pane, 350, 300);
        primaryStage.setTitle("String Recursive Methods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
// 18.12 method to diplay string in reverse

    private static void reverseWord(String s) {
        reverseWord(s, s.length());
    }

    private static void reverseWord(String s, int high) {
        if (high == 0) {
            return;
        }
        System.out.print(s.substring(high - 1));
        reverseWord(s.substring(0, high - 1));
    }

    // 18. 14  method to get all uppercaseLetter in an string
    public static int countUppercase(String s) {
        return countUppercase(s, 0);
    }

    public static int countUppercase(String s, int count) {

        if (s.length() == 0) {
            return count;
        }
        if (s.charAt(0) >= 65 && s.charAt(0) <= 90) {
            count++;
        }
        return countUppercase(s.substring(1), count);
       

    }

//18.25 method to find  all permutations in a string 
    public static void stringPermutation(String s) {
        stringPermutation("", s);
    }

    public static void stringPermutation(String s1, String s2) {

        if (s2.length() == 0) {
            System.out.println(s1);
        } else {
            //loop to count length of string
            for (int i = 0; i < s2.length(); i++) {
                //recursive call
                stringPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
            }
        }
    }

    //main method 
    public static void main(String[] args) {
        launch(args);//start action
    }
}
