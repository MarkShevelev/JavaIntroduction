package org.itstep;

import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Statement if() { } else { }
        if (false) {
            //конструкция пропуска
            boolean aBlock = true, bBlock = false;
            if (aBlock)
                System.out.println("A Block executed!");

            if (bBlock)
                System.out.println("B Block executed!");

            //конструкция альтернативного исполнения
            boolean cBlock = true;
            if (cBlock)
                System.out.println("C Block executed!");
            else
                System.out.println("C Block is not executed...");
        }

        //ищем максимум
        if (false) {
            int a, b;
            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            if (a > b)
                System.out.println("Первое больше второго!");
            else
                if (b > a)
                    System.out.println("Второе больше первого!");
                else
                    System.out.println("Числа равны");
        }

        //операции сравнения
        if (false) {  //> < >= <= == !=
            int a,b;
            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            if (a == b)
                System.out.println("Числа равны!");
            else
                System.out.println("Числа разные!");
        }

        //компоновка условий &&
        if (false) {
            int a,b;
            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            /*if (a*a+b*b < 10*10)
                if (a*a+b*b > 5*5)
                    System.out.println("Точка попадает в кольцо!");
                else
                    System.out.println("Точка не попадает в кольцо"); //повторяющийся код!
            else
                System.out.println("Точка не попадает в кольцо");     //повторяющийся код!
            */

            //&& - Два условия одновременно
            if (a*a+b*b < 10*10 && a*a+b*b > 5*5)
                System.out.println("Точка попадает в кольцо!");
            else
                System.out.println("Точка не попадает в кольцо");
        }

        //компоновка условий ||
        if (false) {
            int a,b;
            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            /*if (a*a+b*b > 10*10)
                System.out.println("Точка не попадает в кольцо");    //повторяющийся код!
            else
                if (a*a+b*b > 5*5)
                    System.out.println("Точка попадает в кольцо!");
                else
                    System.out.println("Точка не попадает в кольцо"); //повторяющийся код!
            */

            //|| - любое из условий
            if (a*a+b*b > 10*10 || a*a+b*b < 5*5)
                System.out.println("Точка не попадает в кольцо");
            else
                System.out.println("Точка попадает в кольцо!");
        }

        //отрицание !
        if (false) {
            boolean aBlock = false;
            if (!aBlock) { //отрицание превращает false в true
                System.out.println("A Block executed");
            }

            boolean bBlock = true;
            if (!bBlock) { //true в false
                System.out.println("B Block executed");
            }

            //Законы де М`органа
            boolean aRes = !(aBlock && bBlock);
            boolean bRes =  !aBlock || !bBlock;
            aRes = !(aBlock || bBlock);
            bRes = !aBlock && !bBlock;
        }

        //совместное использование и приоритет операций
        if (false) {
            //Попадание числа в один из отрезков
            float aSegmentBegin = 1.0f, aSegmentEnd = 2.0f;
            float bSegmentBegin = 3.0f, bSegmentEnd = 5.0f;

            System.out.println("Введите число в формате десятичной дроби: ");
            float p = sc.nextFloat();

            //операция && приоритетнее, потому исполняется до ||
            if (p>=aSegmentBegin && p<=aSegmentEnd || p>=bSegmentBegin && p<=bSegmentEnd)
                System.out.println("Чиспло попадет в один из отрезков!");
            else
                System.out.println("Число не попадате ни в один из отрезков");
        }

        //сокращённые вычисления
        if(false) {
            int a,b;
            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            if (a>b || ++a>b) {
                System.out.println("Первое число больше второго в этом блоке");
                System.out.println(a);
            }
            else {
                System.out.println("Первое число меньше или равно второму в этом блоке");
                System.out.println(a);
            }

            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            if (a<b && ++a<b) {
                System.out.println("Первое число меньше второго в этом блоке");
                System.out.println(a);
            }
            else {
                System.out.println("Первое число больше или равно второму в этом блоке");
                System.out.println(a);
            }
        }


        //Тернарный оператор <condition> ? <on true> : <on false> //условное выражение
        if (false) {
            int a,b;
            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            /*if (a > b)  //избыточный код: повторяем код вывода в консоль
                System.out.println("Первое больше второго!");
            else
                System.out.println("Первое не больше второго!");
            */

            System.out.println(
                    a > b ? "Первое больше второго!" : "Первое не больше второго!"
            );
        }

        //использование оператора ? : при присваивании
        //находим наибольшее из трёх
        if (false) {
            int a, b, c;
            System.out.println("Введите три целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            int max = a;
            max = b > max ? b : max; //равно менее приоритетный оператор, чем ? :
            max = c > max ? c : max;
            System.out.println(max);
        }

        //високосный год
        if (false) {
            int year;
            year = sc.nextInt();
            if (year < 1900) {
                System.out.println("Ожидаем значение не меньше 1900");
            }
            else {
                boolean isLeap = 0 == year%4 && (0 != year%100 || 0 == year%400);
                System.out.println(isLeap?"Да":"Нет");
            }
        }

        //множественный выбор switch / case / break
        if (false) {
            System.out.println("Сколько ног у кошки?");
            System.out.println("1) одна нога");
            System.out.println("2) две ноги");
            System.out.println("3) кошки нет");
            System.out.println("4) четыре лапы");

            int variant = sc.nextInt();
            switch(variant) {
                case 1: //case - вариант выбора; 1 - константа для сравнения
                    System.out.println("Неверно!");
                    break; //прерывание исполнения

                case 2:
                    System.out.println("Холодно!");
                    break;

                case 3:
                    System.out.println("Где же кошка?");
                    break;

                case 4:
                    System.out.println("Точно так!");
                    break;

                default: //если ни один вариант не подошёл
                    System.out.println("Такого варианта нет. Будьте внимательны!");
            }
        }

        //множественный выбор с пропуском прерывания
        if(false) {
            System.out.println("Сколько раз от 1 до 5 вы хотите напечатать \"Hello Switch!\"?");
            int numof = sc.nextInt();

            switch(numof) {
                case 5:
                    System.out.println("Hello Switch!");
                case 4:
                    System.out.println("Hello Switch!");
                case 3:
                    System.out.println("Hello Switch!");
                case 2:
                    System.out.println("Hello Switch!");
                case 1:
                    System.out.println("Hello Switch!");
                    break;

                default:
                    System.out.println("Только от 1 до 5...");
            }
        }

        //множественный выбор со строками
        if(false) {
            int a,b;
            System.out.println("Введите два целых числа: ");
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println("Какую операцию произвести?");
            int res = 0; boolean good = true;
            switch (sc.next()) {
                case "sum": res = a+b; break;
                case "dif": res = a-b; break;
                case "mul": res = a*b; break;
                case "div": if (0 != b) res = a/b; else good = false; break;
                default:
                    good = false;
            }
            System.out.println(good?("Ваш результат: "+res):"Ошибка...");
        }

        /**
         * Множественный выбор может работать со следующими типами: byte, short, int,
         * char, String (Java 7), enum (перечисления, определяемые пользователем).
         * И с обёртками: Byte, Short, Integer, Character.
         * 
         * */

    }
}
