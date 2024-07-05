package org.aston.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Напишите абстрактный класс BaseConverter,
        // у класса должен быть абстрактный метод convert(double celsius),
        // который возвращает значение в нужных единицах для конвертации из градусов по Цельсию в Кельвины,
        // Фаренгейты, и т.п. Создайте отдельные классы-наследники (KelvinConverter, FahrenheitConverter)
        // с реализацией метода convert, который будет принимать на вход значение в цельсиях и переводить их в
        // соответствующие градусы (Кельвины, Фаренгейты).

        //Реализовать класс Адаптер, который в конструктор будет принимать объект
        // соответствующего конвертора и конвертировать градусы в соответствующие единицы.

        //Реализовать метод, createConverter, который будет на вход принимать enum для определения
        // типа конвертера и возвращать нужный объект-конвертера для конвертации

        //        Adapter adapter = new Adapter(new FahrenheitConverter());
        //        double result = adapter.convertTo(5.4);
        //        System.out.println(result);

        //Отсортировать список людей по возрасту. Данные человека считать из строки “Иванов Иван Иванович, 2001 г.р.”,
        // “Сергеев Сергей Сергеевич, 1980 г.р.”, “Петров Петр Петрович, 2018 г.р.”

        String[] peoples = {
                "Иванов Иван Иванович, 2001 г.р.", "Сергеев Сергей Сергеевич, 1980 г.р.", "Петров Петр Петрович, 2018 г.р."
        };

        sort(peoples);
        for (var key : peoples) {
            System.out.println(key);
        }
    }

    public static void sort(String[] array) {
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(getYear(o1), getYear(o2));
            }
        });
    }

    public static int getYear(String string) {
        for (var str : string.split(" ")) {
            if (str.matches("[0-9]{1,4}")) return Integer.parseInt(str);
        }
        throw new RuntimeException("Нет года рождения");
    }
}