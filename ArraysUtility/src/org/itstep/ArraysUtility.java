package org.itstep;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysUtility {
    public static void main(String[] args) {
        /**
         * Стандартная библиотека Java включает в себя большой набор стандартных средств для работы с массивами
         * Значительная их часть представлена статическими методами класса Arrays
         * */

        //заполнение массива
        if (false) {
            double[] data = new double[20]; //создаём массив с данным, заполненный значениями по умолчанию -> +0.d
            for (double d : data) System.out.printf("%.8f ", d);
            System.out.println();

            Arrays.fill(data,1.2); //заполнение массива числами 1.2

            for (double d : data) System.out.printf("%.8f ", d);
            System.out.println();

            Arrays.fill(data,10,20,-1.2); //заполнение части массива числами -1.2

            for (double d : data) System.out.printf("%.8f ", d);
            System.out.println();

            //Используя функцию из номера элемента в значение, можно установить элементы массива
            Arrays.setAll(data,i->3.5*i); //!!! Используется специальный синтаксис lambda !!!

            for (double d : data) System.out.printf("%.8f ", d);
            System.out.println();
        }

        //копирование данных массива
        if (false) {
            double[] dataA = new double[10];
            Arrays.fill(dataA,3.5);
            for (double d : dataA) System.out.printf("%.8f ", d);
            System.out.println();

            double[] dataB = Arrays.copyOf(dataA,20);
            for (double d : dataB) System.out.printf("%.8f ", d);
            System.out.println();

            double[] dataC = Arrays.copyOfRange(dataB,0,10);
            for (double d : dataC) System.out.printf("%.8f ", d);
            System.out.println();

            //при необходимости получения полной копии удобнее использовать встроенный метод .clone()
            double[] dataD = dataA.clone();
            for (double d : dataA) System.out.printf("%.8f ", d);
            System.out.println();
        }

        //в классе Arrays содержатся стандартные алгоритмы сортировки
        if (false) {
            //заполним массив случайными числами
            Random r = new Random();
            double[] data = new double[20];
            for (int pos=0; pos != data.length; ++pos)
                data[pos] = r.nextDouble();

            for (double d : data) System.out.printf("%.8f ",d);
            System.out.println();

            double[] testSortA = data.clone();
            Arrays.sort(testSortA); //стандартная сортировка

            for (double d : testSortA) System.out.printf("%.8f ",d);
            System.out.println();

            double[] testSortB = data.clone();
            Arrays.sort(testSortB,5,15); //сортировка в указанном диапазоне

            for (double d : testSortB) System.out.printf("%.8f ",d);
            System.out.println();
        }

        //если элементы можно сравнивать на точное совпадение, то уместно использовать бинарный поиск
        if (false) {
            int[] intData = new int[20];
            Random r = new Random();
            for (int pos=0; pos != intData.length; ++pos)
                intData[pos] = r.nextInt(100);

            for (int i : intData) System.out.printf("%3d",i);
            System.out.println();

            Arrays.sort(intData); //сначала следует отсортировать массив
            for (int i : intData) System.out.printf("%3d",i);
            System.out.println();

            Scanner sc = new Scanner(System.in);
            int toFind = sc.nextInt();

            int posFound = Arrays.binarySearch(intData,toFind); //бинарный поиск, возвращает позицию в массиве, содержащую искомый элемент

            if (posFound >= 0 && posFound < intData.length ) { //если позиция в пределах массива, то элемент найден
                System.out.printf("Значение %d было найдено в позиции %d" + System.lineSeparator(),toFind,posFound);
            } else { //иначе нет такого элемента
                System.out.println("Элемент не найден");
            }
        }

        //поиск и сортировку можно производить не только в массивах примитивных типов, но и в массивах объектов, например строк
        if (false) {
            String[] strings = {
                    "Москва","Санкт-Петербург","Новосибирс","Екатеринбург","Нижний Новгород","Казань",
                    "Челябинск", "Омск", "Самара", "Ростов-на-Дону", "Уфа", "Красноярск", "Пермь", "Воронеж"};

            Arrays.sort(strings); //сортируем строки по алфавиту
            for(String s : strings) System.out.println(s);
            System.out.println("****************************");

            Scanner sc = new Scanner(System.in);
            String toFind = sc.next();

            int posFind = Arrays.binarySearch(strings,toFind);
            if (posFind >= 0 && posFind < strings.length) {
                System.out.println("Искомый город найден в позиции " + posFind);
            } else {
                System.out.println("Город не найден");
            }
        }

        //некоторые операции можно производить параллельно, что повышает производительность
        if (false) {
            //параллельное заполнение массива
            double[] data = new double[20];

            for (double d : data)  System.out.printf("%.8f ",d);
            System.out.println();

            //заполнение массива происходит параллельно - по несколько элементов за раз
            Arrays.parallelSetAll(data,i->3.5*i);

            for (double d : data)  System.out.printf("%.8f ",d);
            System.out.println();

            Arrays.parallelPrefix(data,(x,y)->0.5*(y+x));

            for (double d : data)  System.out.printf("%.8f ",d);
            System.out.println();

            Random r = new Random();
            Arrays.setAll(data,i->r.nextDouble());
            for (double d : data) System.out.printf("%.8f ",d);
            System.out.println();

            Arrays.parallelSort(data);
            for (double d : data) System.out.printf("%.8f ",d);
            System.out.println();
        }
    }
}
