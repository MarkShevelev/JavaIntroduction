package org.itstep;

import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {
        //циклы (loops) нужны для совершения повторяющихся действий
        //цикл позволяет многократно проходить через одни и те же строки кода
        if(false) {
            //наиболее простой цикл - while
            /**
             * while(<условие продолжения>) {
             *     <блок итерации>
             * }
             * */
            //цикл while позволяет исполнять один и тот же блок кода
            //пока условие в круглых скобках после ключевого слова while
            //остаётся верным
            //например, следующий код бесконечно печатает "Hello World!"
            while(true) { //условие верно и независит ни от какого кода
                System.out.println("Hello World!");
            }
        }

        //терминология
        /**
         * цикл - синтаксическая конструкция, позволяющая многократно проходить через один и тот же блок кода
         * тело циела - блок кода, который необходимо повторить многократно
         * итерация - один проход по телу цикла
         * условие - выражение, приводимое к типу boolean, которое должно быть верным на каждой итерации
         * вариант - некоторое неотрицательно определённое выражение, которое уменьшается на каждой итерации
         * продвижение - действие, уменьшающее вариант
         * инвариант - условие, которое остаётся верным для всех итераций цикла
         *
         * */

        //рассмотрим задачу: напечатать на экране "Hello Loop!" ровно 10 раз
        if (false) {
            //наиболее очевидный способ скопировать код 10 раз
            /*System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");
            System.out.println("Hello Loop!");*/

            //такой подход не гибок и не продуктивен
            //воспользуемся циклом
            int counter = 10;  //вариант: сама переменная counter, инициализируется положительным числом
            while (0 != counter) {  //условие: counter не равен нулю, т.к. ноль раз ничего печатать не надо
                System.out.println("Hello Loop!"); //итерация: печатаем Hello Loop!
                --counter; //продвижение: уменьшаем вариант
            }
        }

        //усложним задачу: напечатать "Hello Loop!" столько раз сколько запросит пользователь
        if (false) {
            Scanner sc = new Scanner(System.in);
            int user_input = sc.nextInt();
            //данную задачу не получится решить простым копированием

            //воспользуемся циклом
            if (user_input > 0) { //очевидно, для отрицательных чисел и ноля задача смысла не имеет
                int counter = user_input;
                while (0 != counter) {
                    System.out.println("Hello Loop!");
                    --counter;
                }
            } else {
                System.out.println("Неверные входные данные!");
            }
        }

        //рассмотренные нами задачи совершали циклически абсолютно одинаковые операции
        //но т.к. вариант изменяется, то и действия могут отличаться
        //найдём сумму всех положительных целых чисел, не превосходящих некоторо заданного числа
        if (false) {
            Scanner sc = new Scanner(System.in);
            int user_input = sc.nextInt();

            if (user_input > 0) {
                int number = user_input;
                int sum = 0;
                while (0 != number) {
                    sum += number;
                    --number;
                }
                System.out.println("Сумма = " + sum);
            } else {
                System.out.println("Неверные входные данные!");
            }
        }

        //в предыдущих примерах мы понимали, что цикл обязательно завершится и могли точно сказать сколько он сделает
        //проходов по телу цикла
        //В некоторых случаях количество итераций неочевидно
        if (false) {
            float f0 = 1.f, epsilon = 0.5f;
            float f1 = f0 + epsilon;
            int counter = 0;

            while (f1 > f0) {  //кажется, что данный цикл не заврешится
                epsilon /= 2.f;
                f1 = f0 + epsilon;  //т.к. на каждой итерации f1 есть сумма f0 и положительного числа
                ++counter;
            }
            System.out.println("Epsilon = " + epsilon);
            System.out.println("Количество итераций = " + counter);
        }

        //попросим пользователя ввести число, если оно положительное, то напечатаем его, иначе запросим заново
        if (false) {
            Scanner sc = new Scanner(System.in);
            int user_input;
            boolean proceed = true;
            while (proceed) {
                user_input = sc.nextInt();
                if (user_input > 0)
                    proceed = false;
                else
                    System.out.println("Введите положительное число");
            }
        }

        //найдём сумму цифр числа
        if (false) {
            Scanner sc = new Scanner(System.in);
            long number = sc.nextLong();

            int sum = 0;
            long variant = number;
            while (0 != variant) {
                sum += variant%10;
                variant /= 10;    //продвижение
            }

            System.out.println("Сумма цифр = " + sum);
        }

        //вывод слова задом наперёд
        if (true) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();
            int counter = userString.length(); //длиной строки инициализируем наш вариант
            while (0 != counter) {
                System.out.print(userString.charAt(counter-1)); //нумерация символов начинается с нуля, .length() - 1 -> номер последнего символа
                --counter; //уменьшение варианта
            }
            System.out.println();
        }
    }
}
