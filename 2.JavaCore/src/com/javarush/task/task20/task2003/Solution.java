package com.javarush.task.task20.task2003;

import javafx.fxml.FXMLLoader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(runtimeStorage);
        prop.store(outputStream, "");
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);
        prop.forEach( (k, v) -> runtimeStorage.put( (String)k, (String)v) );
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
