package org.itstep;

import java.util.Scanner;

public class ArraysEssential {
    public static void main(String[] args) {
        /**
         * Массивом называется структура данных, позволяющая обратиться к любому своему
         * элементу (структура произвольного доступа, равнодоступная структура данных)
         * за одинаковое кол-во действий.
         * Т.е. независимо от того сколько в массиве 
         * элементов 50 или 50 млн. количество действий для обращения к первому и 
         * последнему элементам будет одинаково.
         * 
         * Массивы - это удобный способ организации данных для доступа не по имени, а по индексу,
         * что позволяет легко организовать выполнение однотипных операций над
         * набором переменных.
         */
        
        /**
         * Задача: даны четыре положительных числа, требуется определить, 
         * возможно ли расставить между ними (и перед первым числом) 
         * знаки + / - так, чтобы в результате получить заданное число
         */
        
        //решим задачу, не используя массивов, оперируя переменными 
        if (false) {
            int x1, x2, x3, x4, pivot;
            Scanner sc = new Scanner(System.in);
            x1 = sc.nextInt();
            x2 = sc.nextInt();
            x3 = sc.nextInt();
            x4 = sc.nextInt();
            pivot = sc.nextInt();
            //нам пришлось набрать пять однотипных операций, т.к. каждая содержит
            //одтельное обращение к памяти по уникальному имени, которое необходимо указать
            
            //operations - число, в котором каждый бит означает операцию: 0->+ 1->-
            for (int operations = 0; operations != 16; ++operations) {
                int currentSet = operations;
                int sum = 0;
                sum += x1*(1 == (currentSet&1) ? -1 : 1);
                currentSet >>= 1;
                sum += x2*(1 == (currentSet&1) ? -1 : 1);
                currentSet >>= 1;
                sum += x3*(1 == (currentSet&1) ? -1 : 1);
                currentSet >>= 1;
                sum += x4*(1 == (currentSet&1) ? -1 : 1);
                //и вновь масса однотипных действий, которые хотелось бы выполнить в цикле
                
                if (pivot == sum) {
                    currentSet = operations;
                    System.out.print((1 == (currentSet&1) ? "-" : " +") + x1 + " ");
                    currentSet >>= 1;
                    System.out.print((1 == (currentSet&1) ? "-" : " +") + x2 + " ");
                    currentSet >>= 1;
                    System.out.print((1 == (currentSet&1) ? "-" : " +") + x3 + " ");
                    currentSet >>= 1;
                    System.out.print((1 == (currentSet&1) ? "-" : " +") + x4 + " ");
                    System.out.println(" = " + sum);
                    break;
                }        
            }
        }
        
        //теперь воспользуемся массивом, программа становится, очевидно, короче
        if (false) {
            int[] xs = new int[4];
            int pivot;
            Scanner sc = new Scanner(System.in);
            for (int pos = 0; pos != xs.length; ++pos)
                xs[pos] = sc.nextInt();
            pivot = sc.nextInt();
            
            for (int operations = 0; operations != 16; ++operations) {
                int sum = 0;
                for (int cnt=0; cnt != 4; ++cnt)
                    sum += xs[cnt]*(1 == (operations>>cnt&1) ? -1 : 1);
                if (pivot == sum) {
                    for(int cnt=0; cnt != 4; ++cnt)
                        System.out.print((1 == (operations>>cnt&1) ? "-" : "+")+xs[cnt]+" ");
                    System.out.println(" = " + sum);
                }
            }
        }
        
        //Разберём работу с массивом подробнее
        if (false) {
            int[] arr = null; //объявление ссылки на массив, ссылка не связана с памятью
            
            arr = new int[10]; //создание нового массива в памяти
            for (int pos = 0; pos != 10; ++pos) //счёт индексов начинается с нуля
                //в отличие от примитивных типов, массив создаётся уже инициализированным
                //значениями по умолчанию, для int это 0
                System.out.print(arr[pos] + " ");  //обращение к элементу массива через []
            System.out.println();
            
            //запись значений в массив также можно осуществить через []
            for (int pos = 0; pos != 10; ++pos)
                arr[pos] = pos*pos;            
            
            //массив имеет фиксированную длину, в него нельзя добавлять элементы
            //но можно создавать массивы любого неотрицательного размера
            Scanner sc = new Scanner(System.in);
            int userDefinedSize = sc.nextInt();
            int[] userDefinedArray = new int[userDefinedSize];
            
            //отрицательный размер приведёт к аварийному завершению программы
            //массив нулевого размера не содержит элементов
            
            //размер массива всегда можно узнать, используя dot syntax -> .length
            for (int pos = 0; pos != userDefinedArray.length; ++pos)
                userDefinedArray[pos] = pos*pos;
            
            for (int pos = userDefinedArray.length-1; pos >= 0; --pos)
                System.out.println(pos + "*" + pos + " = " + userDefinedArray[pos]);
            
            //ссылка на массив также может быть переназначена, если она не объявлена final
            userDefinedArray = new int[12]; //создаётся новый массив
            for (int pos = 0; pos != userDefinedArray.length; ++pos)
                System.out.print(userDefinedArray[pos] + " ");
            System.out.println();
            
            final int[] finalArray = new int[5];
            //finalArray = new int[10]; //ошибка компиляции
            //хотя массив и final, его элементы можно менять через присваивание
            for (int pos = 0; pos != finalArray.length; ++pos)
                finalArray[pos] = pos*pos*pos;
            for (int pos = 0; pos != finalArray.length; ++pos)
                System.out.println(pos + "*" + pos + "*" + pos + " = " + finalArray[pos]);
        }

        //объявление массива с инициализацией
        if (false) {
            int[] defaultInitArray = new int[10]; //массив инициализируется значениями по умолчанию int->0
            int[] progerInitArray = {1,1,1,1,1,1,1,1,1,1}; //массив инициализируется значениями из указанного набора

            //количество элементов в массиве с инициализацией выводится из количества элементов в наборе
            int[] threeElementArray = {-1,0,1};
            System.out.println(threeElementArray.length);

            int[] fiveElementArray = {0,1,2,3,4};
            System.out.println(fiveElementArray.length);

            int[] sevenElementArray = null;
            //инициализацию можно написать и при явном создании массива ключевым словом new
            sevenElementArray = new int[] {6,5,4,3,2,1,0};
            System.out.println(sevenElementArray.length);
        }
        
        //специальный цикл обхода
        if (false) {
            int[] numbers = new int[10];
            
            //если массив не предполагается изменять в цикле, а только читать значения,
            //то можно использовать специальный for для последовательностей
            for (int x : numbers)
                System.out.print(x+" ");
            System.out.println();
            
            //однако при необходимости изменять элементы следует использовать обычный for
            for (int pos = 0; pos != numbers.length; ++pos)
                numbers[pos] = pos;
            
            for (int x : numbers)
                System.out.print(x + " ");
            System.out.println();
        }
        
        //хитрое объявление
        if (false) {
            //Java позаимствовала из С интересный спобоб объявления массивов
            int iVar, iArr[], anotherVar, anotherArr[];
            //iVar и anotherVar - переменные типа int
            //iArr и anonterArr - ссылки на массивы, хранящие наборы элементов типа int
            iVar = anotherVar = 10;
            iArr = anotherArr = new int[iVar];
        }
        
        //массивы можно объявлять не только от примитивных типов, но и от объектов,
        //например, строк
        if (false) {
            String[] words = null;
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            words = userInput.split(" ");
            for (String w : words)
                System.out.println(w + ": "+ w.length());
        }
    }
}
