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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HungrySnake extends Application {
    Timeline timeline;
    int x=100;
    int y=100;
    String direction="RIGHT";
    
     int foodX=300;
       int foodY=200;
       
       //For special food
       int specialFoodX;
       int specialFoodY;
       boolean isSpecialFoodEaten=false;
       
       //For special food timer
       int specialFoodTimer=0;
       
       //if we miss to eat special food
       int count=0;
    @Override
    public void start(Stage stage) {
       Pane root=new Pane();
       root.setStyle("-fx-background-color:BLACK;");
       
       //Show gameover
       Text gameOver=new Text("GAME OVER");
       gameOver.setFont(Font.font(50));
       gameOver.setFill(Color.RED);
       gameOver.setX(160);
       gameOver.setY(200);
       gameOver.setVisible(false);
       root.getChildren().add(gameOver);
       //Snake Structure
       Rectangle head=new Rectangle(20,20);
       head.setX(100);
       head.setY(100);
       head.setFill(Color.GREEN);
       root.getChildren().add(head);
       
       //Food Structure
      Circle food=new Circle(10);
      food.setFill(Color.RED);
      food.setCenterX(300+10);
      food.setCenterY(200+10);
      root.getChildren().add(food);
      
      //For special food
      Circle specialFood=new Circle(10);
      specialFood.setFill(Color.YELLOW);
      specialFood.setVisible(false);
      root.getChildren().add(specialFood);
      
      //For hold the snake's body we should use array list
      ArrayList<Rectangle>snake=new ArrayList<>();
      snake.add(head);
      
      
      
      //For snake's food position
      Random random=new Random();
      
      
        timeline=new Timeline(new KeyFrame(Duration.millis(200),e->{
           
           //First check the condition whether special food is here or not.If yes,Then decrese the timer using this condition
           if(isSpecialFoodEaten){
               specialFoodTimer--;
           
           if(specialFoodTimer<=0){
               specialFood.setVisible(false);
               isSpecialFoodEaten=false;
               count++;
               System.out.println("Special food missed");
               if(count>=3){
                   System.out.println("Game Over");
                   gameOver.setVisible(true);
                   timeline.stop();
               }
           }
           }
           for(int i=snake.size()-1;i>0;i--){
               snake.get(i).setX(snake.get(i-1).getX());
               snake.get(i).setY(snake.get(i-1).getY());
           }
          
           head.setX(x);
           head.setY(y);
           
           //Game over condition: Wall collison and self collison
           
           //For Wall collison:
           if(x<0 || x>600 || y<0 ||y>400){
               System.out.println("Game Over");
               gameOver.setVisible(true);
               timeline.stop();
           }
           //For body collision:
           for(int i=1;i<snake.size();i++){
               if(x==snake.get(i).getX() && y==snake.get(i).getY()){
                   System.out.println("Game over");
                   gameOver.setVisible(true);
                   timeline.stop();
               }
           }
           
           if (direction.equals("RIGHT"))
                   x+=20;
           if(direction.equals("LEFT"))
               x-=20;
           if(direction.equals("UP"))
               y-=20;
           if(direction.equals("DOWN"))
               y+=20;
          if(x==(food.getCenterX()-10) && y==(food.getCenterY()-10)){
              System.out.println("Food Eaten");
              //If snake will eat the food, then the position of next food will be changed
              foodX=random.nextInt(30)*20;
               foodY=random.nextInt(20)*20;
              food.setCenterX(foodX+10);
              food.setCenterY(foodY+10);
              
              //Snake's body create after eating food
              Rectangle body=new Rectangle(20,20);
              body.setFill(Color.GREEN);
              body.setX(snake.get(snake.size()-1).getX());
              body.setY(snake.get(snake.size()-1).getY());
              snake.add(body);
              root.getChildren().add(body);
              
              //For special Food logic
              if(!isSpecialFoodEaten && random.nextInt(2)==0){
                  specialFoodX=random.nextInt(30)*20;
                  specialFoodY=random.nextInt(20)*20;
                  specialFood.setCenterX(specialFoodX+10);
                  specialFood.setCenterY(specialFoodY+10);
                  specialFood.setVisible(true);
                  isSpecialFoodEaten=true;
                  specialFoodTimer=30;
              }
              
          }
          //After eating special food
          if(isSpecialFoodEaten && x==(specialFood.getCenterX()-10) && y==(specialFood.getCenterY()-10)){
              System.out.println("Special food eaten!");
              specialFood.setVisible(false);
              isSpecialFoodEaten=false;
              
              //Two body parts included after eating special food
              for(int k=0;k<2;k++){
                   Rectangle body=new Rectangle(20,20);
                   body.setFill(Color.GREEN);
                    body.setX(snake.get(snake.size()-1).getX());
              body.setY(snake.get(snake.size()-1).getY());
              snake.add(body);
              root.getChildren().add(body);
              }
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
