package org.itstep;

import java.util.Scanner;

public class BreakContinueLoops {
    public static void main(String[] args) {
        //в некоторых ситуациях возникает необходимость досрочно прекратить цикл, т.к. дальнейшее его выполнение не представляется полезным
        //тогда на помощь приходит ключевое слово break - остановка цикла
        //перепишем код, проверяющий, что слово - палиндром
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();

            boolean isPalindrom = true;
            for (int i=0, j=userString.length()-1; j > i; --j, ++i) {
                if (userString.charAt(i) != userString.charAt(j)) {
                    isPalindrom = false;
                    break; //дальнейший обход строки не представляет интереса, т.к. строка точно не палиндром
                }
            }

            System.out.println(isPalindrom?"Да":"Нет");
        }

        //с помощью break можно прервать бесконечный цикл
        //перепишем задачу на запрос положительного числа у пользователя
        if (false) {
            Scanner sc = new Scanner(System.in);
            int user_input;

            do {
                user_input = sc.nextInt();
                if (user_input > 0)
                    break; //если введено положительно число, то далее работа цикла не нужна
                System.out.println("Неверный ввод! Повторите, пожалуйста");//данный код недостижим при положительном вводе
            } while(true); //условие избыточно, т.к. при положительном вводе цикл будет прерван двумя строками выше
        }

        //проверим, состоит ли строка из одних и тех же символов: aaaaa или bbbb, или ::::
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();

            boolean sameSymbols = true;
            char symbol = userString.charAt(0);
            for (int pos = 1; pos < userString.length(); ++pos) {
                if (userString.charAt(pos) != symbol){
                    sameSymbols = false;
                    break;    //если нашли несовпадающий символ, далее двигаться по строке бесполезно
                }
            }

            System.out.println(sameSymbols?"Да":"Нет");
        }

        //иногда при заданном условии часть итерации необходимо пропустить, т.к. эта часть не целесообразна или опасна
        //подсчитаем в слове количество букв 'i'
        if (false) {
            Scanner sc = new Scanner(System.in);
            String userString = sc.next();

            int count = 0;
            for (int pos = 0; pos < userString.length(); ++pos) { //продвижение будет выполняться независимо от continue
                if ('i' != userString.charAt(pos)) continue;
                ++count; //данная строка будет пропущена, если условие выше выполнится и исполнится continue
            }
            System.out.println(count);
        }


        //запросим у пользователя 10 целых чисел и выведем квадратные корни тех, которые положительные
        if (false) {
            Scanner sc = new Scanner(System.in);

            for (int cnt = 0; cnt != 10; ++cnt) {
                double userNumber = sc.nextDouble();
                if (userNumber < 0.) continue; //если число отрицательно, нельзя допустить исполнения итерации далее
                System.out.println(Math.sqrt(userNumber));
            }
        }

        //continue не отменяет проверку для циклов с постусловием
        //напишем программу, которая запрашивает у пользователя действие: exit, add, diff, res
        //exit - завершение работы
        //add - прибавить к итогу число
        //diff - вычесть из итога число
        //res - вывести текущее значение итога
        if (false) {
            Scanner sc = new Scanner(System.in);

            boolean proceed = true;
            int result = 0;
            do {
                System.out.print("> ");
                String command = sc.next();

                if ("exit".equals(command)) {
                    proceed = false;
                    continue; //нет необходимости выполнять итерацию далее, т.к. мы нашли совпадающую команду
                }

                if ("add".equals(command)) {
                    int userNumber = sc.nextInt();
                    result += userNumber;
                    continue;
                }

                if ("diff".equals(command)) {
                    int userNumber = sc.nextInt();
                    result -= userNumber;
                    continue;
                }

                if ("res".equals(command)) {
                    System.out.println("Res: " + result);
                    continue;
                }

                //данный код недостижим, если введена верная команда
                System.out.println("Неизвестная команда");

            } while(proceed); //независимо от того, исполняется ли continue, данное условие проверяется
        }

        //если циклы вложены один в другой, то break выходит из ближайшего цикла
        //наиболее очевидным образом попытается узнать, содержится ли в строке заданная последовательность символов
        if (false) {
            Scanner sc = new Scanner(System.in);
            String haystack = sc.nextLine();
            String needle = sc.next();

            boolean found = false;
            int pos = -1;
            for (int hPos = 0; hPos < haystack.length()-needle.length()+1; ++hPos) {
                boolean foundLocal = true;
                for (int nPos = 0; nPos < needle.length(); ++nPos) {
                    if (needle.charAt(nPos) != haystack.charAt(hPos+nPos)) {
                        foundLocal = false;
                        break; //данный break прерывает только цикл обхода строки needle
                    }
                }
                if (foundLocal) {
                    found = true;
                    pos = hPos;
                    break; //данный break прерывает уже внешний цикл, если совпадение найдено
                }
            }

            System.out.println(found?"Найдено совпадение в позиции " + pos:"Совпадений не найдено");
        }

        //если необходимо прервать работу именно внешнего цикла, тогда можно использовать метку (поименовать цикл)
        //попробуем найти пару трёхзначных чисел таких, что их произведение делится на их сумму
        if (false) {
            all: //метка цикла
            for (int n = 101; n < 1000; ++n) {
                for (int k = n+1; k < 1000; ++k) { //два вложенных цикла позволяют перебрать все пары трёхзначных чисел
                    if (0 == ((long)k*(long)n)%(k+n) ) {
                        System.out.println(k + " " + n);
                        break all; //break прерывает цикл с отметкой all, т.е. внешний
                    }
                }
            }
        }

        //break с отметкой также может использоваться для того, чтобы выйти из вложенного switch
        if (false) {
            Scanner sc = new Scanner(System.in);

            main_loop:
            do {
                System.out.print("> ");
                switch(sc.next()) {

                    case "exit": {
                        System.out.println("Good Bye!");
                        break main_loop; //прерывает цикл, а не switch
                    }

                    case "hello": {
                        System.out.println("Hello!");
                        break; //прерывает switch, а н внешний цикл
                    }

                    default:
                        System.out.println("Неизвестная команда");
                }
            } while(true);
        }

        //выводим трёхзначные числа в таблицу по 5
        if (false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите первое число и количество рядов: ");

            int first = sc.nextInt();
            int rows  = sc.nextInt();

            all:
            for (int cnt = 0, num = first; cnt < rows && num < 1000; ++cnt) {
                switch(num%5) { //intentional fallthrough!!
                    case 0:
                        System.out.printf("%3d ",num++);
                    case 1:
                        System.out.printf("%3d ",num++);
                    case 2:
                        System.out.printf("%3d ",num++);
                    case 3:
                        System.out.printf("%3d ",num++);
                    case 4:
                        System.out.printf("%3d ",num++);
                        System.out.println();
                        break; //из switch (!)

                    default: //недостижимый код
                       break all; //выходим из цикла
                }
            }
        }
    }
}
