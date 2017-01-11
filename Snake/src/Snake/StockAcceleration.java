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
public class StockAcceleration implements Runnable {

    public static int STOCKACCELERATION = 0;
    public static int ALLSTOCKACCELERATION = 0;

    @Override
    public void run() {

        while (true) {

            if (STOCKACCELERATION > 0 && Snake.caps == true) {
                STOCKACCELERATION--;
            }

            if (STOCKACCELERATION == 0 && ALLSTOCKACCELERATION == 0) {
                Snake.ofCapsLock();
            }
            if (STOCKACCELERATION == 0) {
                Snake.ofCapsLock();
            }
            if (ALLSTOCKACCELERATION > 0) {
                if (Snake.caps == false) {
                    STOCKACCELERATION++;
                    ALLSTOCKACCELERATION--;
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("Поток прерван!");
            }

        }

    }
}
