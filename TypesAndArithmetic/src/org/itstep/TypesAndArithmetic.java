package org.itstep;

public class TypesAndArithmetic {
    public static void main(String[] args) {
        //ФУНДАМЕНТАЛЬНЫЕ (ПРИМИТИВНЫЕ) ТИПЫ
        if (false) {
            byte b       = 0;        //1 байт
            short sh     = 0;        //2 байта
            int i        = 0;        //4 байта
            long l       = 0L;       //8 байт
            float f      = 0.0f;     //4 байта IEEE754
            double d     = 0.0d;     //8 байт  IEEE754
            char ch      = '\u0000'; //2 байта символ
            boolean bool = false;    //? true false логический тип
            Object ref   = null;     //? ссылка
        }

        //Пределы числовых типов типов
        if(false){
            System.out.println("Byte: " + Byte.MAX_VALUE + " | " + Byte.MIN_VALUE);
            System.out.println("Short: " + Short.MAX_VALUE + " | " + Short.MIN_VALUE);
            System.out.println("Integer: " + Integer.MAX_VALUE + " | " + Integer.MIN_VALUE);
            System.out.println("Long: " + Long.MAX_VALUE + " | " + Long.MIN_VALUE);
            System.out.println("Float: " + Float.MAX_VALUE + " | " + Float.MIN_VALUE);
            System.out.println("Double: " + Double.MAX_VALUE + " | " + Double.MIN_VALUE);
        }

        //Арифметика
        if(false){
            int a = 3, b = 2;
            System.out.println(a+b);
            System.out.println(a-b);
            System.out.println(a*b);
            System.out.println(a/b);
            System.out.println(a%b);
        }

        //Присваивающая арифметика
        if(false){
            int c = 3;
            int a, b = 2;

            a = c;
            a += b;
            System.out.println(a);

            a = c;
            a -= b;
            System.out.println(a);

            a = c;
            a *= b;
            System.out.println(a);

            a = c;
            a /= b;
            System.out.println(a);

            a = c;
            a %= b;
            System.out.println(a);

            a = c;
            System.out.println(++a);

            a = c;
            System.out.println(a++);
            //System.out.println(a);
        }

        //Арифметические выражения
        if(false){
            int a = 2, b = 5;
            //арифметическое выражение вычисляется и результат попадает в c
            int c = (a+b)*(a-b) + (b/b+a/a)*a*b + (b/b+a/a)*b*b; //Помните: вычисления строгие, т.е. производятся там, где указаны

            System.out.println(c);
            a = 3; b = 2;
            System.out.println(c);

            System.out.println((a+b)*(a-b) + (b/b+a/a)*a*b + (b/b+a/a)*b*b); //здесь вычисления производятся уже с новыми значениями a и b
        }

        //Хитрые выражения
        if(false) {
            int a = 2;
            int b = a++ + ++a; //слева на право -> (a++ + ++a | a = 2) -> (2 + ++a | a = 3) -> (2 + 4 | a = 4) -> (6 | a = 4)
            System.out.println(b + " | " + a);

            int aa = 2;
            int bb = ++aa + aa++;
            System.out.println(bb + " | " + aa);

            int aaa = 2;
            int bbb = aaa+++aaa;
            System.out.println(bbb + " | " + aaa);
        }
    }
}
