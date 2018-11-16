package org.itstep;

import java.util.Arrays;
import java.util.Random;
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

        /**
         * Массивы можно использовать для решения некоторых задач методом динамического программирования
         * Задача
         * Найти N-e число Фибоначчи, заданное рекурентно: Fib(N) = Fib(N-1) + Fib(N-2), Fib(1)=1, Fib(2)=1
         * */
        if (false) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            long[] fibonacci = new long[N];
            fibonacci[0] = 1; fibonacci[1] = 1;

            for (int pos = 2; pos < N; ++pos)
                fibonacci[pos] = fibonacci[pos-1]+fibonacci[pos-2];

            System.out.println(fibonacci[N-1]);
        }

        /**
         * Задача
         * Между двумя берегами реки есть сухой путь по камушкам
         * На каждом камушке лежит некоторое неотрицательное количество конфет
         * На одном берегу сидит зайчик, он может прыгать между камушками либо через один камень, либо через два,
         * но не может прыгнуть на следующий камень или через три камня, или назад
         * Зная количество конфет на каждом камушке, найдите наибольшее возможное количество конфет, которое соберёт
         * зайчик, прыгая с одного берега реки на другой
         * */
        if (false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите количество камушков не менее пяти: ");
            int numberOfStones = sc.nextInt();

            System.out.println("Введите количество конфет на каждом камушке: ");
            int[] sweets = new int[numberOfStones];

            for (int pos=0; pos != numberOfStones; ++pos)
                sweets[pos] = sc.nextInt();


            //в этом массиве запоминаем максимально возможное количество конфет, которое соберёт зайчик, если окажется
            //на камне с определённым индексом
            long[] sweetsCollected = new long[numberOfStones];
            //так, на первый камень зайчик не может попасть
            sweetsCollected[0] = 0;
            //если он попадёт на второй камень, то соберёт ровно столько, сколько там лежит
            sweetsCollected[1] = sweets[1];
            //если он попадёт на третий камень, то также соберёт ровно столько, сколько там лежит,
            //т.к. есть единственный способ туда попасть
            sweetsCollected[2] = sweets[2];

            //на четвёртый камень можно попасть только со второго, совершив два прыжка через один камень
            // s| 0 1 2 3 : s->1->3
            sweetsCollected[3] = sweets[3]+sweetsCollected[1];

            //однако на пятый камень можно попасть разными путями:
            // s| 0 1 2 3 4
            // s->1->4  через один и через два
            // s->2->4  через два и через один
            //Необходимо выбрать тот путь, который даст наибольшее количество конфет
            sweetsCollected[4] = sweets[4] + (sweetsCollected[2] > sweetsCollected[1] ? sweetsCollected[2] : sweetsCollected[1]);

            //Для любого номера островка есть два пути туда попасть
            // N-2 -> N прыжок через один
            // N-3 -> N прыжок через два
            for (int pos = 5; pos != numberOfStones; ++pos)
                sweetsCollected[pos] = sweets[pos] +
                        (sweetsCollected[pos-2] > sweetsCollected[pos-3] ? sweetsCollected[pos-2] : sweetsCollected[pos-3]);

            //Зайчик может закончить путь либо на последнем, либо на предпоследнем островке
            //(находясь на предпоследнем островке, он уже не может забрать конфеты с последнего),
            //полный результат - максимум из конфет, набранных к последнему и предпоследнему островку
            long res = (sweetsCollected[numberOfStones-1] > sweetsCollected[numberOfStones-2] ? sweetsCollected[numberOfStones-1] : sweetsCollected[numberOfStones-2]);
            System.out.println("Наибольшее число конфет: " + res);
        }

        /**
         * Задача
         * Дан массив целых чисел и опорное число
         * Требуется найти пару чисел, которая в сумме даёт опорное число
         * */
        if (false) {
            //начальное распределение случайно в интервале от -500 до +500
            Random r = new Random();
            int[] randomArray = new int[20];
            for (int pos = 0; pos != randomArray.length; ++pos)
                randomArray[pos] = r.nextInt(1000)-500;

            //наглядный вывод элементов массива
            for(int x : randomArray)
                System.out.printf("%5d",x);
            System.out.println();

            //опорное число запрашиваем у пользователя
            Scanner sc = new Scanner(System.in);
            int pivot = sc.nextInt();

            //наивный алгоритм состоит в том, чтобы перебирать все возможные пары элементов
            //его сложность O(N*N)

            //наивный алгоритм можно улучшить
            //если из массива выбрать некое число X, то задача о существовании пары, дающей в сумме pivot, сводится
            //к поиску в массиве числа pivot-X
            //если массив был бы отсортирован, то поиск можно произвести не линейным, а бинарным поиском!

            //Отсортируем массив
            Arrays.sort(randomArray); //занимает O(N*logN) действий

            int a = 0, b = 0;//искомые числа
            boolean found = false; //флаг того, что числа найдены
            //циклом перебираем числа
            for (int pos =0; pos != randomArray.length-1; ++pos) { //повторяется N раз
                int toFind = pivot - randomArray[pos]; //искомое число есть разность заданной суммы и текущего числа

                //ищем число, равное разности, в части массива от текущего значения до конца массива
                int posFound = Arrays.binarySearch(randomArray,pos+1,randomArray.length,toFind); //занимает O(logN)
                //если индекс верный, то число найдено
                if (posFound >=0 && posFound < randomArray.length) {
                    a = randomArray[pos];
                    b = randomArray[posFound];
                    found = true;
                    break;
                }
            }
            //В сумме сложность алгоритма O(N*logN) + N*O(logN) -> O(N*logN), что значительно быстрее наивного алгоритма!

            if (found)
                System.out.println("Искомая пара: " + a + " + " + b + " = " + pivot);
            else
                System.out.println("Пары, дающей искомую сумму, не существует");
        }
    }
}
