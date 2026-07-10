/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hungrysnake;



import static java.lang.reflect.Array.set;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HungrySnake extends Application {
    int x=100;
    int y=100;
    String direction="RIGHT";
    @Override
    public void start(Stage stage) {
       Pane root=new Pane();
       //Snake Structure
       Rectangle snake=new Rectangle(20,20);
       snake.setX(100);
       snake.setY(100);
       snake.setFill(Color.GREEN);
       root.getChildren().add(snake);
       
       //Food Structure
      Rectangle food=new Rectangle(20,20);
      food.setFill(Color.RED);
      food.setX(300);
      food.setY(200);
      root.getChildren().add(food);
      
       Timeline timeline=new Timeline(new KeyFrame(Duration.millis(200),e->{
          
           snake.setX(x);
           snake.setY(y);
           if (direction.equals("RIGHT"))
                   x+=20;
           if(direction.equals("LEFT"))
               x-=20;
           if(direction.equals("UP"))
               y-=20;
           if(direction.equals("DOWN"))
               y+=20;
          if(x==food.getX() && y==food.getY()){
              System.out.println("Food Eaten");
          }
       }));
       timeline.setCycleCount(Timeline.INDEFINITE);
       timeline.play();
       Scene scene=new Scene(root,600,400);
        stage.setTitle("Hungry Snake");
        stage.setScene(scene);
        stage.show();
       scene.setOnKeyPressed(e->{
           if(e.getCode()==KeyCode.UP)
               direction="UP";
           if(e.getCode()==KeyCode.DOWN)
               direction="DOWN";
           if(e.getCode()==KeyCode.LEFT)
               direction="LEFT";
           if(e.getCode()==KeyCode.RIGHT)
               direction="RIGHT";
       });
      
       
      
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
