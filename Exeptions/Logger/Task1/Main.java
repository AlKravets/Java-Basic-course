/*
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:

Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
Не упомянутые здесь настройки изменяться не должны.

(*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.

Подсказки:

Level есть не только у Logger, но и у Handler.
Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
 */

import java.util.logging.*;

public class Main{
    public static void main(String [] args) {
        
    }
    
    private static void configureLogging() {
        // https://stackoverflow.com/questions/6307648/change-global-setting-for-logger-instances

        Logger classALogger = Logger.getLogger("org.stepic.java.logging.ClassA");
        Level newClassALevel = Level.ALL;
        classALogger.setLevel(newClassALevel);
        Handler[] classAHandlers = classALogger.getHandlers();
        for (Handler classAHandler : classAHandlers){
            classAHandler.setLevel(newClassALevel);
        }

        Logger classBLogger = Logger.getLogger("org.stepic.java.logging.ClassB");
        Level newClassBLevel = Level.WARNING;
        classBLogger.setLevel(newClassBLevel);
        Handler[] classBHandlers = classBLogger.getHandlers();
        for (Handler classBHandler : classBHandlers){
            classBHandler.setLevel(newClassBLevel);
        }

        Logger orgStepicJavaLogger = Logger.getLogger("org.stepic.java");
        Level orgStepicJavaLevel = Level.ALL;
        orgStepicJavaLogger.setUseParentHandlers(false);
        orgStepicJavaLogger.setLevel(orgStepicJavaLevel);
        Handler orgStepicJavaHandler = new ConsoleHandler();
        orgStepicJavaLogger.addHandler(orgStepicJavaHandler);
        orgStepicJavaHandler.setFormatter(new XMLFormatter());
        orgStepicJavaHandler.setLevel(orgStepicJavaLevel);

    }
}


/*
variant from comments
private static void configureLogging() {
    // 1
    Logger.getLogger("org.stepic.java.logging.ClassA").setLevel(Level.ALL);
    // 2
    Logger.getLogger("org.stepic.java.logging.ClassB").setLevel(Level.WARNING);
    // 3
    Logger logger = Logger.getLogger("org.stepic.java");
    Handler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    handler.setFormatter(new XMLFormatter());
    logger.setUseParentHandlers(false);
    logger.addHandler(handler);
}


 */