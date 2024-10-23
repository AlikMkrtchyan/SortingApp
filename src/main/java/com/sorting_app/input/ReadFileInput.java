package com.sorting_app.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileInput {
    //Метод для чтения данных из файла
    public List<String[]> readFile(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
                //System.out.println(data.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    //Вывод данных
    public void printData(String filePath) {
        List<String[]> data = readFile(filePath);
        System.out.println("Данные прочитаны");
        for (String[] line : data) {
            for (String value : line) {
                System.out.println(value + " ");
            }
            //System.out.println();//перенес на новую строку
        }
    }
}
