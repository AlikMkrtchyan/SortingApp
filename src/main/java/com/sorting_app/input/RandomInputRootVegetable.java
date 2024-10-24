package com.sorting_app.input;

import com.sorting_app.model.RootVegetable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputRootVegetable {
    private List<RootVegetable> loadKorneplodList = new ArrayList<>();
    private List<RootVegetable> generateKorneplod = new ArrayList<>();

    public RandomInputRootVegetable(String korneplodFilePath) {
        loadKorneplodsCSV(korneplodFilePath);
    }

    //Метод для загрузки данных из файла
    public void loadKorneplodsCSV(String korneplodFilePath) {
        File file = new File(korneplodFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;//храним строку из файла
            while ((line = reader.readLine()) != null) {
                //разбиваем строку файла на отдельные значения
                //строка разбивается на массив
                String[] values = line.split(",");
                if (values.length == 3) {

                    String type = values[0].trim();
                    int weight = Integer.parseInt(values[1].trim());
                    String color = values[2].trim();
                    loadKorneplodList.add(new RootVegetable.RootVegetableBuilder()
                            .setType(type)
                            .setWeight(weight)
                            .setColor(color)
                            .build());
                    //Проверка наполнения loadBookList
                    System.out.println("Загружено овощей" + loadKorneplodList.size());
                    System.out.println("записанные книги" + loadKorneplodList.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод для рандомной генерации списка овощей
    //count - выбор кол-ва овощей для добавления
    public void generateKorneplodList(int count) {
        Random random = new Random();
        generateKorneplod.clear();
        System.out.println("Рандомные овощи");
        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(loadKorneplodList.size());
            RootVegetable randomRootVegetable = loadKorneplodList.get(randomIndex);
            generateKorneplod.add(randomRootVegetable);
        }
    }


    //Метод для вывода списка книг

    public void printKorneplodsList() {
        if (generateKorneplod.isEmpty()) {
            System.out.println("Список овощей  пустой");
        } else {
            System.out.println("Список овощей:");
            for (int i = 0; i < generateKorneplod.size(); i++) {
                System.out.println(generateKorneplod.get(i));
            }
        }
    }
}

