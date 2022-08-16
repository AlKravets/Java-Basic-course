public class Main{
    public static void main(String [] args) {
        Robot r = new Robot();
        Robot.moveRobot(r, -2, 3);
        System.out.println(r.getX() + " , " + r.getY());
    }

}