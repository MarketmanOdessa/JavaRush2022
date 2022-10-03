package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static boolean chislo (String string){
        try{
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e){
            return  false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(r.readLine());
        FileWriter file2 = new FileWriter(r.readLine());

        BufferedReader reader = new BufferedReader(file1);
        BufferedWriter writer = new BufferedWriter(file2);
        String str = "";

        while (file1.ready())
        {
            char strok = (char) file1.read();
            str += String.valueOf(strok).toLowerCase();
        }
        str = str.replaceAll("\\p{Punct}", " ");
        str = str.replaceAll("\n", " ");
        String[] massiv = str.split(" ");

        for (String s : massiv)
        {
            s = s.trim();

            if (chislo(s))
            {
                file2.write(s + " ");
            }

        }
        r.close();
        reader.close();
        writer.close();
    }
    }

