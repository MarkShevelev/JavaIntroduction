package org.itstep;

import java.util.Scanner;

public class StringsEssential {
    public static void main(String[] args) {
        //Строка String один из основных типов данных в JVM наряду с boolean, char, int, double и другими примитивами
        //Строка выражается в коде языка Java объектом типа String
        if (false) {
            //s - ссылка типа String, которая связывается с объектом-строкой в памяти JVM
            String s = "Hello"; //объект строки неявно строится на основе литеральной константы "Hello" автоматически
            System.out.println(s);
        }

        //явное создание объекта String можно произвести с помощью ключевого слова new
        if (false) {
            String s = new String("Hello"); //явное создание строки в памяти
            System.out.println(s);
        }

        //Т.к. строка - это объект, специальная единица организации кода, то для неё существует ряд "встроенных" функций - методов,
        //которые позволяют выполнять различные действия, например, узнать длину строки
        if (false) {
            String s = "Hello";
            System.out.println(s.length());
            System.out.println("Bla".length()); //строковые литералы неявно преобразуются в объекты, им тоже доступны функции-методы
        }

        //строки являются неизменяемыми (immutable), потому после создания строки невозможно изменить набор её символов
        if (false) {
            String sInit = new String("Hello");
            String sNew  = sInit.toUpperCase(); //специальная функция-метод переводит все буквы в верхний регистр
            System.out.println(sInit); //печатает Hello //строка не изменилась, но была создана новая
            System.out.println(sNew);  //печатает HELLO
        }

        //неизменяемость позволяет использовать так называемый "пул строк" (String Pool)
        //это специальное хранилище, где находятся литеральные строковые константы
        //если две ссылки указывают на две литеральных констаны, которые посимвольно равны,
        //то сравнение выдаст true
        if (false) {
            String sFirst = "Hello World!";
            String sSecond = "Hello World!";
            System.out.println(sFirst == sSecond); //печатает true
        }

        //Помните(!) Двойное равно сравнивает на совпадение ПРИМИТИВНЫЕ типы.
        //При попытке узнать совпадают ли два объекта двойное равно бесполезно!
        if (false) {
            String sFirst = new String("Hello World!");
            String sSecond = new String("Hello World!");
            System.out.println(sFirst == sSecond); //печатает false
        }

        //Для сравнения внутреннего содержания объектов, а не ссылок, в Java есть специальная функция-метод .equals,
        //которая есть у любого объекта
        if (false) {
            String sFirst = "Hello";
            String sSecond = new String("Hello");

            System.out.println(sFirst == sSecond); //печатает false
            System.out.println(sFirst.equals(sSecond)); //печатает true
        }

        //JVM предоставляет возможность добавлять строки в строковый пул, если есть такая необходимость,
        //например, важная оптимизация
        if (false) {
            String sFirst = new String("Hello"); //создаём новый объект не в пуле строк
            String sSecond = sFirst; //простое присваивание ссылок
            System.out.println(sFirst == sSecond); //true одинаковые ссылки

            String sThird = sFirst.intern(); //строка sFirst помещена в пул
            System.out.println(sThird == sFirst); //false ссылаются на разные объекты

            String sFourth = "Hello";
            System.out.println(sThird == sFourth); //true sFourth получает ссылку на строку "Hello" из пула, как и sThird
        }

        //Всего строка имеет более 60 встроенных функций-методов
        //Методы .equals .hashCode .toString .clone .getClass .finalize .notify .notifyAll .wait - есть у любого объекта!
        //К ним строка добавляет ещё 60 своих
        //например:
        if (false) {
            String s = "Hello";
            System.out.println(s.length());  //длина строки
            System.out.println(s.charAt(3)); //символ в ячейки с номером 3 считая от 0
            System.out.println(s.toLowerCase()); //в нижний регистр
            System.out.println(s.toUpperCase()); //в верхний регистр
            System.out.println(s.concat(" World!")); //соединение строк
            System.out.println(s.startsWith("H")); //проверяет: является ли первая буква заданным символом
            System.out.println(s.endsWith("o")); //проверяет: является ли последняя буква заданным символом
            System.out.println(s.contains("ello")); //проверяетЕ содержится ли внутри строки заданная подстрока
            System.out.println(s.replace("l","p")); //заменяет один символ на другой
            System.out.println(s.matches("[H,e,l,o]+"));//проверяет: соответствует ли строка заданному шаблону
            System.out.println(s.compareTo("Mello")); //проверяет: какая строка раньше идёт в словаре
            System.out.println(s.isEmpty()); //проверяет является ли строка пустой
            System.out.println(s.substring(2,s.length())); //вырезает из строки часть, которая начинается с позиции 2 и заканчивается в позиции s.length()-1
            //и ещё много-много всего =)
        }

        //конкатенация строк может быть выражена операцией +
        if (false) {
            String sFirst = "Hello";
            String sSecond = " ";
            String sThird = "World";
            String sFourth = "!";
            System.out.println(sFirst + sSecond + sThird + sFourth); //Hello World!
        }

        //использование + приводит к созданию новой строки
        //и при многократной конкатенации может возникнуть опасная ситуация многократного копирования
        if (false) {
            String all = "";
            for (int i =50000; i < 100000; ++i) //цикл обходит числа от 500000 до 99999, совершая конкатенацию с порождением новой строки
                all = all+i;
            //общее число операций копирования более миллиарда
            System.out.println(all);
        }

        //использование конкатенации операцией + может приводить запутанному коду
        if (false) {
            int i = 2, j = 5;
            System.out.println("Всего " + i + j + " верблюдов"); //Всего 25 верблюдов
            System.out.println(i + j + " верблюдов всего"); //7 верблюдов всего
        }

        //простые примеры работы со строками
        //выведем на экран строку, заменив вхождения символа 'пробел' на символ '$'
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.nextLine();

            for (int pos = 0; pos != userString.length(); ++pos) {
                char nextChar = userString.charAt(pos);
                System.out.print(nextChar == ' '?'$':nextChar);
            }
            System.out.println();
        }

        //записанный через нижнее подчёркивание идентификатор выводим в CamelCase
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();

            boolean capitalizeNext = false;
            for (int pos = 0; pos != userString.length(); ++pos) {
                if ('_' == userString.charAt(pos)) {
                    capitalizeNext = true;
                    continue;
                }

                char ch = userString.charAt(pos);
                System.out.print(capitalizeNext ? Character.toUpperCase(ch) : ch);
                capitalizeNext = false;
            }
            System.out.println();
        }

        //методом "грубой силы" (простого перебора) попытаемся найти в строке подстроку, которая является палиндромом,
        //читается одинокова справа налево и слева направо, наибольшей длины
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();

            int max = 0;
            for (int beginPos = 0; beginPos < userString.length()-1; ++beginPos) {
                for (int endPos = beginPos+1; endPos <= userString.length(); ++endPos) {
                    String temp = userString.substring(beginPos,endPos);
                    boolean isPalindrom = true;
                    for (int left = 0, right = temp.length()-1; left < right; ++left,--right) {
                        if (temp.charAt(left) != temp.charAt(right)) {
                            isPalindrom = false;
                            break;
                        }
                    }

                    if (isPalindrom) {
                        max = temp.length() > max ? temp.length() : max;
                        System.out.println(temp);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
