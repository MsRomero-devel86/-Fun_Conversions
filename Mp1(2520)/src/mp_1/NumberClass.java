/*
 * Create a class that uses recursive methods to slove exercises.
* all methods invole numbers, the methods are as follows, find the sum of all digits, find the largest number in a Array of Integers,
* conversions, for Decimal to Hexidecmali, decimal to binary, adn convert Binary to decimal not using binary class.
* creat one etxt field to user to put in numbers , buttons for each method and Two labels. Will provide appropreiate title to page. 
* provivded in comments are the method exercise number and description. Used a tile pane for my layout, posssible not the best choice. 
*(the appearance to me is fine)
*/

package mp_1;

import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author romero
 */
public class NumberClass extends Application {
//create pane to hold nodes, textfield

    TilePane pane = new TilePane();

//create nodes
    private TextField values = new TextField();
    private Button decToHexBtn = new Button("Decimal To Hexidecimal");
    private Button LargeNumBtn = new Button("Find Largest Value");
    private Button SumBtn = new Button("Sum Of All Digits");
    private Button decToBinaryBtn = new Button("Decimal to Binary");
    private Button bin2DecBtn = new Button("Binary to Decimal");
    private Button reset = new Button("ReFresh");

    //start method from appilcation to set up your pane
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label one = new Label("Enter Integers 0-1000, Than click Button!");
        pane.getChildren().add(values);
        values.setAlignment(Pos.BOTTOM_RIGHT);
        values.setFont(Font.font(STYLESHEET_CASPIAN, 14));

        pane.getChildren().addAll(one, decToHexBtn, LargeNumBtn, SumBtn, decToBinaryBtn,
                bin2DecBtn, reset);

        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-border-color: black");

        Scene scene = new Scene(pane, 350, 300);
        primaryStage.setTitle("Integers Recursive Methods");
        primaryStage.setScene(scene);
        primaryStage.show();

        //handlers and resitgers
        decToHexBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("You number converted to Hexidecmail =  " + dec2Hex(Integer.parseInt(values.getText())));
            }
        });

        LargeNumBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ee) {
                Scanner number = new Scanner(System.in);
                System.out.print("Enter 8 integers: ");
                int[] array = new int[8];
                for (int i = 0; i < array.length; i++) {
                    array[i] = number.nextInt();
                }

                System.out.println("The largerst Number = " + largestNumber(array));
            }
        });
        decToBinaryBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ex) {
                System.out.println("The number to binary = " + dec2Bin(Integer.parseInt(values.getText())));
            }
        });
        SumBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ep) {
                System.out.println("The sum of all Digits= " + sumDigits(Integer.parseInt(values.getText())));
            }
        });
        bin2DecBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ep) {          
                System.out.println("Binary to decimal= " + bin2Dec((values.getText())));
            }
        });
        
        // clear textfield
        reset.setOnAction((ActionEvent ex) -> values.clear());
    }

    // 18.11 method to sum all digits in a int string
    public static long sumDigits(long n) {

        if (n == 0) {
            return n;
        }

        return n % 10 + sumDigits(n / 10);
    }

    // 18.13 method to find the largest number in Array
    private static int largestNumber(int[] array) {

        return largestNumber(array, 0, array[0]);
    }

    private static int largestNumber(int[] array, int i, int high) {

        if (i == array.length) {
            return high;
        }

        if (high < array[i]) {
            high = array[i];
        }

        return largestNumber(array, i + 1, high);
    }

    //18.21 Decimal to Binary
    public static String dec2Bin(int value) {

        String s = (((value & 1) == 1) ? "1" : "0");
        if (value == 0 || value == 1) {
            return s;
        } else {
            return dec2Bin(value >> 1) + s;
        }
    }

    //  18.22 method for decimal to HEXidecimal
    public static char dec2Hex(int value) {
        if (value >= 10 && value <= 15) {
            return (char) ('A' + value - 10);
        } else {
            return (char) ('0' + value);
        }
    }

//18.23 binary to decimal
    public static int bin2Dec(String binaryNumber) {

        int size = binaryNumber.length();
        if (size == 1) {
            return Integer.parseInt(binaryNumber);
        } else {
            return bin2Dec(binaryNumber.substring(1, size))
                    + Integer.parseInt(binaryNumber.substring(0, 1))
                    * (int) Math.pow(2, size - 1);
        }
    }


//main method
    public static void main(String[] args) {
        launch(args);

    }
}
