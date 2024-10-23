package com.sorting_app.input;

import com.sorting_app.model.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputCar {

    private List<Car> loadCarList = new ArrayList<>();
    private List<Car> generateCar = new ArrayList<>();

    public RandomInputCar(String carFilePath) {
        loadCarsCSV(carFilePath);
    }

    //Метод для загрузки данных из файла
    public void loadCarsCSV(String carFilePath) {
        File file = new File(carFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;//храним строку из файла
            while ((line = reader.readLine()) != null) {
                //разбиваем строку файла на отдельные значения
                //строка разбивается на массив
                String[] values = line.split(",");
                if (values.length == 3) {

                    String model = values[0].trim();
                    int power = Integer.parseInt(values[1].trim());
                    int year = Integer.parseInt(values[2].trim());
                    loadCarList.add(new Car.CarBuilder().setModel(model)
                            .setPower(power)
                            .setYear(year)
                            .build());
                    //Проверка наполнения loadCarList
                    //System.out.println("Загружено машин" + loadCarList.size());
                    //System.out.println("записанные машины" + loadCarList.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод для рандомной генерации списка машин
    //count - выбор кол-ва машин для добавления
    public void generateCarList(int count) {
        Random random = new Random();
        generateCar.clear();
        System.out.println("Рандомные машины");
        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(loadCarList.size());
            Car randomeCar = loadCarList.get(randomIndex);
            generateCar.add(randomeCar);
        }
    }


    //Метод для вывода списка машин

    public void printCarList() {
        if (generateCar.isEmpty()) {
            System.out.println("Список машин  пустой");
        } else {
            System.out.println("Список машин:");
            for (int i = 0; i < generateCar.size(); i++) {
                System.out.println(generateCar.get(i));
            }
        }
    }
}






