package org.itstep;

import java.util.Scanner;

public class BitwiseOperations {
    public static void main(String[] args) {
        /**
         * bitwise operations - побитовые операции
         * Операции, позволяющие манипулировать отдельными битами данных
         * Применяются к примитивным целочисленным типам: byte, short, int, long, char
         *
         * ~ - инверсия битов, имеет такой же приоритет, как и логическое отрицание !
         *
         * >> - сдвиг вправо с копированием бита
         * >>> - сдвиг вправо с заполнением нулём
         * << - сдвиг влево с заполнением нулём
         * Сдвиги имеют более низкий приоритет, чем другие арифметические операции + - и т.д.
         * Но более высокий, чем операции сравнения == >  <= и т.д.
         * Приоритет операций одинаков, исполнение слева направо
         *
         * & - побитовое 'И' 00->0 01->0 10->0 11->1
         * ^ - исключающее 'ИЛИ' 00->0 01->1 10->1 11->0
         * | - побитовое 'ИЛИ' 00->0 01->1 10->1 11->1
         * Приоритет более низкий, чем у сравнений, но более высокий, чем у логических && ||
         * Не стоит путать побитовые и логические операции! Побитовые не вычисляются сокращённо
         *
         * Присваивающие аналоги:
         * ~= &= ^= |= <<= >>= >>>= - смысл и приоритет соответствует арифметическим сокращённым операциям += -= и т.д.
         *
         * */

        //Выведем на экран обратную двоичную запись числа, используя деление на два и побитовые операции
        if (false) {
            Scanner sc = new Scanner(System.in);
            long userInput = sc.nextLong();

            //деление
            for (long num = userInput; num != 0; num/=2)
                System.out.print(num%2);
            System.out.println();

            //побитовые операции
            for (long num = userInput; num != 0; num >>= 1)
                System.out.print(num&1);
            System.out.println();

            //специальная функция, создающая строку для двоичной записи числа
            System.out.println(Long.toBinaryString(userInput));
            //с ведущими нулями
            System.out.println( String.format("%64s",Long.toBinaryString(userInput)).replace(' ','0') );
        }

        //с помощью битовых операций можно компактно записывать данные, а затем раскодировать обратно
        if (false) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();

            //кодируем два int в одном long
            long al = a;             //в младшие биты записываем данные из a
            long bl = (long)b<<32; //в старшие биты записываем данные из b
            long code = al|bl;       //побитово записываем в одно число, теперь два int закодированы в long
            System.out.println(code);

            //декодируем long в два int и найдём сумму
            int ai = (int)(0x00000000FFFFFFFFL&code); //выделяем младщие биты, накладывая 'маску'
            int bi = (int)((0xFFFFFFFF00000000L&code)>>32); //выделяме старшие биты
            System.out.println(ai+bi);
        }

        /**
         * Битовые операции могут использоваться для создания более оптимальных алгоритмов при работе с числами
         * */
        //Задача: проверить, является ли число степенью двойки?
        if (false) {
            Scanner sc = new Scanner(System.in);
            long userInput = sc.nextLong();

            long num = userInput;
            //если число - степень двойки, то в его побитовом представлении содержится ровно одна единица
            //вычитание единицы приведёт к тому, что этот разряд станет нулём, а все младше него - единицами
            //побитовое перемножение даст ноль, т.к. старше этой единственной единицы ничего нет
            System.out.println(0 == (num&(num-1)) ? "Степень двойки":"Нет");
        }

        //остаток от деления на степень двойки
        if (false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите положительное число и степень: ");
            int userNum = sc.nextInt();
            int userExp = sc.nextInt();

            System.out.println(userNum&(userExp-1));
        }

        //двоичное возведение в степень
        if (false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите основание и целую положительную степень: ");
            double userBase = sc.nextDouble();
            int userExp = sc.nextInt();

            double res = 1.;
            double base = userBase;
            int exp = userExp;
            while (exp != 1) {
                if (1 == (exp&1))
                    res *= base;
                base *= base;
                exp >>= 1;
            }

            System.out.println(res*base);
        }

        //операция ^ - исключающее или - eXcluding OR - XOR позволяет 'запоминать разность' между данными
        //это свойство можно использовать, например, для обмена значениями без дополнительной переменной
        if (false) {
            //обмен с использованием доп. памяти
            {
                int a = 5;
                int b = -5;
                int tmp;
                System.out.println(a + " : " + b);

                tmp = a;
                a = b;
                b = tmp;
                System.out.println(a + " : " + b);
            }

            //обмен с использованием ^
            {
                int a = 5;
                int b = -5;
                System.out.println(a + " : " + b);

                a ^= b; //в а хранится побитовая разность между а и b
                b ^= a; //восстанавливается значение переменной a, но внутри b
                a ^= b; //восстанавливается значение переменной b, но внутри a
                System.out.println(a + " : " + b);
            }
        }

        //с помощью xor найдём в строке непарный символ
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();

            char symbol = 0;
            for (int pos =0; pos != userString.length(); ++pos)
                symbol ^= userString.charAt(pos);

            System.out.println(symbol);
        }

        //простейшее шифрование
        if (false) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите строку для шифрования: ");
            String userString = sc.nextLine();

            System.out.println("Введите ключ шифрования: ");
            String userKey = sc.next();

            //шифрование
            StringBuilder builder = new StringBuilder();
            for (int pos = 0; pos != userString.length(); ++pos)
                builder.append((char)(userString.charAt(pos)^userKey.charAt(pos%userKey.length())));

            System.out.println("Зашифрованная строка: " + builder.toString());

            //дешифрование
            System.out.print("Дешифрация: ");
            String cipher = builder.toString();
            for (int pos = 0; pos != userString.length(); ++pos)
                System.out.print((char)(cipher.charAt(pos)^userKey.charAt(pos%userKey.length())));
            System.out.println();
        }

        /**
         * Битовые представления чисел удобно использовать для переборов
         * */
        //Задание: вывести на экран все строки длинной 10, состоящие из символов 'A' и '/'
        if (false) {
            char ch1 = 'A', ch2 = '/';

            for (int start = 0; start != 2048; ++start) {
                for (int cnt = 0; cnt != 10; ++cnt)
                    System.out.print(0 == ((start >> cnt) & 1) ? 'A' : '/');
                System.out.println();
            }
        }

        //все подмножества множества
        if (false) {
            String str = "abcdefgh";

            for (int start = 0; start != 256; ++start) {
                for (int pos = 0; pos != str.length(); ++ pos)
                    if ( 1 == ((start >> pos)&1) ) System.out.print(str.charAt(pos));
                System.out.println();
            }
        }
    }
}
