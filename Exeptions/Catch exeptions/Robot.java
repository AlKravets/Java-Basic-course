public class Robot {
    private int x =0;
    private int y =0 ;
    private Direction direction = Direction.UP;
    

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            default:
                break;
        }
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        switch (direction) {
            case UP:
                ++y;
                break;
            case DOWN:
                --y;
                break;
            case LEFT:
                --x;
                break;
            case RIGHT:
                ++x;
                break;
            default:
                break;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        switch (robot.getDirection()) {
            case UP:
                break;
            case DOWN:
                robot.turnLeft();
                robot.turnLeft();
                break;
            case LEFT:
                robot.turnRight();
                break;
            case RIGHT:
                robot.turnLeft();
                break;
            default:
                break;        
        }
        
        int ySteps = toY - robot.getY();
        if (ySteps < 0){
            robot.turnLeft();
            robot.turnLeft();
        }
        for (int i = 0; i < Math.abs(ySteps); ++i){
            robot.stepForward();
        }
        if (ySteps < 0){
            robot.turnLeft();
            robot.turnLeft();
        }

        
        int xSteps = toX - robot.getX();
        if (xSteps > 0){
            robot.turnRight();
        } else{
            robot.turnLeft();
        }
        for (int i = 0; i < Math.abs(xSteps); ++i){
            robot.stepForward();
        }
    }
}


// variant from comments
// public static void moveRobot(Robot robot, int toX, int toY) {
//     int dx = robot.getX() - toX, dy = robot.getY() - toY;
    
//     Direction dirX = dx > 0 ? Direction.LEFT : Direction.RIGHT;
//     Direction dirY = dy > 0 ? Direction.DOWN : Direction.UP;
    
//     dx = Math.abs(dx);
//     dy = Math.abs(dy);
    
//     while (robot.getDirection() != dirX) robot.turnRight();
//     while (dx-- > 0) robot.stepForward();
    
//     while (robot.getDirection() != dirY) robot.turnRight();
//     while (dy-- > 0) robot.stepForward();
// }