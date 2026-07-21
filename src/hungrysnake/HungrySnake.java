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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
       
       VBox gameOver=new VBox(20);
       gameOver.setAlignment(Pos.CENTER);
       gameOver.setStyle("-fx-background-color:white;-fx-padding:25px 40px;");
       gameOver.setLayoutX(170);
       gameOver.setLayoutY(130);
       Text gameText=new Text("GAME OVER");
       gameText.setFont(Font.font("Arial",FontWeight.BOLD,40));
       gameText.setFill(Color.RED);
       
       Button tryBtn=new Button("Try Again");
       tryBtn.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:black;");
       Button exitgameBtn=new Button("Exit");
       exitgameBtn.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:red;");
       
     
       
       HBox buttonBox=new HBox(20);
       buttonBox.setAlignment(Pos.CENTER);
       buttonBox.getChildren().addAll(tryBtn,exitgameBtn);
       gameOver.getChildren().addAll(gameText,buttonBox);
       gameOver.setVisible(false);
       root.getChildren().add(gameOver);
       
       //Snake Structure
       Rectangle head=new Rectangle(20,20);
       head.setX(100);
       head.setY(100);
       head.setFill(Color.GREEN);
       root.getChildren().add(head);
       
       
       //For snake's eye
       Circle leftEye=new Circle(3,Color.BLACK);
       Circle rightEye=new Circle(3,Color.BLACK);
       root.getChildren().addAll(leftEye,rightEye);
       
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
       
       VBox startMenu=new VBox(20);
       startMenu.setAlignment(Pos.CENTER);
       startMenu.setLayoutX(200);
       startMenu.setLayoutY(150);
       
       //For hold the snake's body we should use array list
         ArrayList<Rectangle>snake=new ArrayList<>();
      snake.add(head);
        //For snake's food position
      Random random=new Random();
      
      
        tryBtn.setOnAction(e->{
            for(int i=1;i<snake.size();i++){
                root.getChildren().remove(snake.get(i));
            }
            snake.clear();
            snake.add(head);
           x=100;
           y=100;
           head.setX(x);
           head.setY(y);
           direction="RIGHT";
            foodX=random.nextInt(30)*20;
               foodY=random.nextInt(20)*20;
              food.setCenterX(foodX+10);
              food.setCenterY(foodY+10);
              
           count=0;
           gameOver.setVisible(false);
           timeline.playFromStart();
       });
       
       exitgameBtn.setOnAction(e->{
           System.exit(0);
        
       });

       
       Label gameTitle=new Label("HUNGRY SNAKE");
       gameTitle.setStyle("-fx-font-size:32px;-fx-font-weight:bold;-fx-text-fill:white;");
       Button playBtn=new Button("Play");
       playBtn.setStyle("-fx-font-size:20px;-fx-font-weight:bold;-fx-text-fill:black;");
       startMenu.getChildren().addAll(gameTitle,playBtn);
       startMenu.setVisible(true);
       
       
       playBtn.setOnAction(e->{
           
           for(int i=1;i<snake.size();i++){
                root.getChildren().remove(snake.get(i));
            }
           snake.clear();
           snake.add(head);
            x=100;
           y=100;
           head.setX(x);
           head.setY(y);
           direction="RIGHT";
            foodX=random.nextInt(30)*20;
               foodY=random.nextInt(20)*20;
              food.setCenterX(foodX+10);
              food.setCenterY(foodY+10);
              
           count=0;
           startMenu.setVisible(false);
           gameOver.setVisible(false);
           timeline.playFromStart();
       });
       
       VBox menu=new VBox(20);
       menu.setLayoutX(200);
       menu.setLayoutY(150);
       Button resumeBtn=new Button("Resume");
       resumeBtn.setStyle("-fx-font-size:20px;-fx-font-weight:bold;-fx-padding:12px 30px;");
       Button restartBtn=new Button("Restart");
       restartBtn.setStyle("-fx-font-size:20px;-fx-font-weight:bold;-fx-padding:12px 30px;");
       Button exitBtn=new Button("Exit");
       exitBtn.setStyle("-fx-font-size:20px;-fx-font-weight:bold;-fx-padding:12px 30px;");
       menu.getChildren().addAll(resumeBtn,restartBtn,exitBtn);
       menu.setVisible(false);
       
       resumeBtn.setOnAction(e->{
           menu.setVisible(false);
           timeline.play();
       });
       restartBtn.setOnAction(e->{
           menu.setVisible(false);
           timeline.play();
       });
       exitBtn.setOnAction(e->{
          System.exit(0);
       });
       root.getChildren().addAll(startMenu,menu);
      startMenu.toFront();
      
   
      
      
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
           
           //For set the eye position with change the direction
           if(direction.equals("RIGHT")){
               //If snake's go to the right
           leftEye.setCenterX(x+15);
           leftEye.setCenterY(y+5);
           rightEye.setCenterX(x+15);
           rightEye.setCenterY(y+15);
           }
           
           else if(direction.equals("LEFT")){
               //If snake's go to the left
           leftEye.setCenterX(x+5);
           leftEye.setCenterY(y+5);
           rightEye.setCenterX(x+5);
           rightEye.setCenterY(y+15);
           }
            
            else if(direction.equals("UP")){
               //If snake's go to the up
           leftEye.setCenterX(x+5);
           leftEye.setCenterY(y+5);
           rightEye.setCenterX(x+15);
           rightEye.setCenterY(y+5);
           }
             
             else if(direction.equals("DOWN")){
               //If snake's go to the down
           leftEye.setCenterX(x+5);
           leftEye.setCenterY(y+15);
           rightEye.setCenterX(x+15);
           rightEye.setCenterY(y+15);
           }
           //Game over condition: Wall collison and self collison
           
           //For Wall collison:
           if(x<0 || x>600 || y<0 ||y>400){
               System.out.println("Game Over");
               gameOver.setVisible(true);
               gameOver.toFront();
               timeline.stop();
           }
           //For body collision:
           for(int i=1;i<snake.size();i++){
               if(x==snake.get(i).getX() && y==snake.get(i).getY()){
                   System.out.println("Game over");
                   gameOver.setVisible(true);
                   gameOver.toFront();
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
                  specialFoodTimer=50;
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
       //timeline.play();
       Scene scene=new Scene(root,600,400);
        stage.setTitle("Hungry Snake");
        stage.setScene(scene);
        stage.show();
       scene.setOnKeyPressed(e->{
           if(e.getCode()==KeyCode.P){
               menu.setVisible(true);
               menu.toFront();
               timeline.pause();
           }
           if(e.getCode()==KeyCode.UP)
               direction="UP";
           if(e.getCode()==KeyCode.DOWN)
               direction="DOWN";
           if(e.getCode()==KeyCode.LEFT)
               direction="LEFT";
           if(e.getCode()==KeyCode.RIGHT)
               direction="RIGHT";
       });
      
       stage.show();
      
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
