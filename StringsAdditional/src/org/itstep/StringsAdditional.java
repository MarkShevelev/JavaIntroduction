package org.itstep;

import java.nio.CharBuffer;

public class StringsAdditional {
    public static void main(String[] args) {
        /**
         * Неизменяемость (immutability) и константность (final)
         * Ключевое слово final определяет поименованную переменную как константу,
         * что означает невозможность последующего деструктивного присваивания.
         * Объявление переменной с ключевым словом final позволяет установить 'защиту от дурака',
         * невозможность случайного изменения, а также может оказаться полезным с точки зрения оптимизаций.
         *
         * Однако неизменяемой становится значение примитивного типа: byte, short, int, long, char, 'reference'
         * Сам же объект, на который ссылается 'reference' может оказаться доступным к изменению.
         *
         * С другой стороны, если сслыка не объявлена как final, то объект, на который она ссылается может оказаться
         * неизменяемым. Т.е. изменение самого объекта может оказаться невозможным, но ссылка может быть переназначена.
         * */
        if (false) {
            String strRef = null; //определение ссылки с инициализацией, говорящей, что ссылка не связана с объектом
            strRef = new String("Hello String!"); //ссылка связывается с объектом
            System.out.println(strRef);

            //мы легко можем поменять ссылку
            strRef = new String("Hello another String!");
            System.out.println(strRef);

            //Однако любые действия со строкой приводят к порождению новой строки, старая строка остаётся неизменной
            //Т.е. мы никак не можем вывести на экран другую строку, пока не поменяем ссылку.
            //создаёт и печатает новую строку в верхнем регистре, но строка, с которой связана ссылка strRef остаётся неизменной
            System.out.println(strRef.toUpperCase());
            System.out.println(strRef);

            //объекты, которые невозможно поменять, называются immutable
            //String - immutalbe, т.е. нет таких функций, которые могут изменить данные строки
            //Ссылка, связанная с конкретным объектом String, всегда будет выводить на экран одно и то же.
        }

        if (false) {
            //Т.к. строки неизменяемы, то они не могут увеличить память, добавить к существующей строке символы нельзя
            //Операция конкатенации порождает новые строки
            String firstString = new String("One");
            String secondString = new String("Two");
            System.out.println(firstString.concat(secondString));
            System.out.println(firstString);

            //Многократная конкатенация может привести к существенным накладным расходам
        }

        if (false) {
            //Для того, чтобы работать с изменяемыми строками в Java есть специальные классы
            //StringBuffer - строка, внутреннее содержание которой может быть изменено
            //StringBuilder - строка, внутреннее содержание которой может быть изменено
            //StringBuffer - контроллирует доступ к внутренним данных из разных потоков, StringBuilder - нет

            {
                String s = new String("");
                long start = System.nanoTime();
                for (int i = 0; i != 70000; ++i)
                    s = s + i; //здесь происходит порождение нового объекта и переназначение ссылки
                long duration = System.nanoTime() - start;
                System.out.println(s.charAt(s.length() - 1) + " " + duration/1000000 + "ms");
            }

            {
                StringBuffer buffer = new StringBuffer();
                long start = System.nanoTime();
                for (int i = 0; i != 70000; ++i)
                    buffer.append(Integer.toString(i));
                long duration = System.nanoTime() - start;
                System.out.println(buffer.charAt(buffer.length() - 1) + " " + duration/1000000 + "ms");
            }

            {
                StringBuilder builder = new StringBuilder();
                long start = System.nanoTime();
                for (int i = 0; i != 70000; ++i)
                    builder.append(Integer.toString(i));
                long duration = System.nanoTime() - start;
                System.out.println(builder.charAt(builder.length() - 1) + " " + duration/1000000 + "ms");
            }
        }

        if (false) {
            //Если поименованную память обозначить ключевым словом final,
            //то к ней нельзя будет повторно применить деструктивное присваивание
            /* //следующий код не компилируется
            final String s = "";
            for (int i=0; i != 70000; ++i)
                s = s + i; //данная операция невозможна! Нельзя переназначить ссылку на новый объект
            */

            //Однако StringBuffer и StringBuilder позволяют создавать новые строки путём мутации уже существующего
            //объекта, без изменения ссылок
            final StringBuffer buffer = new StringBuffer();
            for (int i = 0; i != 70000; ++i)
                buffer.append(Integer.toString(i));
            System.out.println(buffer.charAt(buffer.length()-1));

            final StringBuilder builder = new StringBuilder();
            for (int i = 0; i != 70000; ++i)
                builder.append(Integer.toString(i));
            System.out.println(buffer.charAt(builder.length()-1));

            //Таким образом, final ссылка не ограничивает использование объекта

            //Переназначение ссылки, однако, невозможно
            //buffer = new StringBuffer(); //код не компилируется
        }

        if (false) {
            //Для примитивных типов данных ключевое слово final приводит к невозможности их изменения,
            //т.к. они являются именами для памяти, а не для объектов
            final int i = 5;
            //++i;//код не компилируется, т.к. неявно вызывается присваивание, что запрещено
        }

        //Операции над StringBuffer
        if (false) {
            //StringBuffer можно создать различными способами
            StringBuffer strbuffEmpty = new StringBuffer();                //пустой буфер
            StringBuffer strbuffCapacity = new StringBuffer(1000);         //буфер с предварительно созданной памятью
            StringBuffer strbuffString = new StringBuffer("Hello World!"); //буфер с предварительно созданной строкой

            //изменение содержимого, путём вставки, добавления и замены
            strbuffEmpty.append("Hello World!");                       //добавление в конец
            strbuffCapacity.append("World!").insert(0,"Hello ");       //.insert - вставка в любую часть строки
            strbuffString.replace(6,strbuffString.length(),"Buffer!"); //замена часть строки другой строкой

            System.out.println(strbuffEmpty);
            System.out.println(strbuffCapacity);
            System.out.println(strbuffString);

            //изменение отдельного символа в строке
            strbuffEmpty.setCharAt(2,'p');   //установка символа в определённой позиции
            strbuffEmpty.setCharAt(3,'p');
            System.out.println(strbuffEmpty);

            //удаление символов
            strbuffCapacity.deleteCharAt(0);  //удаление символа на определённой позиции
            strbuffCapacity.delete(0,5);      //удаление диапазона символов
            System.out.println(strbuffCapacity);

            //специальные изменения
            strbuffString.reverse();      //обращение строки
            strbuffString.setLength(7);   //урезание строки до определённого размера
            System.out.println(strbuffString);
        }
        /**
         * StringBuffer - специальный класс, который жёстко ограничивает доступ к своим методам для разных потоков
         * Это приводит к накладным расходам
         *
         * StringBuilder - значительно более выгодный класс, он не синхронизирует доступ, что значительно ускоряеет работу
         * Предпочитайте StringBuilder, если нет причин изменять строку из разных потоков
         * */

        /**
         * Все классы для работы со строками поддерживают общий тип данных (интерфейс) - CharSequence
         * Что позволяет использовать их взаимо заменяемо во многих задачах
         * */

        /**
         * Начиная с Java 7 использование .substring() на строке порождает новую строку со своими собственными данными
         * Если необходимо создать read-only (только для чтения) объект, поддерживаемый теми же данными, что и строка,
         * используйте java.nio.CharBuffer
         * */
        if (false) {
            String s = new String("Hello World!");
            CharSequence hello = CharBuffer.wrap(s).subSequence(0,5);
            CharSequence world = CharBuffer.wrap(s).subSequence(6,s.length());
            System.out.println(hello);
            System.out.println(world);
        }
    }
}
