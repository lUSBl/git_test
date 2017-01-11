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
public class SnakeFood {
   private int locationY;
   private int locationX;
   private  boolean whetherEatenFood = true;
   private  boolean whetherEatenShell = true;
   private  boolean whetherEatenAcceleration = true;
   Field field;
   SnakeFood(Field field){
       this.field = field;
   }
    public void determineTheLocationOfTheFood(){
       whetherEatenFood = false;
       whetherEatenShell = false;
       whetherEatenAcceleration = false;
       Random rnd = new Random();
       this.locationY = rnd.nextInt(field.matrix.length);
       this.locationX = rnd.nextInt(field.matrix[1].length);
    }
    
    public int getLocationY(){
        return locationY;
    }
    public int getLocationX(){
        return locationX;
    }
    public void eatFood(){
        
        whetherEatenFood = true;
    }
     public void eatShell(){
        
        whetherEatenShell = true;
    }
      public void eatAcceleration(){
        
        whetherEatenAcceleration = true;
    }
    public boolean wasEatenFood(){
        if(whetherEatenFood)
            return true;
          else
            return false;     
    }
     public boolean wasEatenShell(){
        if(whetherEatenShell)
            return true;
          else
            return false;     
    }
      public boolean wasEatenAcceleration(){
        if(whetherEatenAcceleration)
            return true;
          else
            return false;     
    }
}
