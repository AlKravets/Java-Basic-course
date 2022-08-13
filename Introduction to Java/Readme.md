# Java

Java without pointers
java with automatic memory control
Java with virtual machine.


# First program in java.

In one file you should write only one class. Name of class have to be the same as filename.

You have to install **JDK** (java developer kit)

For compilation program into bytecode you have to use command `javac`. 

```
javac HelloWorld.java
```

After this you will have a `.class` file (`HelloWorld.class`) -- this is bytecode file. 

you can translate binary bytecode into human readable text by using command `javap`

```
javap -v HelloWorld.class
```

## System exit

you can finish you program with another return code (not a 0) (like in C return -1). For this use `System.exit(-1)`.


## Running program

FOr start program you have to use virtual machine this is just `java` command

```
java HelloWorld
```

you have to write name of main class (not a file with extension). Main class have to include `main` method. 

Virtual machine will find right file by itself. In this example java will find `HelloWorld.class` in current dir.


If files is in another dir. you have to inform java machine about this using `-classpath classes_dir` key

```
java -classpath classes_dir HelloWorld
```

Java have to see all classes that are used in program. If java doesn't find one class it will be finish with error.


# jar archive

real java programs include big amount of files. So programers pack them into archives. THis is a just zip archive with additional **Manifest** file that inform us with class is the main in `.jar` archive. Also manifest file includes information about program: name of program, version

We can work with jar archives using command `jar`

To Create archive from files

```
jar cfe name_of_archive.jar MainClassName Cla ssFile1.class ClassFile2.class
```

To check what files compressed into archive (without unpacking) you have to use  

```
jar tf archive.jar
```

To  unpack archive you have to use

```
jar xf archive.jar
```

You can run the program from jar archive if information about main class is saved in the archive (in manifest) use this command

<!-- Cspell:disable -->
```
java -jar archive.jar
```
<!-- Cspell:enable -->


If in jar archive information about main class is not saved but we know the main class. You can run the program using this command

```
java -classpath archive.jar MainClass
```

## Use Libraries in java

If your source code depend on foreign library in jar archive you can compile your code with this command
```
javac -classpath lib.jar MainClass.java
```
For running compiled program you also have to use all libraries

```
java -classpath lib.jar:hw.jar MainClass
```
In Linux divider for classpathes have to be `:` in Windows this is `;`.


Предположим, вы написали программу, состоящую из двух классов, и в каждом классе объявили точку входа — метод main. Что из этого выйдет?****

Программа скомпилируется и запустится. Неоднозначности не возникнет, поскольку при запуске всегда явно указывается класс, в котором JVM должна искать метод main

### Java virtual machine specification -- in this document you can find rules for all bytecode instructions

JVM can work in interpritator style (run one instructon after another) or compile all instruction into machine code (jit compilation)


- JDK - Набор инструментов для разработки Java-программ, включая компилятор
- JRE Набор инструментов для запуска Java-программ, включая виртуальную машину
- JVM Виртуальная машина Java
- JIT Подход к реализации виртуальной машины, при котором байткод не интерпретируется, а компилируется в машинный код для исполнения аппаратным процессором
- JAR Формат архива, в который обычно упаковывают Java-программы и библиотеки


Более подробно о рекомендуемом стиле кода можно почитать здесь:

- Упомянутый в видео старый документ [Code Conventions for the Java Programming Language](http://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html)
- Черновик нового документа [Java Style Guidelines](http://cr.openjdk.java.net/~alundblad/styleguide/)