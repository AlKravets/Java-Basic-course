# Пакеты

Принадлежность класса пакету указывается директивой `package` чаще всего первой строчкой в файле

название пакета должно совпадать с путем до файла

`package org.stepic.java;` -- это значит, что файл лежит в директории `org/stepic/java/FileName.java`

Полное имя класса тогда будет `org.stepic.java.ClassName`  В JVM передавать нужно полное имя класса.

Для того, чтобы использовать короткую запись обращения к классу (не писать полный путь, а просто имя) нужно выполнить импорт `import org.stepic.java.ClassName;` 

Можно импортировать (для сокращения обращения) статические методы класса. Так например можно импортировать `sqrt` из `Math` и просто вызывать корень как `sqrt()`.

Директива импорт используется только сокращения обращения к классам (это не аналог incude из C++)

При выполнении программы все имортированные классы должны присутствовать в classpath.


# классы

Если нет модификатора public или другого, то класс, метод виден **только внутри пакета**


## поля классов

если у поля модификатор `final` то значение полю можно присвоить только один раз и больше менять нельзя.

## Конструктор 

Это спец метод, который вызывается при создании экземпляра класса (при применении оператора new)

Если не написаны свои конструкторы, то создается конструктор по умолчанию. 

Чтобы запретить создания экземпляров класса, нужно создать один приватный конструктор.

Конструкторы можно перегружать. МОжно из одного конструктора вызывать другой.

В java нет параметров по умолчанию.


Деструкторов в Java нет.

Если в объекте нужно что-то закрыть, почистить, то создается метод close и уже программист отвечает за то, чтобы вызвать этот метод явно.


## Наследование

`object instanceof Class`  проверка того, что объект является экземпляром данного класса, подклассы тоже считаются