package org.stepic.java.example;

/*
 * 
 * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.

Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
 * 
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName(){
        StackTraceElement[] stTrace = new Throwable().getStackTrace();
        
        
        if(stTrace.length<3) return null;
        String methodName = stTrace[2].getMethodName();
        String className = stTrace[2].getClassName();

        return className + "#" + methodName;
    }
    
}