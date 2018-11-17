package org.itstep;

import java.util.Scanner;

import static java.lang.Math.hypot;

public class StaticMethods {
    /**
     * Освоив возможности конструкций ветвления, циклов и массивов, мы подошли к тому моменту, когда можем написать
     * любую программу. Однако подобные программы могут содержать массу повторяющегося кода и не могут быть повторно
     * использованы. Для решения этих задач существуют специальные инструменты. Наиболее простой из них - функции.
     * Функции - это выделенные, поименованные блоки кода, которые можно многократно вызывать в разных частях
     * программы.
     *
     * Java является языком программирования, максимально ориентированным на объектно-ориентированный код.
     * В явном виде функции в Java отсутствуют. Ближайшими аналогами функций в Java являются статические методы.
     * */

    //выделенный блок кода имеет несколько важных элементов
    //public - модификатор доступа, можно использовать для сокрытия метода
    //static - указывает компилятору, что метод не будет связан с объектом
    //void - указание на возвращаемое значение (void - отсутствие возвращаемого значения)
    //printHello - имя метода, которое будет необходимо для вызова метода
    // () - скобки показывают список параметров/аргументов, необходимых данных, пустые скобки - нет необходимости в данных
    // { } - между фигурными скобками располагается код, который необходимо выполнить при вызове метода
    public static void printHello() {
        System.out.println("Hello Static Method!");
    }

    /**
     * Немного терминологии
     * Метод - выделенный поименованный блок кода, котоый может быть исполнен как часть, команда, из другого кода
     * Сигнатура - название метода и набор его входящих параметров
     * Тело метода - блок кода, связанный с методом
     * Вызов - обращение к методу для выполнения блока кода, связанного с методом
     * Клиентский код - код, из которого производится вызов
     * API (Application Programming Interface) - набор методов класса, предназначенный для использования в клиентском коде
     * */

    //метод, принимающий параметр
    //в круглых скобках мы перечисляем типы и внутренние названия параметров
    public static void printString(String s) { //String s  становится локальной переменной блока printString
        System.out.println(s);
    }

    //метод, принимающий несколько параметров
    public static void printStringCount(String s, int count) {
        for (int cnt = count; cnt !=0; --cnt)
            System.out.println(s);
    }

    /**
     * вызов метода является выражением, т.е. может быть приведён к значению
     * для этого метод должен возвращать результат
     * результат можно вернуть с помощью ключевого слова return
     * */
    //если метод возвращает результат, необходимо указать тип возвращаемого значения
    public static long sum(long x, long y) {
        return x+y; //return вычисляет выражение, которое стоит справа от него, результат вычислений и есть результат работы методы
    }

    //возвращаем различные значения в зависимости от условия
    //метод должен возвращать результат в любом случае!
    public static int choiceOperation(String choice, int x, int y) {
        switch(choice) {
            case "add":
                return x+y; //нет необходимости писать break; т.к. ключевое слово return сразу прерывает исполнение функции

            case "mul":
                return x*y;
            //обратите внимание, что если убрать return в ветке default, то программа не будет компилироваться
            default:
                return 0;
        }
    }

    //метод, чувствительный к порядку аргументов
    public static long subtract(int a, int b) {
        return a-b;
    }

    //входящие параметры всегда передаются копиями
    //следовательно изменения параметров не влияют на клиентский код
    //метод подсчитывает сумму цифр числа
    public static long sumDigit(long n) {
        n = n < 0 ? -n : n;
        long sum = 0;
        for (; n != 0; n /= 10) sum += n%10;
        return sum;
    }

    //метод получает копию ссылки, но свободно может работать с объектом
    public static void appendSomething(StringBuilder builder) {
        builder.append("World!"); //добавление произойдёт внутри объекта, вне зависимости от того, где он был создан
        builder = null; //значение присваивается ссылке, которая является только копией, присваивание не повлияет на клиентский код
    }

    /**
     * Если метод (функция) совершает какие-либо действия, влияющие на клиентский код или какие-либо иные объекты,
     * к которым метод (функция) имеют прямой или косвенный доступ, говорят, что "метод (функция) обладает побочным эффектом.
     *
     * Если метод (функция) не имеют никаких побочных эффектов, то их называют "чистыми"; "чистые" методы (функции)
     * при той же самой комбинации параметров всегда возвращают тот же самый результат, как метематические функции.
     *
     * Если многократное применение метода (функции) к аргументу даёт то же самое значение, что и однократное применение,
     * такой метод (функцию) называют "идемпотентной".
     *
     * Чистые методы (функции) всегда возвращают значения и полностью изолированы от окружающего кода
     * Методы (функции) с побочным эффектом могут не возвращать значений, а могут и возвращать
     * */

    //метод с ПОБОЧНЫМ ЭФФЕКТОМ, необратимо влияет на неявно известный объект System.out
    public static void printUppercase(String s) {
        System.out.println(s.toUpperCase());
    }

    //ЧИСТЫЙ метод, возвращает новое значение и никак не влияет на объекты, не являющиеся локальными
    //метод не идемпотентный, т.к. многократное применение будет давать разные результаты
    public static long syracuseNext(long prev) {
        return 0 == prev%2 ? prev/2 : 3*prev+1;
    }

    //чистый ИДЕМПОТЕНТНЫЙ метод
    public static long absoluteValue(long l) { //многократное применение модуля равносильно однократному
        return l < 0 ? -l : l;
    }

    //идемпотентный метод с побочным эффектом
    public static void builderToUppercase(StringBuilder builder) { //если строка уже в верхнем регистре, то с ней ничего не произойдёт
        for (int pos=0; pos != builder.length(); ++pos)
            builder.setCharAt(pos,Character.toUpperCase(builder.charAt(pos)));
    }

    //метод с побочным эффектом, возвращающий значение
    public static int readPositive(Scanner sc) {
        int userInput;
        do {
            userInput = sc.nextInt();
            if (userInput > 0) return userInput;
            System.out.println("Введите положительное число!");
        } while(true);
    }

    /**
     * Демонстрируем работу методов
     * */
    public static void main(String[] args) {
        //вызов простейшего метода
        if (false) {
            printHello(); //при вызове необходимо указать имя метода и набор передаваемых данных
        }

        //вызов метода с параметром
        if (false) {
            printString("Hello Param!");
        }

        //вызов метода с несколькими параметрами
        if (false) {
            printStringCount("Name",10); //печатаем Name 10 раз
        }

        //каждый метод принадлежит классу, потому при вызове следует использовать имя класса
        if (false) {
            Scanner sc = new Scanner(System.in);
            double userNumber = sc.nextDouble();
            if (userNumber > 0.) {
                double res = Math.sqrt(userNumber); //вызываем статический метод sqrt из класса Math
                System.out.printf("%.4f = %2$.4f*%2$.4f"+System.lineSeparator(),userNumber,res);
            } else {
                System.out.println("Не могу извлечь корень из отрицательного числа");
            }
        }

        //в случае, если метод вызывается многократно, то можно использовать "импорт статического метода"
        //import static java.lang.Math.hypot;
        if (false) {
            Scanner sc = new Scanner(System.in);
            double x = sc.nextDouble(), y = sc.nextDouble();
            System.out.printf("Длина гипотенузы равна %.4f"+System.lineSeparator(),hypot(x,y));
        }

        //используем метод, возвращающий значение
        if (false) {
            Scanner sc = new Scanner(System.in);
            long userA = sc.nextLong();
            long userB = sc.nextLong();

            final long res = sum(userA,userB); //результат вызова метода можно сохранить в переменную
            System.out.println(res); //для последующего использования

            //вызовы методов могут быть скомпонованы в сложное выражение, миную промежуточные переменные
            System.out.println( sum( sum(userA,userB), sum(userB,userA) ) ); //(A+B) + (B+A)
        }

        //используем метод, который имеет несколько точек выхода
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();
            int x = sc.nextInt(), y = sc.nextInt();

            System.out.println( choiceOperation(userString,x,y) );
        }

        //входящие параметры в метод вычисляются слева направо
        if (false) {
            int x = 1;
            System.out.println( subtract(x++,x++)); //если бы параметры вычислялись справа налево, то результатом был бы 1
            System.out.println("Actual x is " + x);
        }

        //методы копируют аргументы
        if (false) {
            Scanner sc = new Scanner(System.in);
            long userInput = sc.nextLong();
            System.out.println( sumDigit(userInput) ); //функция sumDigit активно меняет значение своего параметра в теле
            System.out.println(userInput); //однако значение userInput остаётся неизменным
        }

        //если параметр ссылочный, то метод копирует ссылку
        if (false) {
            StringBuilder builder = new StringBuilder();
            builder.append("Hello");
            System.out.println(builder);

            //вызываем функцию, которая получает копию ссылки, но производит действия с объектами
            appendSomething(builder);
            System.out.println(builder);
        }

        //вызываем чистые методы и методы с побочным эффектом
        if (false) {
            printUppercase("Hello"); //побочный эффект
            System.out.println("World"); //вывод произойдёт уже на "испорченный" экран

            long nextA = syracuseNext(123); //чистый метод, генерирует новое значение, не влияет на клиентский код
            long nextB = syracuseNext(123); //всегда возвращает одинаковое значение, если вызван с одинаковыми аргументами
            System.out.println(nextA == nextB);

            //хотя метод и чистный, он не идемпотентный
            nextA = syracuseNext(syracuseNext(syracuseNext(syracuseNext(123))));
            nextB = syracuseNext(123);
            System.out.println(nextA == nextB);

            //чистый идемпотентный метод
            long positiveA = absoluteValue(-234567);
            long positiveB = absoluteValue(-234567);
            System.out.println(positiveA == positiveB);

            positiveA = absoluteValue(absoluteValue(absoluteValue(-234567)));
            positiveB = absoluteValue(-234567);
            System.out.println(positiveA == positiveB);

            //идемпотентный метод с побочным эффектом
            StringBuilder builder = new StringBuilder("Hello");
            System.out.println(builder);

            builderToUppercase(builder);
            System.out.println(builder); //значение изменилось

            builderToUppercase(builder);
            builderToUppercase(builder);
            System.out.println(builder); //последующие вызовы метода равносильны первому
        }
    }
}
