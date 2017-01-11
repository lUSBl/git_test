/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

/**
 *
 * @author John
 */
public class Wall {

    private int positionX;
    private int positionY;
    Field field;
    private int wall[][];

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public boolean killedAboutWall(Snake snake) {
        for (int i = 0; i < wall.length; i++) {
            for (int ii = 0; ii < wall[0].length; ii++) {
                if (snake.cordinatesOfPartsOfTheSnake[0][0][0] == getPositionX() + i && snake.cordinatesOfPartsOfTheSnake[0][0][1] == getPositionY() + ii) {
                  return false;
                }
            }
        }
        return true;
    }

    public int getPositionY() {
        return positionY;
    }

    public Wall(Field field, int wall[][], int positionX, int positionY) {
        this.field = field;
        this.wall = wall;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static boolean isWallOnAnotherWall(Wall wall[], int numb) {
        int count = 0;
        int count2 = 1;
        int Mcount = 0;
        boolean x = true;
        boolean y = true;
        boolean access = true;

        while (true) {
            for (int i = 0; i < numb; i++) {
                for (int ii = i + 1; ii < numb; ii++) {
                    for (int iii = 0; iii < 4; iii++) {
                        for (int iiii = 0; iiii < 4; iiii++) {
                            if (access == true) {
                                if (wall[i].getPositionY() + iii == wall[ii].getPositionY() + iiii) {
                                    count++;
                                }
                                x = false;
                            } else {
                                if (i == 5  ) {
                                    if (wall[i].getPositionX() + iii == wall[ii].getPositionX() + iiii) {
                                        count++;
                                    }
                                    y = false;
                                }
                            }
                        }
                    }
                }
            }

            if (count != 0) {
                return false;
            } else {
                Mcount++;
                count = 0;
                access = false;
            }
            if (Mcount == 2) {
                break;
            }

            if (x == false && y == false) {
                break;
            }
        }
        return true;

    }

    public void printWall() {
        for (int i = 0; i < wall.length; i++) {
            for (int ii = 0; ii < wall[0].length; ii++) {
                field.matrix[positionX + i][positionY + ii] = wall[i][ii];
            }
        }
    }
}
