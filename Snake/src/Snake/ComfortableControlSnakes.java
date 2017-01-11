/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class ComfortableControlSnakes extends Thread {

    private KeyBoardObeserver key;
    Snake snake;

    ComfortableControlSnakes(KeyBoardObeserver key, Snake snake) {
        this.key = key;
        this.snake = snake;
    }

    public void on() {
        start();
    }

    @Override
    public void run() {
        while (true) {
            if (key.hasKeyEvents()) {
                KeyEvent event = key.getEventFromTop();
                 try {
                if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!snake.right) {
                         snake.ofCapsLock();
                        snake.left();
                        Thread.sleep(250);
                    }

                } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!snake.left) {
                         snake.ofCapsLock();
                        snake.right();
                        
                            Thread.sleep(250);
                       
                    }
                } else if (event.getKeyCode() == KeyEvent.VK_UP) {
                    if (!snake.down) {
                         snake.ofCapsLock();
                        snake.up();
                        Thread.sleep(250);
                    }
                } else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                     
                    if (!snake.up) {
                        snake.ofCapsLock();
                        snake.down();
                        Thread.sleep(250);
                    }
                } else if (event.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
                    if(StockAcceleration.STOCKACCELERATION > 0)
                   snake.capsLock();
                  
                }else if (event.getKeyCode() == KeyEvent.VK_Q) {
                    if(OneShot.NUMBEROFSHELLS != 0){
                        OneShot.NUMBEROFSHELLS--;
                    snake.oneShot();
                    }
                 
                  
                }
                 } catch (InterruptedException ex) {
                            Logger.getLogger(ComfortableControlSnakes.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
        }
    }
}
