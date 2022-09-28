package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        HashMap<Character, Integer> map = new HashMap<>();
        while (file.available() > 0) {
            char ch = (char) file.read();
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) + 1);
            } else
                map.put(ch, 1);
        }
        file.close();
        SortedMap<Character, Integer> sortedMap = new TreeMap<>(map);
        print(sortedMap);
    }
    public static void print(SortedMap<Character, Integer> map){

        for(Map.Entry<Character, Integer> pair : map.entrySet() )
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
