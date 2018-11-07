package org.itstep;

import java.util.Scanner;

public class ArraysExamples {
    public static void main(String[] args) {
        /**
         * Табличные данные
         * Задача
         * В кредитной организации "ООО Панда-кредит" процент по кредиту зависит
         * от выбранной суммы и возраста клиента
         * от 1 000 до 100 000 -> 12%
         * от 100 001 до 250 000 -> 13%
         * от 250 001 до 500 000 -> 15%
         * от 500 001 до 1 000 000 -> 17%
         * от 1 000 001 до 5 000 000 -> 20%
         * 
         * изменения ставки по возрасту
         * от 18 до 25 -> +2%
         * от 26 до 35 ->  0%
         * от 36 до 45 -> -2%
         * от 46 до 55 -> -3%
         * от 56 до 65 -> +1%
         * от 66 до 75 -> +2%
         * 
         * Пользователь вводит сумму и возраст, определите полную ставку
         */
        if (false) {
            int[] funds = new int[6];
            int[] interests = new int[6];
            funds[0] = 1000; interests[0] = 0;
            funds[1] = 100_000; interests[1] = 12;
            funds[2] = 250_000; interests[2] = 13;
            funds[3] = 500_000; interests[3] = 15;
            funds[4] = 1_000_000; interests[4] = 17;
            funds[5] = 5_000_000; interests[5] = 20;
            
            int[] ages = new int[7];
            int[] addInterest = new int[7];
            ages[0] = 18; addInterest[0] = 0;
            ages[1] = 25; addInterest[1] = 2;
            ages[2] = 35; addInterest[2] = 0;
            ages[3] = 45; addInterest[3] = -2;
            ages[4] = 55; addInterest[4] = -3;
            ages[5] = 65; addInterest[5] = 1;
            ages[6] = 75; addInterest[6] = 2;
            
            System.out.println("Введите желаемую сумму и возраст: ");
            Scanner sc = new Scanner(System.in);
            int fund = sc.nextInt();
            int age = sc.nextInt();
            
            
            if (fund < funds[0] || fund > funds[funds.length-1]) {
                System.out.println("Не можем выдать сумму менее " + funds[0] + " и боле " + funds[funds.length-1]);
            }
            else {
                int interest = 0;
                for (int cnt = 0; cnt != funds.length; ++cnt)
                    if (fund <= funds[cnt]) { interest = interests[cnt]; break; }
                
                if ( age < ages[0] || age > ages[ages.length-1]) {
                    System.out.println("Не можем выдать кредит людям младше " + ages[0] + " и старше " + ages[ages.length-1]);
                }
                else {
                    for (int cnt = 0; cnt != ages.length; ++cnt)
                        if (age <= ages[cnt]) { interest += addInterest[cnt]; break; }
                    
                    System.out.println("Ставка по кредиту на сумму " + fund + " для Вас составит " + interest + "%");
                }
                
            }
        }
        
        /**
         * Прогрессия данных
         * Задача
         * Треугольник Паскаля
         * На вершине треугольника расположена единица
         * На втором уровне две единицы
         * На каждом следующем уровне ряд начинается и заканчивается единицей
         * Элемент ряда вычисляется как сумма двух элементов верхнего ряда
         * Пример:
         *           1
         *         1   1
         *       1   2   1
         *     1   3   3   1
         *   1   4   6   4   1
         * 1   5   10  10  5   1
         * 
         * Выведите на экран заданный ряд треугольника Паскаля
         */
        if (false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите номер ряда пирамиды Паскаля: ");
            int rowNum = sc.nextInt();
            
            int[] currRow = new int[rowNum], nextRow = new int[rowNum]; 
            currRow[0] = nextRow[0] = 1;
            
            for (int rowCnt= 1; rowCnt != rowNum; ++rowCnt) {
                for (int pos = rowCnt; pos > 0; --pos)
                    nextRow[pos] = currRow[pos] + currRow[pos-1];
                
                //swap
                int[] tmp = currRow;
                currRow = nextRow;
                nextRow = tmp;
            }
            
            for (int pos = 0; pos != rowNum; ++pos)
                System.out.print(currRow[pos] + " ");
            System.out.println();
        }
        
        /**
         * Редукция данных
         * Задача
         * Коля и Петя строят цветную стену
         * Кирпичи бывают трёх цветов (R - красный, G - зелёный, B - синий)
         * На каждом следующем уровне кирпич операется на два кирпича нижнего уровня
         * Причём цвет кирпича определяется тем, на каких кирпичах он стоит
         * Если опорные кирпичи имеют одинаковый цвет, то и верхний кирпич того же цвета
         * Если опорные кирпичи имеют разный цвет, то цвет верхнего кирпича третий
         * Пример:
         *        G
         *       G G
         *      B B R
         *     R G R R
         *    R R B G B
         *   R R R G G R
         *  B G B G G G B
         * G R B B R B R G
         * 
         * Требуется определить цвет верхнего кирпича по набору кирпичей на первом уровне
         */
        if (false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Какой длины будет основание пирамиды: ");
            int length = sc.nextInt();
            System.out.println("Введите последовательность букв R G B из " + length + " символов: ");
            String rgbWord = sc.next();
            
            char[] chars = new char[] {'R','G','B'};
            byte[] base = new byte[length];
            for (int pos = 0; pos != rgbWord.length(); ++pos)
                for (byte i = 0; i != 3; ++i)
                    if (rgbWord.charAt(pos) == chars[i]) base[pos] = i;
            
            byte[] transform = {0,2,1};
            for (int row = length-1; row >= 0; --row)
                for (int pos = 0; pos != row; ++pos)
                    base[pos] = transform[(base[pos]+base[pos+1])%3];

            System.out.println(chars[base[0]]);
        }
    }
}
