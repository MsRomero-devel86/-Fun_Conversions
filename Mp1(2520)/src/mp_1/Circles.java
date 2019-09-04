package mp_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author romero
 */
public class Circles extends Application {
    
    
  @Override //start method
  public void start(Stage primaryStage) {               
    // Create a scene and place it in the stage
    Scene scene = new Scene(new CirclePane(), 220, 220);
    primaryStage.setTitle("18.20 Cirlces"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
  }

  //Pane for displaying triangles 
  static class CirclePane extends Pane {
    private double radius = 80;

    public CirclePane() {
      displayCircles();
    }
    //method to display circles
    private void displayCircles() {
      if (radius >= 10) {
        Circle c = new Circle(100, 100, radius);
        c.setFill(Color.PINK);
        c.setStroke(Color.BLACK);
        c.centerXProperty();
        c.centerYProperty();
        getChildren().add(c);
        radius -= 10;
        displayCircles();
      } 
    }
  }
  public static void main(String[] args) {
    launch(args);//start action
  }
}

