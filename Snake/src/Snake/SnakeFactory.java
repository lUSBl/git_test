/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.util.Random;

/**
 *
 * @author John
 */
public class SnakeFactory {
    

   public static Snake createSnake(Field field) {
        Random random = new Random();
        int positionSnake = random.nextInt(2);
        int positionSnakeY;
        int positionSnakeX;
        while(true){
        positionSnakeY = random.nextInt(field.matrix.length);
        positionSnakeX = random.nextInt(field.matrix[0].length);
        if(positionSnakeY+3 < field.matrix.length-1 && positionSnakeX+3 < field.matrix[0].length-1){
            break;
        }
        }
     
        if(positionSnake == 0)
        return new Snake(positionSnakeY,positionSnakeX,field,true,false,false,false);
      else
        return new Snake(positionSnakeY,positionSnakeX,field,false,false,true,false);
         
    }

}
