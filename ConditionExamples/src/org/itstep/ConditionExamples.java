package org.itstep;

import java.util.Scanner;

public class ConditionExamples {
    public static void main(String[] args) {
        /**
         * Задание1
         * Пользователь вводит целое положительное число - год
         * Программа печатает количество дней в феврале
         * Используются правила григорианского календаря
         *
         * i) Если год не делится на 4 - в феврале 28 дней
         * ii) Если год делится на 4 и на 100, но не на 400 - в феврале 28 дней
         *
         * */
        if (false) {
            Scanner sc = new Scanner(System.in);
            int year = sc.nextInt();

            //выражение определяет является ли год НЕвисокосным
            boolean notLeap = (     0 != year%4    /*ЛИБО*/||    0 == year%100  /*И*/&& 0!=year%400);
            if (notLeap) {
                System.out.println("28 дней");
            } else {
                System.out.println("29 дней");
            }

            //упрощение кода: можно опустить фигурные скобки
            if (notLeap)
                System.out.println("28 дней");
            else
                System.out.println("29 дней");

            //упрощение кода: можно использовать тернарный оператор (условное выражение)
            System.out.println(
                notLeap ? "28 дней" : "29 дней"
            );
        }

        /**
         * Задание2
         * Три издательства предлагают напечатать книги.
         *
         * номер |  цена за печать 1кн | цена за доставку 1кн. | скидка
         * ------|---------------------|-----------------------|--------
         *   1   |     150             |         50            |   нет
         * ------|---------------------|-----------------------|--------
         *   2   |     180             |         40            | 10% от 3000 за книги (искл. доставку)
         * ------|---------------------|-----------------------|--------
         *   3   |     210             |         30            | 20% от 6000 за книги (искл. доставку)
         * ------|---------------------|-----------------------|--------
         *
         * Напишите программу, котора по ввелённому количеству книг определит номер издательства с наиболее выгодной общей стоимостью
         *
         * */
        if (false) {
            Scanner sc = new Scanner(System.in);
            int numberOfBooks = sc.nextInt();

            //расчёт для первого издательства прост
            int price1 = 150*numberOfBooks + 50*numberOfBooks;

            //расчёт для второго должен включать скидку
            int price2 = 180*numberOfBooks; //цена ТОЛЬКО за книги, без доставки
            if (price2 >= 3000) {
                price2 = price2 - price2 / 10; //уменьшаем цену на одну десятую
            }
            price2 += 40*numberOfBooks; //добавляем в цену доставку

            //расчёт для третьего издательства аналогичен
            int price3 = 210*numberOfBooks;
            if (price3 >= 6000) {
                price3 = price3 - price3/5;
            }
            price3 += 30*numberOfBooks;

            //вычисление может быть записано более компактно с использованием тернарного оператора
            //price3 += (price3 > 6000 ? -price3/5 : 0) + 30*numberOfBooks;

            //диагностируем цены
            System.out.println("Изд1: " + price1);
            System.out.println("Изд2: " + price2);
            System.out.println("Изд3: " + price3);

            //Выбираем наболее удачное издательство
            if (price1 < price2 && price1 < price3)
                System.out.println("Изд1");
            else if (price2 < price1 && price2 < price3)
                System.out.println("Изд2");
            else
                System.out.println("Изд3");
        }
    }
}
