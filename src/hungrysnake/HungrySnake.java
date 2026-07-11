/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hungrysnake;



import static java.lang.reflect.Array.set;
import java.util.ArrayList;
import java.util.Random;
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
import javafx.scene.shape.Circle;
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
       Rectangle head=new Rectangle(20,20);
       head.setX(100);
       head.setY(100);
       head.setFill(Color.GREEN);
       root.getChildren().add(head);
       
       //Food Structure
      Rectangle food=new Rectangle(20,20);
      food.setFill(Color.RED);
      food.setX(300);
      food.setY(200);
      root.getChildren().add(food);
      
      //For hold the snake's body we should use array list
      ArrayList<Rectangle>snake=new ArrayList<>();
      snake.add(head);
      
      
      
      //For snake's food position
      Random random=new Random();
      
      
       Timeline timeline=new Timeline(new KeyFrame(Duration.millis(200),e->{
           for(int i=snake.size()-1;i>0;i--){
               snake.get(i).setX(snake.get(i-1).getX());
               snake.get(i).setY(snake.get(i-1).getY());
           }
          
           head.setX(x);
           head.setY(y);
           
           
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
              //If snake will eat the food, then the position of next food will be changed
              int foodX=random.nextInt(30)*20;
              int foodY=random.nextInt(30)*20;
              food.setX(foodX);
              food.setY(foodY);
              
              //Snake's body create after eating food
              Rectangle body=new Rectangle(20,20);
              body.setFill(Color.GREEN);
              body.setX(snake.get(snake.size()-1).getX());
              body.setY(snake.get(snake.size()-1).getY());
              snake.add(body);
              root.getChildren().add(body);
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
