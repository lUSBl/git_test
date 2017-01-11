/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.util.Date;

public class Run {

    private Field field = new Field();
    public  SnakeFood food =new SnakeFood(field);
   
    public static void main(String[] args) throws InterruptedException {
       
     Run game = new Run();
       game.run();

 }
     
    
public static int t= 220;

    public void run() throws InterruptedException { 
        KeyBoardObeserver key = new KeyBoardObeserver();
        key.start();
        Snake snake = SnakeFactory.createSnake(field);
  
       
        ComfortableControlSnakes comfort = new ComfortableControlSnakes(key, snake);
        comfort.on();
        System.out.println("Идет создание карты...");
        while (true) {
            field.print(snake, food);
       
            Thread.sleep(t);
            snake.step();
            snake.introductionCoordinates();
        }
    }
}
