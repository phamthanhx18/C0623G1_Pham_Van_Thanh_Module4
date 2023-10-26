package com.example.rental_books.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readFile(String pathFile){
        List<String> data = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                data.add(string);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    public static void writeFile(String pathFile, List<String> stringList){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile));
            for (String string: stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
