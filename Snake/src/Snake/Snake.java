/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class Snake {

    private Field field;
    private int y;
    private int x;
    public boolean right = false;
    public boolean left = false;
    public boolean up = false;
    public boolean down = false;
    public int cordinatesOfPartsOfTheSnake[][][];
    public int theNumberOfPart = 5;
    public static int nagrada = 0;
    public ArrayList<OneShot> manyShots = new ArrayList<OneShot>();
    Thread t;

    public Snake(int y, int x, Field field, boolean up, boolean right, boolean left, boolean down) {
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
        this.field = field;
        this.y = y;
        this.x = x;
        cordinatesOfPartsOfTheSnake = new int[field.matrix.length * field.matrix[0].length + 1][1][2];
        t = new Thread(new StockAcceleration());
        t.start();

    }

    public int freeLineOnTheMatrixAmongTheWalls() {
        Random rnd = new Random();
        int count = 0;
        int count2 = 0;
        if (left) {
            count = rnd.nextInt(field.matrix.length);
            for (int i = count; i > 0; i--) {
                for (int ii = 0; ii < field.matrix[0].length; ii++) {
                    if (field.matrix[i][ii] == 0) {
                        count2++;
                    }
                }
                if (count2 != field.matrix[i].length) {
                    count2 = 0;
                } else {
                    return i;
                }
            }
            count2 = 0;
            for (int i = field.matrix.length - 1; i > count; i--) {
                for (int ii = 0; ii < field.matrix[0].length; ii++) {
                    if (field.matrix[i][ii] == 0) {
                        count2++;
                    }
                }
                if (count2 != field.matrix[i].length) {
                    count2 = 0;
                } else {
                    return i;
                }
            }
            left = false;
            up = true;
        } else if (up) {              ///////////////////////
            count = rnd.nextInt(field.matrix[0].length);
            for (int i = count; i >= 0; i--) {
                for (int ii = 0; ii < field.matrix.length; ii++) {
                    if (field.matrix[ii][i] == 0) {
                        count2++;
                    }
                }
                if (count2 != field.matrix.length) {
                    count2 = 0;

                } else {
                    return i;
                }
            }
            count2 = 0;
            for (int i = field.matrix.length - 1; i >= count; i--) {
                for (int ii = 0; ii < field.matrix[0].length; ii++) {
                    if (field.matrix[i][ii] == 0) {
                        count2++;
                    }
                }
                if (count2 != field.matrix[i].length) {
                    count2 = 0;

                } else {
                    return i;
                }
            }
        }
        return 0;
    }

    public void defaultInitializationSnake() {

        int count = freeLineOnTheMatrixAmongTheWalls();

        for (int i = 0; i < theNumberOfPart; i++) {
            if (left) {
                y = count;
                directionHeadOfTheSnake = "left";
                cordinatesOfPartsOfTheSnake[i][0][0] = y;
                cordinatesOfPartsOfTheSnake[i][0][1] = x + i;
            }
            if (up) {
                x = count;
                directionHeadOfTheSnake = "up";
                cordinatesOfPartsOfTheSnake[i][0][0] = y + i;
                cordinatesOfPartsOfTheSnake[i][0][1] = x;
            }
        }
    }
    private boolean bonusShellFind = false;

    public boolean shellWasFind() {
        if (bonusShellFind) {
            bonusShellFind = false;
            return true;
        } else {
            return false;
        }
    }
    private boolean bonusAccelerationFind = false;

    public boolean accelerationWasFind() {
        if (bonusAccelerationFind) {
            bonusAccelerationFind = false;
            return true;
        } else {
            return false;
        }
    }
    public boolean bonusFoodOrNot = false;
    public boolean bonusShellOrNot = false;
    public boolean bonusAccelerationOrNot = false;
    public int numberOfBonusFood = -1;
    public int numberOfBonusShell = -1;
    public int numberOfBonusAcceleration = -1;

    public void printLocationSnake(SnakeFood food) {

        if (food.wasEatenFood() || food.wasEatenShell() || food.wasEatenAcceleration()) {
            foods[theNumberOfFoodWhichWasEaten][0] = 0;
            foods[theNumberOfFoodWhichWasEaten][1] = 0;
        }

        Random r = new Random();
        int chanceOfBonusFood = 0;
        int count = 0;
        while (true) {
            if ((chanceOfBonusFood = r.nextInt(500)) > 45 && chanceOfBonusFood < 95 && bonusFoodOrNot == false) {

                bonusFoodOrNot = true;
                accessBonusFood = true;
            }
            if ((chanceOfBonusFood = r.nextInt(500)) > 145 && chanceOfBonusFood < 195 && bonusShellOrNot == false) {

                bonusShellOrNot = true;
                accessBonusShell = true;
            }
            if ((chanceOfBonusFood = r.nextInt(500)) > 245 && chanceOfBonusFood < 295 && bonusAccelerationOrNot == false) {

                bonusAccelerationOrNot = true;
                accessBonusAcceleration = true;
            }
            food.determineTheLocationOfTheFood();
            int countY = food.getLocationY();
            int countX = food.getLocationX();
            for (int i = 0; i < theNumberOfPart; i++) {
                if (cordinatesOfPartsOfTheSnake[i][0][1] != countX || cordinatesOfPartsOfTheSnake[i][0][0] != countY) {
                    count++;
                }
            }
            if (field.matrix[countY][countX] == 4 || field.matrix[countY][countX] == 3 || field.matrix[countY][countX] == 2) {
                count = 0;
            }
            if (count == theNumberOfPart) {

                introductionOfFoodLocations(countY, countX);

                howMuchNowFoods++;
                if (howMuchNowFoods == howMuchFoods) {
                    break;
                }
            }
            count = 0;
        }
    }
    private int howMuchNowFoods;
    private int howMuchFoods = 15;
    private boolean accessBonusFood = true;
    private boolean accessBonusShell = true;
    private boolean accessBonusAcceleration = true;
    public int foods[][] = new int[howMuchFoods][howMuchFoods];

    private void introductionOfFoodLocations(int foodY, int foodX) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i][0] == 0) {
                foods[i][0] = foodY;
                foods[i][1] = foodX;
                if (bonusFoodOrNot && accessBonusFood) {
                    numberOfBonusFood = i;
                    accessBonusFood = false;
                }
                if (bonusShellOrNot && accessBonusShell) {
                    numberOfBonusShell = i;
                    accessBonusShell = false;
                }
                if (bonusAccelerationOrNot && accessBonusAcceleration) {
                    numberOfBonusAcceleration = i;
                    accessBonusAcceleration = false;
                }
                break;
            }
        }
    }
    private int theNumberOfFoodWhichWasEaten = 1;
    public boolean shellHit = false;
    private int FoodWasEatenFromShell = 0;
    private int Yshell = -1;
    private int Xshell = -1;

    public void shellHitsTheFoodOrBonusFood(int FoodWasEatenFromShell, int Yshell, int Xshell) {
        shellHit = true;
        this.FoodWasEatenFromShell = FoodWasEatenFromShell;
        this.Yshell = Yshell;
        this.Xshell = Xshell;
    }

    public void findingFoodSnake(SnakeFood food) {
        for (int i = 0; i < foods.length; i++) {
            if (shellHit
                    && coordinateOfFoodY()[i][0] == Yshell
                    && coordinateOfFoodY()[i][1] == Xshell
                    || coordinateOfFoodY()[i][0] == cordinatesOfPartsOfTheSnake[0][0][0]
                    && coordinateOfFoodX()[i][1] == cordinatesOfPartsOfTheSnake[0][0][1]) {
                if (bonusFoodOrNot
                        && i == numberOfBonusFood
                        && coordinateOfFoodY()[numberOfBonusFood][0] == cordinatesOfPartsOfTheSnake[0][0][0]
                        && coordinateOfFoodX()[numberOfBonusFood][1] == cordinatesOfPartsOfTheSnake[0][0][1]
                        || bonusFoodOrNot && i == numberOfBonusFood
                        && coordinateOfFoodY()[i][0] == Yshell
                        && coordinateOfFoodX()[i][1] == Xshell) {

                    antiZeroScore = antiZeroScore + 10;
                    introductionCoordinates();
                    food.eatFood();
                    theNumberOfFoodWhichWasEaten = numberOfBonusFood;
                    nagrada += 100;
                    bonusFoodOrNot = false;
                    howMuchNowFoods--;
                    continue;
                }
                if (bonusShellOrNot
                        && i == numberOfBonusShell
                        && coordinateOfFoodY()[numberOfBonusShell][0] == cordinatesOfPartsOfTheSnake[0][0][0]
                        && coordinateOfFoodX()[numberOfBonusShell][1] == cordinatesOfPartsOfTheSnake[0][0][1]
                        || bonusShellOrNot && i == numberOfBonusShell
                        && coordinateOfFoodY()[i][0] == Yshell
                        && coordinateOfFoodX()[i][1] == Xshell) {

                    food.eatShell();
                    theNumberOfFoodWhichWasEaten = numberOfBonusShell;
                    OneShot.NUMBEROFSHELLS += 20;
                    nagrada += 50;
                    bonusShellOrNot = false;
                    howMuchNowFoods--;
                    continue;
                }
                if (bonusAccelerationOrNot
                        && i == numberOfBonusAcceleration
                        && coordinateOfFoodY()[numberOfBonusAcceleration][0] == cordinatesOfPartsOfTheSnake[0][0][0]
                        && coordinateOfFoodX()[numberOfBonusAcceleration][1] == cordinatesOfPartsOfTheSnake[0][0][1]
                        || bonusAccelerationOrNot
                        && i == numberOfBonusAcceleration
                        && coordinateOfFoodY()[i][0] == Yshell
                        && coordinateOfFoodX()[i][1] == Xshell) {

                    food.eatAcceleration();
                    theNumberOfFoodWhichWasEaten = numberOfBonusAcceleration;

                    StockAcceleration.ALLSTOCKACCELERATION += 200;
                    nagrada += 50;
                    bonusAccelerationOrNot = false;
                    howMuchNowFoods--;
                    continue;
                }
                theNumberOfPart++;
                howMuchNowFoods--;
                introductionCoordinates();
                food.eatFood();
                if (!shellHit) {
                    theNumberOfFoodWhichWasEaten = i;
                } else {
                    theNumberOfFoodWhichWasEaten = FoodWasEatenFromShell;
                }
                nagrada += 10;
                if (shellHit) {
                    shellHit = false;
                }
            }
        }
    }
    private int antiZeroScore = 0;

    public void introductionCoordinates() {
        if (antiZeroScore != 0) {
            theNumberOfPart++;
            antiZeroScore--;
        }
        int countA = theNumberOfPart - 2;
        int countB = theNumberOfPart - 1;
        for (int i = 0; i < theNumberOfPart - 1; i++) {
            cordinatesOfPartsOfTheSnake[countB][0][0] = cordinatesOfPartsOfTheSnake[countA][0][0];
            cordinatesOfPartsOfTheSnake[countB][0][1] = cordinatesOfPartsOfTheSnake[countA][0][1];
            countA--;
            countB--;
        }
        cordinatesOfPartsOfTheSnake[0][0][0] = y;
        cordinatesOfPartsOfTheSnake[0][0][1] = x;
    }

    private void snakeBlinking(int partOfSnake) {
        boolean access = true;
        int count = 0;
        while (true) {
            for (int i = 1; i < theNumberOfPart; i++) {
                if (access) {
                    field.matrix[cordinatesOfPartsOfTheSnake[i][0][0]][cordinatesOfPartsOfTheSnake[i][0][1]] = 6;
                } else {
                    field.matrix[cordinatesOfPartsOfTheSnake[i][0][0]][cordinatesOfPartsOfTheSnake[i][0][1]] = 1;
                }
            }
            field.printOnAConsole();
            if (access) {
                access = false;
            } else {
                access = true;
            }
            try {
                Thread.sleep(210);
            } catch (InterruptedException ex) {
            }
            count++;
            if (count == 1) {
                field.matrix[cordinatesOfPartsOfTheSnake[theNumberOfPart][0][0]][cordinatesOfPartsOfTheSnake[theNumberOfPart][0][1]] = 0;
                theNumberOfPart--;
                count = 0;
            }

            if (theNumberOfPart == partOfSnake) {
                break;
            }
        }
    }
    private boolean hitProjectileIntoThePartOftheSnake = false;
    private int partOfTheSnake;

    public void shellHitsThePartOfTheSnake(int partOfTheSnake) {
        this.partOfTheSnake = partOfTheSnake;
        hitProjectileIntoThePartOftheSnake = true;
    }

    public void killedAboutHimself() {
        boolean access = false;
        boolean accessShell = false;
        int allLengthSnake = theNumberOfPart;

        if (hitProjectileIntoThePartOftheSnake == false) {
            for (int i = 1; i < theNumberOfPart; i++) {
                if (cordinatesOfPartsOfTheSnake[i][0][0] == cordinatesOfPartsOfTheSnake[0][0][0] && cordinatesOfPartsOfTheSnake[i][0][1] == cordinatesOfPartsOfTheSnake[0][0][1]) {
                    for (int w = 0; w < foods.length; w++) {
                        if (cordinatesOfPartsOfTheSnake[0][0][0] == coordinateOfFoodY()[w][0] && cordinatesOfPartsOfTheSnake[0][0][1] == coordinateOfFoodX()[w][1]) {
                            access = true;
                        }
                        if (Yshell == coordinateOfFoodY()[w][0] && Xshell == coordinateOfFoodX()[w][1]) {
                            accessShell = true;
                        }
                    }
                    if (access || accessShell) {
                        continue;
                    }

                    snakeBlinking(i);
                    if (nagrada >= (allLengthSnake - i) * 10) {
                        nagrada = nagrada - (allLengthSnake - i) * 10;
                    } else if (nagrada <= (allLengthSnake - i) * 10) {
                        nagrada = 0;
                    }

                    access = false;
                    accessShell = false;
                }
            }
        } else if (hitProjectileIntoThePartOftheSnake) {
            snakeBlinking(partOfTheSnake);
            hitProjectileIntoThePartOftheSnake = false;
            if (nagrada >= (allLengthSnake - partOfTheSnake) * 10) {
                nagrada = nagrada - (allLengthSnake - partOfTheSnake) * 10;
            } else if (nagrada <= (allLengthSnake - partOfTheSnake) * 10) {
                nagrada = 0;
            }
        }

    }
    private String directionHeadOfTheSnake;

    public void snakeMovementAbroad() throws InterruptedException {
        try {
            //Ждем когда вылетит ошибка и перехватываем ее!
            field.matrix[cordinatesOfPartsOfTheSnake[0][0][0]][cordinatesOfPartsOfTheSnake[0][0][1]] = 1;
        } catch (Exception e) {

            if (right) {

                x = 0;
                cordinatesOfPartsOfTheSnake[0][0][1] = x;

            }
            if (left) {

                x = field.matrix[0].length - 1;
                cordinatesOfPartsOfTheSnake[0][0][1] = x;
            }
            if (up) {

                y = field.matrix.length - 1;
                cordinatesOfPartsOfTheSnake[0][0][0] = y;
            }
            if (down) {

                y = 0;
                cordinatesOfPartsOfTheSnake[0][0][0] = y;
            }
        }
    }

    public void oneShot() {
        if (directionHeadOfTheSnake != null) {
            manyShots.add(new OneShot(field, this, directionHeadOfTheSnake));


        }
    }

    public int[][] coordinateOfFoodY() {
        return foods;
    }

    public int[][] coordinateOfFoodX() {
        return foods;
    }

    public void step() {
        if (right && !left && !up && !down) {

            if (!caps) {
                Run.t = 245;
            }
            x++;
        } else if (!right && left && !up && !down) {

            if (!caps) {
                Run.t = 245;
            }
            x--;
        } else if (!right && !left && up && !down) {

            if (!caps) {
                Run.t = 270;
            }
            y--;
        } else if (!right && !left && !up && down) {

            if (!caps) {
                Run.t = 270;
            }
            y++;
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void up() {
        directionHeadOfTheSnake = "up";
        up = true;
        down = false;
        left = false;
        right = false;
    }

    public void down() {
        directionHeadOfTheSnake = "down";
        down = true;
        up = false;
        left = false;
        right = false;
    }

    public void left() {
        directionHeadOfTheSnake = "left";
        left = true;
        right = false;
        up = false;
        down = false;
    }

    public void right() {
        directionHeadOfTheSnake = "right";
        right = true;
        left = false;
        up = false;
        down = false;
    }
    static public boolean caps = false;

    public void capsLock() {
        caps = !caps;
        Run.t = 100;
    }

    public static void ofCapsLock() {
        caps = false;
    }
}
