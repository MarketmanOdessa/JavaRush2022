package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file;
        while (!(file = reader.readLine()).equals("exit")) {
            ReadThread thread = new ReadThread(file);
            thread.start();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName)  {
            this.fileName = fileName;
        }
        public void run() {
            try {
                BufferedReader filereader = new BufferedReader(new FileReader(fileName));
                int b;
                List<Integer> integers = new ArrayList<>();
                TreeMap<Integer, Integer> map = new TreeMap<>();


                while ((b = filereader.read()) != -1) {
                    integers.add(b);
                }

                int count;

                for (Integer integer : integers) {
                    if (map.containsKey(integer)) {
                        count = map.get(integer);
                        map.put(integer, count+1);
                    }
                    else {
                        map.put(integer, 1);
                    }
                }

                int max = 0;
                int by = 0;

                for (Map.Entry<Integer, Integer> item : map.entrySet()) {
                    if (item.getValue() > max) {
                        by = item.getKey();
                        max = item.getValue();
                    }
                }

                resultMap.put(fileName, by);

                filereader.close();
            }
            catch (IOException ioex) {
                ioex.getStackTrace();
            }

        }
    }
    }

