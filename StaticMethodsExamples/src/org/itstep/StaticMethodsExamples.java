package org.itstep;

import java.util.Scanner;

public class StaticMethodsExamples {
    /**
     * Рассмотрим следующую задачу:
     * Пользователь вводит массив целых чисел фиксированного размера, количество элементов определяет пользователь
     * Затем совершает одну из нескольких операций фильтрации: оставить чётные, оставить положительные, оставить в промежутке
     * Пользователь также может вернуться к изначальному массиву или ввести новые 10 чисел
     * Программа завершается вводом специальной команды
     * */


    public static void main(String[] args) {
        /**
         *  Программа, написанная без использования методов, сложна в понимании логики происходящего,
         *  содержит массу повторяющегося кода (copy-paste), чрезвычайно неудобна для тестирования и внесения изменений
         * */
        if (false) {
            //Начальная настройка программы
            int[] mainArray = null; //ссылка на основной массив
            int[] filteredArray = null; //ссылка на рабочий массив
            int filteredArrayLast = 0; //позиция, начиная с которой в массиве находятся неверные элементы: 0 - все неверные, .length - все верные
            Scanner sc = new Scanner(System.in); //инициализируем сканнер для чтения данных от пользователя

            //запрашиваем у пользователя размер массива и элементы
            {
                System.out.println("Введите количество элементов в массиве и их значения: ");
                //проверяем ввод данных пользователем
                int mainArrayLength = -1;
                do {
                    mainArrayLength = sc.nextInt();
                    if (mainArrayLength > 0) break;
                    System.out.println("Размер массива должен быть положительным");
                } while (true);

                System.out.println("Введите " + mainArrayLength + " значений элементов: ");
                mainArray = new int[mainArrayLength]; //массив заполняется нулями
                for (int pos = 0; pos != mainArray.length; ++pos) //переписываем элементы массива в значения пользователя
                    mainArray[pos] = sc.nextInt();
                filteredArray = mainArray.clone(); //изначально отфильтрованный массив идентичен основному
                filteredArrayLast = filteredArray.length; //и все элементы верны
            }

            //основная часть программы, цикл команд
            String command = null;  //команда пользователя
            command_loop:
            do {
                System.out.println("> "); //приветствие
                command = sc.next();
                switch(command) { //проверяем введённую строку на совпадение с идентификаторами команд
                    case "exit": //выход из программы
                        System.out.println("Good Bye!");
                        break command_loop; //прерывается весь цикл, а не только switch

                    case "new": { //запрос нового массива
                        //мы не можем вернуться к уже пройденному коду... приходится его переписать...
                        System.out.println("Введите количество элементов в массиве и их значения: ");
                        int mainArrayLength = -1;
                        do {
                            mainArrayLength = sc.nextInt();
                            if (mainArrayLength > 0) break;
                            System.out.println("Размер массива должен быть положительным");
                        } while (true);
                        System.out.println("Введите " + mainArrayLength + " значений элементов: ");
                        mainArray = new int[mainArrayLength];
                        for (int pos = 0; pos != mainArray.length; ++pos)
                            mainArray[pos] = sc.nextInt();
                        filteredArray = mainArray.clone();
                        filteredArrayLast = filteredArray.length;
                    }
                    break;

                    case "positive": {//оставить только положительные
                        int last = 0;
                        for (int curr = 0; curr != filteredArrayLast; ++curr)
                            if (filteredArray[curr] > 0)
                                filteredArray[last++] = filteredArray[curr];
                        filteredArrayLast = last;

                        //выводим массив
                        if (filteredArrayLast > 0) {
                            for (int pos = 0; pos != filteredArrayLast; ++pos)
                                System.out.print(filteredArray[pos] + " ");
                            System.out.println();
                        } else
                            System.out.println("Массив пуст...");
                    }
                    break;

                    case "even": { //оставить только чётные
                        int last = 0;
                        for (int curr = 0; curr != filteredArrayLast; ++curr)
                            if (0 == filteredArray[curr]%2)
                                filteredArray[last++] = filteredArray[curr];
                        filteredArrayLast = last;

                        //так как мы не можем вернуться к предыдущему коду, то вынуждены его повторить...
                        if (filteredArrayLast > 0) {
                            for (int pos = 0; pos != filteredArrayLast; ++pos)
                                System.out.print(filteredArray[pos] + " ");
                            System.out.println();
                        } else
                            System.out.println("Массив пуст...");
                    }
                    break;

                    case "range": { //оставить в диапазоне
                        int min,max; //сначала получим от пользователя отрезок min <= max
                        do {
                            System.out.println("Введите пару целых чисел min и max (min <= max): ");
                            min = sc.nextInt();
                            max = sc.nextInt();
                            if (min <= max) break;
                        } while(true);

                        int last = 0;
                        for (int curr = 0; curr != filteredArrayLast; ++curr)
                            if (filteredArray[curr] >= min && filteredArray[curr] <= max)
                                filteredArray[last++] = filteredArray[curr];
                        filteredArrayLast = last;

                        if (filteredArrayLast > 0) {
                            for (int pos = 0; pos != filteredArrayLast; ++pos)
                                System.out.print(filteredArray[pos] + " ");
                            System.out.println();
                        } else
                            System.out.println("Массив пуст...");
                    }
                    break;

                    default:
                        System.out.println("Неизвестная команда");
                }
            } while (true);
        }

        /**
         * Программа, использующая делегацию повторяющихся и логически завершённых блоков кода методам, легче и быстрее
         * читается, удобна для внесения изменений и детального (finer grained) тестирования.
         * */

        if (true) {
            //Начальная настройка программы
            int[] mainArray = null; //ссылка на основной массив
            int[] filteredArray = null; //ссылка на рабочий массив
            int filteredArrayLast = 0; //позиция, начиная с которой в массиве находятся неверные элементы: 0 - все неверные, .length - все верные
            Scanner sc = new Scanner(System.in); //инициализируем сканнер для чтения данных от пользователя

            //создание нового массива, значительную часть работы берёт на себя newArray метод
            filteredArray = (mainArray = newArray(sc)).clone();
            filteredArrayLast = filteredArray.length;

            //основной цикл берёт на себя только необходимые обязанности: чтение команды, прерывание исполнения, замена основных данных
            String command = null;
            command_loop:
            do {
                System.out.print("> ");
                command = sc.next();
                switch(command) {
                    case "exit":
                        System.out.println("Good Bye!");
                        break command_loop;

                    case "new":
                        filteredArray = (mainArray = newArray(sc)).clone();
                        filteredArrayLast = filteredArray.length;
                        break;

                    case "positive":
                    case "even":
                    case "range":
                        //метод executeFilter принимает необходимые действия фильтрации или
                        filteredArrayLast = executeFilter(command,sc,filteredArray,filteredArrayLast);
                        break;

                    default:
                        System.out.println("Неизвестная команда");
                }
            } while (true);
        }
    }

    public static int[] newArray(Scanner sc) {
        int[] resultArray = null;
        System.out.println("Введите количество элементов в массиве и их значения: ");
        int mainArrayLength = readPositive(sc);

        System.out.println("Введите " + mainArrayLength + " значений элементов: ");
        resultArray = new int[mainArrayLength];
        for (int pos = 0; pos != resultArray.length; ++pos)
            resultArray[pos] = sc.nextInt();

        return resultArray;
    }

    public static int executeFilter(String filterName, Scanner sc, int[] filteredArray, int filteredArrayLast) {
        int last = 0;
        switch(filterName) { //проверяем введённую строку на совпадение с идентификаторами команд
            case "positive": {//оставить только положительные
                for (int curr = 0; curr != filteredArrayLast; ++curr)
                    if (filteredArray[curr] > 0)
                        filteredArray[last++] = filteredArray[curr];
            }
            break;

            case "even": { //оставить только чётные
                for (int curr = 0; curr != filteredArrayLast; ++curr)
                    if (0 == filteredArray[curr]%2)
                        filteredArray[last++] = filteredArray[curr];
            }
            break;

            case "range": { //оставить в диапазоне
                int min,max; //сначала получим от пользователя отрезок min <= max
                do {
                    System.out.println("Введите пару целых чисел min и max (min <= max): ");
                    min = sc.nextInt();
                    max = sc.nextInt();
                    if (min <= max) break;
                } while(true);
                for (int curr = 0; curr != filteredArrayLast; ++curr)
                    if (filteredArray[curr] >= min && filteredArray[curr] <= max)
                        filteredArray[last++] = filteredArray[curr];
            }
            break;
        }
        printArrayInRange(filteredArray,0,last);
        return last;
    }

    public static void printArrayInRange(int[] arr, int from, int to) {
        if (to > from) {
            for (int pos = from; pos != to; ++pos)
                System.out.print(arr[pos] + " ");
            System.out.println();
        } else
            System.out.println("Массив пуст...");
    }

    public static int readPositive(Scanner sc) {
        int userInput = -1;
        do {
            userInput = sc.nextInt();
            if (userInput > 0) break;
            System.out.println("Размер массива должен быть положительным");
        } while (true);
        return userInput;
    }
}
