/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class SecondThreadForShells implements Runnable {

    Snake snake;
    
    public SecondThreadForShells(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void run() {
        int count = -2;
        boolean canDeleteShot = false;
        while (true) {
           
            for (int i = 0; i < snake.manyShots.size(); i++) {
                OneShot shot = snake.manyShots.get(i);
                for (int ii = 0; ii < 4; ii++) {  //этот цикл для того, чтобы снаряд летел быстрее в четыре раза, чем сама змейка
                    if (shot.collisionWithAnyObject() && shot.lifeCycleOfShell()) {
                        shot.projectileMotion();
                        count = count + 2;
                        shot.recordTheCoordinatesOfTheProjectileMotion(count); 
                    } else {
                        canDeleteShot = true;
                        break;
                    }
                }
                shot.projectileMotionLife();
                count = -2;
                if (canDeleteShot){
                    snake.manyShots.remove(i);
                    canDeleteShot = false;
                    shot.theCollisionOfTheProjectileExplosion();
                }
            }
            if (snake.manyShots.size() == 0) {
                Field.isSecondThreadForShellsExist = false;
                break;
            }
            try {
                Thread.sleep(275);
            } catch (InterruptedException ex) {
                Logger.getLogger(SecondThreadForShells.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
