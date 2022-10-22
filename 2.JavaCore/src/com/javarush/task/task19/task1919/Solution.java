package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        // создаем map c автосортировкой
        TreeMap<String, Double> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                // считываем строку с файла и сразу разбиваем на массив, пробел в виде разделителя
                String[] buffer = reader.readLine().split(" ");
                // для читабельности кода получаем создаем строку key из получаем данные из строкового массива
                String key = buffer[0];
                // аналогично получаем значение value
                double value = Double.parseDouble(buffer[1]);
                // закидываем проверку на совпадающий элементы в map
                if (map.containsKey(key)) {
                    // по условию нужно суммировать value (значение) поэтому суммируем текущий
                    // value + value из коллекции map , через метод .get()
                    double updateValue = value + map.get(key);
                    // обновляем коллекцию map
                    map.put(key, updateValue);
                    continue;
                }
                // если совпадений нету, то значение просто добавляется в map
                map.put(key, value);
            }

            // через Map.Entry прогоняем нашу коллекцию и выводим данные в консоль
            for (Map.Entry<String, Double> str : map.entrySet()) {
                System.out.println(str.getKey() + " " + str.getValue());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
