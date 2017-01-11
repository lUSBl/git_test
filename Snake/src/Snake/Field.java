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
public class Field {

    public static int weight = 15;
    public static int height = 85;
    public final int[][] matrix = new int[weight][height];
    private Wall wall[];

    public void print(Snake snake, SnakeFood food) throws InterruptedException {
        cleanMatrix();

        if (wall == null) {
            printWalls();
        }
        for (int i = 0; i < maxWalls; i++) {
            wall[i].printWall();
        }

        if (food.wasEatenFood() || food.wasEatenShell() || food.wasEatenAcceleration()) {
            snake.printLocationSnake(food);
            snake.snakeMovementAbroad();
            snake.findingFoodSnake(food);
        } else {
            snake.snakeMovementAbroad();
            snake.findingFoodSnake(food);
            for (int i = 0; i < maxWalls; i++) {
                if (!wall[i].killedAboutWall(snake)) {
                    headsPainting();
                    break;
                }
            }

            snake.killedAboutHimself();
        }
        System.out.println("   Очки: " + snake.nagrada + "    Caps - ускорение;  $ - добавляет +100 очков и увеличивает червячка; Q - позволяет стрелять");
        introducingSnakeAndFoodsInMatrix(snake);

        printOnAConsole();

        if (head) {
            System.exit(0);
        }
    }

    public void printOnAConsole() {
        for (int i = 0; i < matrix.length; i++) {
            for (int ii = 0; ii < matrix[i].length; ii++) {
                if (matrix[i][ii] == 0) {
                    System.out.print(".");
                } else if (matrix[i][ii] == 1) {
                    System.out.print("o");
                } else if (matrix[i][ii] == 2) {
                    System.out.print("O");
                } else if (matrix[i][ii] == 3) {
                    System.out.print("@");
                } else if (matrix[i][ii] == 4) {
                    System.out.print("\u058D");
                } else if (matrix[i][ii] == 5) {
                    System.out.print("#");
                } else if (matrix[i][ii] == 6) {
                    System.out.print("O");
                } else if (matrix[i][ii] == 7) {
                    System.out.print("$");
                } else if (matrix[i][ii] == 8) {
                    System.out.print("*");
                } else if (matrix[i][ii] == 9) {
                    System.out.print(">");
                }
            }
            if (i == 5) {
                System.out.print("   Запас ускорения: " + StockAcceleration.STOCKACCELERATION + "  (Caps Lock)");
            }
            if (i == 7) {
                System.out.print("    Запас снарядов: " + OneShot.NUMBEROFSHELLS + "  (Q)");
            }

            System.out.println("");
        }
    }
    boolean head = false;

    private void headsPainting() {
        head = true;
    }
    private int maxWalls = 18;

    public void printWalls() {
        boolean access = false;
        Random rnd = new Random();
        int count = 1;

        while (true) {
            count = rnd.nextInt(4);
            if (count != 0) {
                break;
            }
        }
        wall = new Wall[maxWalls];
        int canNotInsertWallCount = 0;
        int count4 = 0;
        boolean access2 = true;
        for (int i = 0; i < maxWalls; i++) {
            int count2 = rnd.nextInt(2);
            wall[i] = WallFactory.createWall(this, count2);
            if (i != 0) {
                if (Wall.isWallOnAnotherWall(wall, i + 1) == false) {

                    if (access2) {
                        count4 = i;
                        access = false;
                    }
                    if (count4 == i) {
                        canNotInsertWallCount++;
                    } else if (count4 != i) {
                        canNotInsertWallCount = 0;
                        access = true;
                    }

                    if (canNotInsertWallCount > 100) {
                        i = 0;
                        canNotInsertWallCount = 0;
                    }
                    i--;
                }
            }
        }
    }

    public void cleanMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int ii = 0; ii < matrix[i].length; ii++) {
                matrix[i][ii] = 0;
            }
        }
    }
    private boolean DefaultInitialize = false;
    public static boolean isSecondThreadForShellsExist = false;

    public void introducingSnakeAndFoodsInMatrix(Snake snake) {
        //Как только игра запустилась, вычисляется изначальное положение змейки
        if (!DefaultInitialize) {
            snake.defaultInitializationSnake();

            DefaultInitialize = true;
        }

        //При ударе об стенку, голова змейки меняется
        if (!head) {
            matrix[snake.cordinatesOfPartsOfTheSnake[0][0][0]][snake.cordinatesOfPartsOfTheSnake[0][0][1]] = 4;
        } else {
            matrix[snake.cordinatesOfPartsOfTheSnake[0][0][0]][snake.cordinatesOfPartsOfTheSnake[0][0][1]] = 5;
        }

        //Змейка внедряется в поле
        for (int i = 1; i < snake.theNumberOfPart; i++) {
            if (snake.cordinatesOfPartsOfTheSnake[i][0][0] != -1 && snake.cordinatesOfPartsOfTheSnake[i][0][1] != -1 && snake.cordinatesOfPartsOfTheSnake[i][0][0] != weight && snake.cordinatesOfPartsOfTheSnake[i][0][1] != height) {
                matrix[snake.cordinatesOfPartsOfTheSnake[i][0][0]][snake.cordinatesOfPartsOfTheSnake[i][0][1]] = 1;
            }
        }
        //Добавляем еду на поле
        for (int i = 0; i < snake.foods.length; i++) {

            if (snake.bonusFoodOrNot && i == snake.numberOfBonusFood) {

                matrix[snake.coordinateOfFoodY()[i][0]][snake.coordinateOfFoodX()[i][1]] = 7;
                continue;
            }
            if (snake.bonusShellOrNot && i == snake.numberOfBonusShell) {

                matrix[snake.coordinateOfFoodY()[i][0]][snake.coordinateOfFoodX()[i][1]] = 8;
                continue;
            }
            if (snake.bonusAccelerationOrNot && i == snake.numberOfBonusAcceleration) {

                matrix[snake.coordinateOfFoodY()[i][0]][snake.coordinateOfFoodX()[i][1]] = 9;
                continue;
            }
            matrix[snake.coordinateOfFoodY()[i][0]][snake.coordinateOfFoodX()[i][1]] = 2;
        }

        if (snake.manyShots.size() != 0) {
            if (isSecondThreadForShellsExist == false) {
                Thread secondThreadForShells = new Thread(new SecondThreadForShells(snake));

                secondThreadForShells.start();
                isSecondThreadForShellsExist = true;
            }
            for (int i = 0; i < snake.manyShots.size(); i++) {
                OneShot shot = snake.manyShots.get(i);
                matrix[shot.getY()][shot.getX()] = 8;
            }
        }
    }
}
