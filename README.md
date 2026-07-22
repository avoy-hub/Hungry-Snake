# Hungry Snake Game (JavaFX)
A classic 2D Snake game built using Java and JavaFX. The game features custom movement logic, dynamic body growth, special food timers, UI Design and smooth collision handling.


<img width="634" height="459" alt="Screenshot (168)" src="https://github.com/user-attachments/assets/06760cb3-80e8-46b9-a192-db2c0795b6c9" />
<img width="625" height="457" alt="Screenshot (169)" src="https://github.com/user-attachments/assets/38e7370d-3c8e-42f1-a99c-c3dbde524b5e" />
<img width="633" height="464" alt="Screenshot (172)" src="https://github.com/user-attachments/assets/842e2e82-6ca0-41c3-854a-f638d73fe8c3" />
<img width="628" height="472" alt="Screenshot (173)" src="https://github.com/user-attachments/assets/103c6b2b-91da-450a-8549-f72cd2514d78" />

Features:
1. Interactive UI: Dynamic Start Menu, Game Over Screen, and Navigation Buttons (Play, Try Again, Exit).
2. Visual Details: Custom snake head features(like eyes using circle nodes) that make the snake look interactive and expressive
3. Dynamic Snake Growth: Snake grows longer each time it eats food using ArrayList tracking.
4. Random Food Position: Food appears at random screen positions upon eating and restarting.
5. Special Food & Miss Counter: Includes special timed food mechanics with event tracking.
6. Reset System: Clean game state reset that clears body segments, resets positions, and stops/restarts 
7. JavaFX Timeline

Technologies & Components Used
1. Language: Java
​2. GUI Framework:JavaFX
 Key Components & Classes Used:
1.  Stage & Scene – For window handling and scene management.
2.  Rectangle & Circle – Used to create the snake's head and body segments and eyes using circle nodes on head.
3.  VBox & HBox – Layout containers used for organizing UI buttons and menu titles cleanly.
4.  Button & Label – Interactive JavaFX controls.
5.  Timeline & KeyFrame – For game loop timing and movement execution (200ms tick rate).
6.  ArrayList<Rectangle> – Data structure used to store and manage the growing snake body.
7.  Random – For random food position.

How to Play:
1. Launch the application and click Play on the Start Menu 
2. Use the Arrow Keys(Up, Down, Left, Right) to control the snake's direction
3. Eat food to grow longer and increase your score
4. Avoid hitting the screen boundaries or colliding with the snake's own body
5. If you lose, click Try Again to restart immediately or Exit to quit

How to Run
1. Make sure you have JDK 11+(or Java 8 with embedded JavaFX) and JavaFX SDK configured in your IDE(NetBeans, Eclipse or IntelliJ).
2. Clone the repository:  https://github.com/avoy-hub/Hungry-Snake
3. Open the project in your Java IDE
4. Run HungrySnake.java

