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
    }
}
