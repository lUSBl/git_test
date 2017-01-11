/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

/**
 *
 * @author John
 */
public class OneShot {
 public static int NUMBEROFSHELLS = 0;
 
 
    private Field field;
    private Snake snake;
    private int x;
    private int y;
    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
   
    public OneShot(Field field, Snake snake, String direction) {
        this.field = field;
        this.snake = snake;
        if (direction.equals("right")) {
            right = true;
        } else if (direction.equals("left")) {
            left = true;
        } else if (direction.equals("up")) {
            up = true;
        } else if (direction.equals("down")) {
            down = true;
        }
        //Определяем координаты снаряды ориентируясь на местонахождение головы змеи
        determineTheLocationXOfTheProjectile();
        determineTheLocationYOfTheProjectile();
        contactWithTheBoundary();
        if (left) {
            if (field.matrix[y][x - 1] == 2) {
                withFoodCollision();
            }
            if (field.matrix[y][x - 1] == 7) {
                withFoodCollision();

            }
            x = x - 1;
        } else if (right) {
            if (field.matrix[y][x + 1] == 2) {
                withFoodCollision();
            } else if (field.matrix[y][x + 1] == 7) {
                withFoodCollision();

            }
            x = x + 1;
        } else if (up) {
            if (field.matrix[y - 1][x] == 2) {
                withFoodCollision();
            } else if (field.matrix[y - 1][x] == 7) {
                withFoodCollision();

            }
            y = y - 1;
        } else if (down) {
            if (field.matrix[y + 1][x] == 2) {
                withFoodCollision();
            } else if (field.matrix[y + 1][x] == 7) {
                withFoodCollision();

            }
            y = y + 1;
        }
    }
    private int coordinatedOfTheProjectileMotion[] = new int[8]; // в 1 ячейку записываются коорд. y, во вторую - x; Потому и массив состоит из 8 ячеек

    public void recordTheCoordinatesOfTheProjectileMotion(int count) {
        coordinatedOfTheProjectileMotion[count] = y;
        coordinatedOfTheProjectileMotion[count + 1] = x;

    }
    //Взрыв снаряда при столкновении

    public void theCollisionOfTheProjectileExplosion() {

        for (int i = 0; i < coordinatedOfTheProjectileMotion.length; i = i + 2) {
            int y = coordinatedOfTheProjectileMotion[i];
            int x = coordinatedOfTheProjectileMotion[i + 1];
            System.out.println(y + " " + x);
            field.matrix[y][x] = 0;
        }

        field.matrix[y][x] = 5;
        field.printOnAConsole();
    }
    //цикл жизни снаряда
    int lifeTimeOfShell = 40; // Около 10 секунд жизни каждого снаряда
    int currentTimeOfTheProjectile = 0;
    
    public void projectileMotionLife(){
          currentTimeOfTheProjectile++;
    }
    public boolean lifeCycleOfShell() {
        if (currentTimeOfTheProjectile != lifeTimeOfShell) {
            return true;
        } else {
            return false;
        }
    }

    //Столкновение с едой
    public void withFoodCollision() {
        for (int i = 0; i < snake.foods.length; i++) {
            if (left) {
                if (y == snake.foods[i][0] && x - 1 == snake.foods[i][1]) {
                    snake.shellHitsTheFoodOrBonusFood(i, y, x - 1);
                }
            }
            if (right) {
                if (y == snake.foods[i][0] && x + 1 == snake.foods[i][1]) {
                    snake.shellHitsTheFoodOrBonusFood(i, y, x + 1);
                }
            }
            if (up) {
                if (y - 1 == snake.foods[i][0] && x == snake.foods[i][1]) {
                    snake.shellHitsTheFoodOrBonusFood(i, y - 1, x);
                }
            }
            if (down) {
                if (y + 1 == snake.foods[i][0] && x == snake.foods[i][1]) {
                    snake.shellHitsTheFoodOrBonusFood(i, y + 1, x);
                }
            }
        }

    }

    public void collisionWithPartOfTheSnake() {

        for (int i = 0; i < snake.theNumberOfPart; i++) {
            if (left) {
                if (snake.cordinatesOfPartsOfTheSnake[i][0][0] == y && snake.cordinatesOfPartsOfTheSnake[i][0][1] == x - 1) {
                    snake.shellHitsThePartOfTheSnake(i);
                }
            } else if (right) {
                if (snake.cordinatesOfPartsOfTheSnake[i][0][0] == y && snake.cordinatesOfPartsOfTheSnake[i][0][1] == x + 1) {
                    snake.shellHitsThePartOfTheSnake(i);
                }
            } else if (up) {

                if (snake.cordinatesOfPartsOfTheSnake[i][0][0] == y - 1 && snake.cordinatesOfPartsOfTheSnake[i][0][1] == x) {
                    snake.shellHitsThePartOfTheSnake(i);
                }
            } else if (down) {

                if (snake.cordinatesOfPartsOfTheSnake[i][0][0] == y + 1 && snake.cordinatesOfPartsOfTheSnake[i][0][1] == x) {
                    snake.shellHitsThePartOfTheSnake(i);
                }
            }
        }
    }
    //столкновение с любым объектом

    public boolean collisionWithAnyObject() {
        if (left && x != 0) {
            if (field.matrix[y][x - 1] != 0) {
                if (field.matrix[y][x - 1] == 2) {
                    withFoodCollision();
                } else if (field.matrix[y][x - 1] == 7) {
                    withFoodCollision();
                } else if (field.matrix[y][x - 1] == 1 || field.matrix[y][x - 1] == 4) {
                    collisionWithPartOfTheSnake();
                }
                return false;
            }
        }
        if (right && x != Field.height - 1) {
            if (field.matrix[y][x + 1] != 0) {
                if (field.matrix[y][x + 1] == 2) {
                    withFoodCollision();
                } else if (field.matrix[y][x + 1] == 7) {
                    withFoodCollision();
                } else if (field.matrix[y][x + 1] == 1 || field.matrix[y][x - 1] == 4) {
                    collisionWithPartOfTheSnake();
                }
                return false;
            }
        }
        if (up && y != 0) {
            if (field.matrix[y - 1][x] != 0) {
                if (field.matrix[y - 1][x] == 2) {
                    withFoodCollision();
                } else if (field.matrix[y - 1][x] == 7) {
                    withFoodCollision();
                } else if (field.matrix[y - 1][x] == 1 || field.matrix[y - 1][x] == 4) {
                    collisionWithPartOfTheSnake();
                }
                return false;
            }
        }
        if (down && y != Field.weight - 1) {
            if (field.matrix[y + 1][x] != 0) {
                if (field.matrix[y + 1][x] == 2) {
                    withFoodCollision();
                } else if (field.matrix[y + 1][x] == 7) {
                    withFoodCollision();
                } else if (field.matrix[y + 1][x] == 1 || field.matrix[y + 1][x] == 4) {
                    collisionWithPartOfTheSnake();
                }
                return false;
            }
        }
        return true;
    }

    //Движение снаряда
    public void projectileMotion() {
        collisionWithAnyObject();
        contactWithTheBoundary();
        if (right) {
            x = x + 1;
        } else if (left) {
            x = x - 1;
        } else if (up) {
            y = y - 1;
        } else if (down) {
            y = y + 1;
        }
    }
    boolean access = false;

    private void contactWithTheBoundary() {
        if (right) {
            if (x >= Field.height - 1) {
                x = 0;
            }
        } else if (left) {
            if (x < 1) {
                x = Field.height - 1;
            }
        } else if (up) {
            if (y < 1) {
                y = Field.weight - 1;
            }
        } else if (down) {
            if (y > Field.weight - 2) {
                y = 0;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void determineTheLocationXOfTheProjectile() {
        x = snake.cordinatesOfPartsOfTheSnake[0][0][1];
    }

    private void determineTheLocationYOfTheProjectile() {
        y = snake.cordinatesOfPartsOfTheSnake[0][0][0];
    }
}
