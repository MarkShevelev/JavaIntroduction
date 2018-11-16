package org.itstep;

import java.util.Scanner;

public class ArraysMultidimensional {
    public static void main(String[] args) {
        /**
         * Многомерные массивы - это структуры данных, в которых доступ к элементу осуществляется с помощью нескольких
         * индексов. Количество индексов определяется "размерностью" массива: двумерный (плоскость) - два индекса,
         * трёхмерный (пространство) - три индекса, четырёхмерный - четыре...
         *
         * Многомерные массивы - эффективное средство для решения задач, в которых естественным образом данные разбиваются
         * на связанные группы.
         * */

        //предположим нам дана карта городов, на которой размечены дороги и указаны расстояния
        // A B C D - города
        // A-B = 10  между городами A и B есть дорога длиной 10
        // A-C = 10
        // A-D = 10
        // B-C = 15
        // B-D = 25
        // C-D = 15
        //такой список удобно представить двумерным массивом, где первый индекс - номер одного города, а второй - другого,
        //значение - расстояние между городами
        if (false) {
            int[][] intercitiesRoads = null; //при объявлении мы указали две пары скобок!
            intercitiesRoads = new int[4][4]; //двумерный массив, каждый элемент определяется парой индексов
            //всего в таком массиве 4*4 = 16 Элементов

            //используем два индекса для доступа к элементу массива
            //как и у обычных массивов, первый элемент имеет индекс 0
            intercitiesRoads[0][0] = 0; //из города A в город A можно попасть мгновенно

            //так как массив размещается в динамической памяти, то его элементы инициализируются нулями

            //заполним данными массив
            intercitiesRoads[0][1] = intercitiesRoads[1][0] = 10; //дорога из A в B ведёт и обратно
            intercitiesRoads[0][2] = intercitiesRoads[2][0] = 10;
            intercitiesRoads[0][3] = intercitiesRoads[3][0] = 10;

            intercitiesRoads[1][2] = intercitiesRoads[2][1] = 15;
            intercitiesRoads[1][3] = intercitiesRoads[3][1] = 25;

            intercitiesRoads[2][3] = intercitiesRoads[3][2] = 15;


            String[] names = {"A","B","C","D"};
            //Выведем информацию в виде таблицы, т.е разобьём дороги по группам: города и

            //шапка
            System.out.print("   |");
            for (String name : names) System.out.print("  " + name + "  |");
            System.out.println();
            System.out.println("---|-----|-----|-----|-----|");

            //тело
            int nameIdx =0;
            for (int[] row : intercitiesRoads) { //обратите внимание, что элементом двумерного массива является одномерный массив
                System.out.print(" " + names[nameIdx++] + " |");
                for (int distance : row) System.out.printf("%3d  |",distance);
                System.out.println();
            }
        }

        //подробнее о синтаксисе многомерных массивах
        if (false) {
            int[][] twoDimArr = null; //переменная, объявляемая с типом "двумерный массив" является ссылочной
            twoDimArr = new int[3][3]; //создание нового массива в памяти, инициализируется нулями

            //обход двумерного массива удобно совершить с помощью двух вложенных циклов
            for (int i = 0; i != 3; ++i) {  //выбираем ряд
                for (int j = 0; j != 3; ++j) //выбираем элемент в ряду
                    System.out.print(twoDimArr[i][j]);
                System.out.println();
            }

            //обходы с перестановкой индексов не равноправны
            //последовательный доступ к элементам массива с изменением последнего индекса осуществляется быстрее, чем с изменением первого
            //это связано с тем, что двумерный массив, на самом деле, является набором массивов!

            int[][] anotherArray = null;
            anotherArray = new int[2][]; //мы указали только первый размер, т.е. мы определили, что будет два ряда,
            // но сами ряды не инициализированны
            System.out.println(anotherArray[0]); //печатает null
            //System.out.println(anotherArray[0][0]); //Null Pointer Exception

            //мы можем инициализировать ряды массивами разных размеров
            anotherArray[0] = new int[1];
            anotherArray[1] = new int[2];

            //двумерный массив хранит длину именно основного массива, содержащего ссылки на другие массивы
            System.out.println(anotherArray.length);
            //а уже внутренние массивы хранят свою длину
            System.out.println(anotherArray[0].length);
            System.out.println(anotherArray[1].length);

            //как и одномерный массив, двумерный массив может быть инициализирован при объявлении
            int[][] thirdArray = { {0,1,2}, {0,1,2,3}, {0,1,2,3,4} };
            System.out.println(thirdArray.length);
            for (int[] arr : thirdArray)
                System.out.println(arr.length);
        }

        //рисуем гистограмму
        if (false) {
            char[][] picture = null; //массив, в котором храним отображение
            int[] data = null;       //массив, в котором храним данные

            Scanner sc = new Scanner(System.in);
            System.out.println("Введите количество столбцов: ");
            int levelsNum = sc.nextInt();

            data = new int[levelsNum];
            System.out.println("Введите " + levelsNum + " уровней: ");
            for (int cnt=0; cnt!=levelsNum; ++cnt)
                data[cnt] = sc.nextInt();

            //необходимо найти максимальный уровень, чтобы понять высоту отображения
            int maxLevel = data[0];
            for (int lvl : data) maxLevel = lvl > maxLevel ? lvl : maxLevel;

            //в каждом ряду столько символов, сколько столбцов,
            //а всего столбцов столько, какова высота максимального уровня
            picture = new char[maxLevel][levelsNum];

            //заполняем данный о символах
            //если уровень в столбце превышает текущий, то ставим * иначе пробел
            for (int level = 0; level != maxLevel; ++level)
                for (int column=0; column!=levelsNum; ++column)
                    picture[maxLevel-level-1][column] = data[column] > level ? '*' : ' ';

            for(char[] line : picture) {
                for (char ch : line)
                    System.out.print(ch + " ");
                System.out.println();
            }
        }

        //массивы бОльших размерностей
        if (false) {
            String[][][] dataCube = null;
            dataCube = new String[4][][]; //массив из трёх ссылок на двумерные массивы
            for (int plain = 0; plain != dataCube.length; ++plain) //обходим плоскости в кубе, каждая плоскость - таблица
                dataCube[plain] = new String[3][]; //создаём массив из двух ссылок на ряды, сами ряды пока не известны

            for (int plain = 0; plain != dataCube.length; ++plain)
                for (int row = 0; row != dataCube[plain].length; ++row)
                    dataCube[plain][row] = new String[2]; //для каждой плоскости в каждом ряду создаём массив строк

            for (int plain = 0; plain != dataCube.length; ++plain)
                for (int row = 0; row != dataCube[plain].length; ++row)
                    for (int column = 0; column != dataCube[plain][row].length; ++column)
                        dataCube[plain][row][column] = new String("Abba"); //инициализируем данные массива в каждом ряду кажой плоскости

            //выводим данные
            for (String[][] plain : dataCube) {
                for (String[] row : plain) {
                    for (String element : row)
                        System.out.print(element + "|");
                    System.out.println();
                }
                System.out.print(System.lineSeparator() + System.lineSeparator());
            }
        }
    }
}
