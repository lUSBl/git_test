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
public class WallFactory {

    private static int wall[][][] = {{{3, 3, 3},    //QQQ
                                      {3, 3, 3} },  //QQQ
                                                    //QQQ

           {{3, 3}, //QQ
            {3, 3}, //QQ
            {3, 3}  //QQ
        }};

    public static Wall createWall(Field field, int horizontVertical) {
        int positionWallX;
        int positionWallY;
        int count = 0;
        Random r = new Random();
        if (horizontVertical == 0) { //horizont
            while (true) {
               
                if ((positionWallX = r.nextInt(field.matrix.length-4)) <= field.matrix.length - 4  && (positionWallY = r.nextInt(field.matrix[0].length-4)) <= field.matrix[0].length-4) {
                    for (int i = 1; i < 5; i++) {
                        if (field.matrix[positionWallX][positionWallY + i] == 0) {
                            count++;
                        }
                    }
                    if (count == 4) {
                        count = 0;
                        for (int ii = 1; ii < 5; ii++) {
                            if (field.matrix[positionWallX + 1][positionWallY + ii] == 0) {
                                count++;
                            }
                        }
                    }
                    if (count == 4) {                
                        return new Wall(field, wall[0], positionWallX, positionWallY);
                    }
                }
                count = 0;
            }
        } else {
            while (true) {
                if ((positionWallX = r.nextInt(field.matrix.length)) < field.matrix.length - 4 && positionWallX > 3 && (positionWallY = r.nextInt(field.matrix[0].length)) <= field.matrix[0].length-4 && positionWallY >= 3) {
                    for (int i = 1; i < 5; i++) {
                        if (field.matrix[positionWallX + i][positionWallY] == 0) {
                            count++;
                        }
                    }
                    if (count == 4) {
                        count = 0;
                        for (int ii = 1; ii < 5; ii++) {
                            if (field.matrix[positionWallX + ii][positionWallY + 1] == 0) {
                                count++;
                            }
                        }
                    }
                    if (count == 4) {
                        return new Wall(field, wall[1], positionWallX, positionWallY);
                    }
                }
                count = 0;
            }
        }
    }
}
