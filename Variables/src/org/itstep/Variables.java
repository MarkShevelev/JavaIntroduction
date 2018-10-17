package org.itstep;

public class Variables {
    public static void main(String[] args) {
        //ПОРЯДОК ИСПОЛНЕНИЯ
        if (false) {
            System.out.println("Hello Java!");      //#1исполняемые последовательно команды
            System.out.println("Hello Variables!"); //#2
            System.out.println("Hello Imperative!");//#3
        }

        if (false) {
            //точка с зяпятой ставится в конце команды, отделяя её от других
            //компилятор Java при преобразовании исходного кода в байт-код
            //не воспринимает переводы строк
            System.out.println("Hello Java!");System.out.println("Hello Variables!");System.out.println("Hello Imperative");
        }

        //ПЕРЕМЕННЫЕ
        if (false) {
            int i; //поименованная область памяти, уникально выделенная
            i = 3; //основная операция - деструктивное присваивание
            System.out.println(i); //получение значения по имени

            i = 4;  //заменяем значение
            System.out.println(i); //печатаем новое значение

            //переменные одного типа можно объявлять вместе
            int firstVar, secondVar;
            firstVar = 3; secondVar = 5;
            System.out.println(firstVar); System.out.println(secondVar);
        }

        //проблемы инициализации
        if (false) {
            int i = 3; //инициализация - первое присваивание - можно сделать прямо при определении переменной
            System.out.println(i);

            //Java безопасный язык, который не позволяет действий с непредсказуемым результатом
            int j;
            //System.out.println(j); //ошибка компиляции! невозможно читать неинициализированную переменную
        }

        //КОНСТАНТЫ - неизменяемые данные
        if (false) {
            final int constantData; //ключевое слово final запрещает многократную перезапись данных
            constantData = 5; //Всё хорошо, т.к. это первое присваивание - инициализация

            //constantData = 3; //ошибка компиляции! нельзя повторно положить значение в константу

            final int cvIntFirst = 3, cvIntSecond = 5, cvIntThird = 13; //можно объявлять несколько констант вместе
        }

        //помните:
        //1) переменная сохраняет значение;
        //2) присваивание перезаписывает данные;
        //3) вычисление значения происходит в момент присваивания
        if (true) {
            int variable; //объявили переменную, но пока нет значения
            int dataA = 4, dataB = -5; //объявляем и сразу инициализируем пару переменных

            variable = dataA + dataB;  //сумма вычисляется в данной строке и результат сохраняется в variable -> -1
            dataA = 5; dataB = 10;     //изменение данных dataA и dataB не влияет на значение, которое хранится в variable

            System.out.println(variable);
        }
    }
}
