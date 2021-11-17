
class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {

        /*
            To get change in direction value in y & x directions.
         */
        int dX = toX - robot.getX();
        int dY = toY - robot.getY();

        /*
            To get number of steps to take in y & x directions.
         */
        int xDistance = Math.abs(dX);
        int yDistance = Math.abs(dY);


        if (dY >= 0 && dX > 0) {
            firstQuadrant(robot, xDistance, yDistance);
        }

        /*
            This section determines the quadrant which coordinate belongs to
            and calls appropriate method to handle Robot movement.
         */
        if (dY > 0 && dX <= 0) {
            secondQuadrant(robot, xDistance, yDistance);
        }

        if (dY <= 0 && dX < 0) {
            thirdQuadrant(robot, xDistance, yDistance);
        }

        if (dY < 0 && dX >= 0) {
            fourthQuadrant(robot, xDistance, yDistance);
        }
    }

    /*
        This method handles all coordinates that fall in the third quadrant.
     */
    private static void thirdQuadrant(Robot robot, int xDistance, int yDistance) {
        switch (robot.getDirection()) {
            case UP:
                robot.turnLeft();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                break;

            case DOWN:
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnRight();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            case LEFT:
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                break;

            case RIGHT:
                robot.turnRight();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnRight();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            default:
                throw new IllegalStateException();
        }
    }

    /*
        This method handles all coordinates that fall in the fourth quadrant.
    */
    private static void fourthQuadrant(Robot robot, int xDistance, int yDistance) {
        switch (robot.getDirection()) {
            case UP:
                robot.turnRight();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                robot.turnRight();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                break;

            case DOWN:
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            case LEFT:
                robot.turnLeft();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            case RIGHT:
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                robot.turnRight();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                break;

            default:
                throw new IllegalStateException();
        }
    }

    /*
        This method handles all coordinates that fall in the second quadrant.
    */
    private static void secondQuadrant(Robot robot, int xDistance, int yDistance) {
        switch (robot.getDirection()) {
            case UP:
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            case DOWN:
                robot.turnRight();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            case LEFT:
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                robot.turnRight();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                break;

            case RIGHT:
                robot.turnLeft();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            default:
                throw new IllegalStateException();
        }
    }

    /*
        This method handles all coordinates that fall in the first quadrant.
    */
    private static void firstQuadrant(Robot robot, int xDistance, int yDistance) {
        switch (robot.getDirection()) {
            case UP:
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnRight();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            case DOWN:
                robot.turnRight();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                break;

            case LEFT:
                robot.turnRight();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                robot.turnRight();
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                break;

            case RIGHT:
                for (int i = 1; i <= xDistance; i++) {
                    robot.stepForward();
                }
                robot.turnLeft();
                for (int j = 1; j <= yDistance; j++) {
                    robot.stepForward();
                }
                break;

            default:
                throw new IllegalStateException();
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}