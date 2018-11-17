package org.itstep;

public class StaticMethodsOverload {
    /**
     * С точки зрения языка Java два метода с различной сигнатурой различны.
     *
     * Перегрузка метода - это создание двух методов с одинаковым названием, но различным набором входящих параметров
     * Два различных перегруженных метода могут возвращать данные различных типов
     * Два метода не могут различаться ТОЛЬКО типом возвращаемого значения!
     *
     * P.S. Иногда перегрузку называют ad-hoc полиморфим или "полиморфизм времени компиляции"
     * */

    //три метода имеют одинаковое название print, но различные входящие типы
    //с точки зрения Java эти три метода различны
    public static void print(short sh) {
        System.out.println("Short overload: " + sh);
    }

    public static void print(int i) {
        System.out.println("Int overload: " + i);
    }

    public static void print(long l) {
        System.out.println("Long overoload: " + l);
    }

    //перегрузка методов возможна и по количеству параметров
    public static char getSymbol(String s, int pos) {
        System.out.println("Two arguments method called");
        return s.charAt(pos);
    }

    public static char getSymbol(String s) {
        System.out.println("One arguments method called");
        return s.charAt(0);
    }

    //переменное число параметров
    //суммируем два числа
    public static long sum(long l1, long l2) {
        System.out.println("Double argument overload");
        return l1+l2;
    }

    //суммируем три числа
    public static long sum(long l1, long l2, long l3) {
        System.out.println("Triple argument overload");
        return l1+l2+l3;
    }

    //суммируем сколько угодно чисел
    //перегрузка с произвольным числом параметров
    public static long sum(long ...ls) {
        System.out.println("Multiple argument overload");
        long sum = 0;
        for (long l : ls)
            sum += l;
        return sum;
    }

    /**
     * Методы с произвольным числом параметров реализованы посредством неявного преобразования набора входящих данных
     * в массив, потому нельзя создать перегрузку с переменным числом аргументом и массивом одновременно.
     * Также следует понимать, что функция с переменным числом аргументов может принимать переменное количество
     * аргументов ОДНОГО типа, но не разных.
     * */
    public static String concat(String ...args) {
        StringBuilder builder = new StringBuilder();
        for (String s : args)
            builder.append(s);
        return builder.toString();
    }

    //невозможно организовать перегрузку с массивом, т.к. такая метод уже определен
    /*public static String concat(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String s : args)
            builder.append(s);
        return builder.toString();
    }*/

    /**
     * Хотя методы и являются эдинтичными с точки зрения конечной сигнатуры и Java не позволяет определить их одновременно,
     * метод с переменным числом аргументов делает неявное преобразование набора аргументов в массив.
     * Метод с массивом в качестве аргумента будет ожидать РОВНО ОДИН аргумент, а не набор аргументов!
     * */
    public static String longest(String[] args) {
        int pos = 0;
        for (int i=0; i!=args.length; ++i)
            if (args[i].length() > args[pos].length())
                pos = i;
        return args[pos];
    }

    /**
     * При выборе перегруженной версии компилятор будет пытаться подобрать версию, подходящую по неявному преобразованию,
     * если точного совпадения типов не будет найдено.
     * */
    public static long mul(long i, long j) {
        System.out.println("Long mul...");
        return i*j;
    }

    public static double mul(double x, double y) {
        System.out.println("Double mul...");
        return x*y;
    }

    public static int iMul(int i, int j) {
        System.out.println("Int Int overload");
        return i*j;
    }

    public static double ldMul(long l, double d) {
        System.out.println("Long Double overload");
        return d*l;
    }

    public static double ldMul(double d, long l) {
        System.out.println("Double Long overload");
        return d*l;
    }

    public static void main(String[] args) {
        //перегрузка методов помогает писать код, в котором названия методов отражают суть операции,
        //а компилятор сам определяет какой из методов следует использовать для того или иного типа данных
        if (false) {
            short sh = 5;
            int intVal = 5;
            long longVal = -5L;

            print(sh);
            print(intVal);
            print(longVal);

            //вызывается метод для int, арифметическое расширение
            print(sh+1);

            //вызывается метод для int, явное преобразование
            print((int)longVal);
        }

        //перегрузка методов по количеству параметров позволяет эмулировать методы с "параметрами по умолчанию"
        if (false) {
            String s = "Hello";
            //если указать параметр явно, то будет выбран метод с двумя параметрами
            System.out.println(getSymbol(s,3));

            //для часто используемых ситуаций метод может быть перегружен с заданным значением одного или нескольких параметров
            System.out.println(getSymbol(s));
        }

        //перегрузка по количеству параметров
        if (false) {
            long l1 = 0, l2 = 1, l3 = 2, l4 = 3;
            System.out.println( sum(l1,l2) ); //вызывается перегрузка с двумя параметрами

            System.out.println( sum(l1,l2,l3) ); //вызывается перегрузка с тремя параметрами

            System.out.println( sum(l1,l2,l3,l4) ); //вызывается перегрузка с произвольным числом параметеров

            System.out.println( concat("Hello"," ","World","!") );

            //System.out.println( longest("Hello"," ","World","!") ); //невозможно вызвать, т.к longest ожидает один аргумент
            System.out.println( longest(new String[] {"Hello"," ","World","!"})); //необходимо явно создать массив из набора значений
        }

        //преобразования типов при выборе перегрузки
        if (false) {
            long aL = 1, bL = 10;
            System.out.println( mul(aL,bL) ); //long long

            short aSh = 1, bSh = 10;
            System.out.println( mul(aSh,bSh) ); //long long

            double aDbl = 1., bDbl = 10.;
            System.out.println( mul(aDbl,bDbl) ); //double double

            float aFlt = 1.f, bFlt = 10.f;
            System.out.println( mul(aFlt,bFlt) ); //double double

            System.out.println( mul(aL,bDbl) );  //double double, т.к. нельзя вызвать long long

            //System.out.println( iMul(aL,bL) ); //невозможно вызвать, нет неявного преобразования long->int

            System.out.println( ldMul(aSh,bFlt) ); //long double
            System.out.println( ldMul(aFlt,bSh) ); //double long
            //System.out.println( ldMul(aSh,bSh) ); //ошибка компиляции: возможны обе перегрузки
            //System.out.println( ldMul(aFlt,bFlt) );
        }
    }
}
