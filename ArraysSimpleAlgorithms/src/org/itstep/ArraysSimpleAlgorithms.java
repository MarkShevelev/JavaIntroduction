package org.itstep;

import java.util.Random;
import java.util.Scanner;

public class ArraysSimpleAlgorithms {
    public static void main(String[] args) {
        /**
         * Задача: поиск максимума
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

            int max; //специальная ячейка, где сохраняем текущий максимум
            max = randomArray[0]; //предполагаем, что максимум - это самый первый элемент

            //необходимо проверить наше предположение...
            //сравним предполагаемый максимум с остальными элементами
            for (int pos=1; pos != randomArray.length; ++pos)
                if (randomArray[pos] > max) //если текущий элемент больше максимуму, заменим значений в переменной max
                    max = randomArray[pos];

            System.out.println("Max: " + max);
        }

        /**
         * Задача: нахождение суммы элементов
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

            int sum = 0; //переменная аккумулятор, в которую мы будем добавлять элементы массива
            for (int pos=0; pos != randomArray.length; ++pos) //обход всех элементов
                sum += randomArray[pos];

            System.out.println("Sum: " + sum);
        }

        /**
         * Задача: линейный поиск
         * Найти в массиве позицию, в которой находится заданный элемент
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

            Scanner sc = new Scanner(System.in);
            int toFind = sc.nextInt();

            int posFound; //переменная, в которую сохраняем позицию элемента
            for (posFound=0; posFound != randomArray.length; ++posFound) //цикл перебирает все возможные позиции
                //если найдено совпадение заданного элемента с элементом массива, завершаем цикл поиска
                if (toFind == randomArray[posFound])
                    break;

            //если мы прошли весь массив и ни разу совпадений не было,
            //то цикл завершится со значением posFound == randomArray.length
            if(posFound == randomArray.length)
                System.out.println("Элемент в массиве не найден");
            else
                System.out.println("Элемент найден в позиции " + posFound);
        }

        /**
         * Задача: обращение массива
         * Превратить массив из элементов, например, 1 2 3 4 5
         * в массив 5 4 3 2 1
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

            //при "обращении массива" первый элемент становится последним, второй - предпоследним и т.д.
            //следовательно необходимо обменять местами симметричные элементы
            //используем два индекса:
            //left движется от 0 вверх (увеличивается)
            //right движется от .length-1 вниз (уменьшается)
            for(int left = 0, right = randomArray.length-1; left < right; ++left, --right) {
                //на каждом шаге обмениваем левый и правый элементы местами
                //простой обмен через третью переменную
                int tmp = randomArray[left];
                randomArray[left] = randomArray[right];
                randomArray[right] = tmp;
            }

            //выводим результат
            for(int x : randomArray)
                System.out.printf("%5d",x);
            System.out.println();
        }

        /**
         * Задача: фильтрация элементов
         * Пользователь выбирает фильтр: только положительные или только чётные, а программа выводит элементы
         * удовлетворяющие условию
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

            Scanner sc = new Scanner(System.in);
            //выбор условия
            System.out.println("Выберите фильтр: even или positive");
            System.out.print("> ");
            String choice = sc.next();

            if ("even".equals(choice)) {
                for (int pos=0; pos != randomArray.length; ++pos) //перебор всех элементов
                    if (0 == randomArray[pos]%2) //выводим только те элементы, которые удовлетворяют условию
                        System.out.printf("%5d",randomArray[pos]);
            }

            if ("positive".equals(choice)) {
                for (int pos=0; pos != randomArray.length; ++pos)
                    if (randomArray[pos] > 0)
                        System.out.printf("%5d",randomArray[pos]);
            }
        }

        /**
         * Задача: перераспределение элементов в массиве
         * Пользователь вводит значение.
         * Программа переставляет элементы таким образом, что значения меньше заданного оказываются слева,
         * а большие заданного - справа
         * 1 4 8 -9 -8 0 7 11 34 5 -3
         * 6
         * 1 4 -3 -9 -8 0 5 11 34 7 8
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

            Scanner sc = new Scanner(System.in);
            int pivot = sc.nextInt();

            //вводим пару индексов:
            //left - движется от 0 вверх (увеличивается), right - движется от .length-1 вниз (уменьшается)
            int left = 0, right = randomArray.length-1;

            while (left < right) { //перехлёст индексов означает, что элементы перераспределены
                if (randomArray[left]<pivot) { //если элемент под левым индексом на своём месте, то продвигаемся с центру
                    ++left;
                    continue;
                }

                if (randomArray[right]>pivot) { //если элемент под правым индексом на своём месте, то продвигаемся с центру
                    --right;
                    continue;
                }

                if (left <= right) { //если мы добрались до этой точки, то и левый и правый элементы смотрят на неверные значения
                    //обменяем их и они будут верные!
                    int tmp = randomArray[left];
                    randomArray[left] = randomArray[right];
                    randomArray[right] = tmp;
                    //теперь они на верных местах! смещаем индексы
                    ++left;
                    --right;
                }
            }

            //наглядный вывод элементов массива
            for(int x : randomArray)
                System.out.printf("%5d",x);
            System.out.println();

            System.out.println("left = " + left + "   right = " + right);
        }

        /**
         * Задача: пузырьковая сортировка
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


            //идея состоит в перестановке элементов, которые стоят "неврно", не в том порядке, как требуется
            for (int j=0; j != randomArray.length-1; ++j) //проходы следует осуществить столько раз, какова длина массива
                for (int i=0; i != randomArray.length-1-j; ++i) //внутренний проход, переставляем неверные элементы
                    if (randomArray[i] > randomArray[i+1]) {
                        int tmp = randomArray[i];
                        randomArray[i] = randomArray[i+1];
                        randomArray[i+1] = tmp;
                    }

            //наглядный вывод элементов массива
            for(int x : randomArray)
                System.out.printf("%5d",x);
            System.out.println();
        }
    }
}
