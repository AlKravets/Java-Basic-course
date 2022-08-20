public class Main{
    public static void main(String [] args) {
        // Robot r = new Robot();
        // Robot.moveRobot(r, -2, 3);
        // System.out.println(r.getX() + " , " + r.getY());
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        for (int i=0; i< 3; ++i){
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()){
                robotConnection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException ex){
                if (i ==2){
                    throw ex;
                }
            }
        }

    }
}

/*
 * Я кажется поняла почему решение try with resourses с break не проходит. Наша программа выдает неверный результат в случае, если первые две попытки выполнить задание провалились, а с третий попытки все удалось, но случилась ошибка закрытия: в третьем проходе, если все прошло успешно, но случилась ошибка закрытия, то в случае с finally она будет заглушена в блоке finally , а в try с ресурсами она будет передана в блок catch, и если мы используем break, то значение счетчика на момент входа  в блок catch будет i == 2, что заставит блок catch бросить исключение (хотя оно было вызвано методом close и мы должны были его игнорировать), а если мы явно присваиваем i = 3, то условие дальнейшего проброса ошибки блоком catch не выполняется
 * 
 */