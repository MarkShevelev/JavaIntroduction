package org.itstep;

import java.util.Scanner;

public class DoWhileLoops {
    public static void main(String[] args) {
        /**
         * Терминология
         * Циклы бывают двух типов: циклы с предусловием (precondition) и циклы с постусловием (postcondition)
         *
         * Цикл с предусловием проверяет условие ДО входа в итерацию. Если условие изначально ложно, то цикл
         * не сделает ни одной итерации.
         *
         * Цикл с постусловием проверяет условие ПОСЛЕ выполнения тела. Если условие изначально ложно, то цикл
         * всё равно выполнит итерацию один раз
         * */
        if (false) {
            //Следующий цикл с предусловием ни разу не выполнится
            int i = 0;
            while (i > 0) {
                System.out.println(--i);
            }
        }

        //для циклов с постусловием в Java есть специальная конструкция do { } while();
        if (false) {
            //следующий цикл напечатает -1
            int i = 0;
            do {
                System.out.println(--i);
            } while(i>0);
        }
        //циклы с постусловием удобны, когда итерацию необходимо выполнить как минимум один раз

        //решим задачу о вводе положительного числа пользователем через цикл с постусловием
        if (false) {
            Scanner sc = new Scanner(System.in);
            int user_input;
            do { //постусловие очень удобно, т.к. мы должны как минимум один раз запросить у пользователя число
                user_input = sc.nextInt();
                if (user_input <= 0)
                    System.out.println("Введите положительное число");
            } while (user_input <= 0);
        }

        //пользователь вводит 10 чисел, найдём их сумму
        if (true) {
            Scanner sc = new Scanner(System.in);
            int sum = 0;
            int counter = 0;
            do {
                int user_input = sc.nextInt();
                sum += user_input;
                ++counter;
            } while (10 != counter);
            System.out.println(sum);
        }
    }
}
