package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.Record;
import com.sorting_app.input.SearchInputData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearchStrategy implements IStrategy {
    private final DataObject dataObject;

    public BinarySearchStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private void selectBinarySearch() throws ValidationException {
        SearchInputData searchInputData = new SearchInputData(dataObject);
        Record record = new Record(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите цифру от 1 до 3 для поиска объектов\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    if (!dataObject.getCars().isEmpty()) {
                        searchInputData.findСar();
                        System.out.println("Записать найденные данные в файл?" +
                                "1 - ДА" +
                                "2 - НЕТ");
                        int selectCount = scanner.nextInt();
                        if (selectCount == 1) {
                            record.recordCar(searchInputData.findСar());
                        }
                    } else{
                        System.out.println("Коллекция машин пуста");
                    }
                    break;
                }
                case 2: {
                    if(!dataObject.getBooks().isEmpty()){
                        searchInputData.findBooks();
                        System.out.println("Записать найденные данные в файл?" +
                                "1 - ДА" +
                                "2 - НЕТ");
                        int selectCount = scanner.nextInt();
                        if (selectCount == 1) {
                            record.recordBook(searchInputData.findBooks());
                        }
                    } else {
                        System.out.println("Коллекция книг пуста");
                    }
                    break;
                }
                case 3: {
                    if(!dataObject.getRootVegetables().isEmpty()){
                        searchInputData.findRootVegetable();
                        System.out.println("Записать найденные данные в файл?" +
                                "1 - ДА" +
                                "2 - НЕТ");
                        int selectCount = scanner.nextInt();
                        if (selectCount == 1) {
                            record.recordRootVegetable(searchInputData.findRootVegetable());
                        }
                    } else {
                        System.out.println("Коллекция корнеплодов пуста");
                    }
                    break;
                }
                default:
                    System.out.println("Неверный ввод, введите цифру от 1 до 3");
            }
        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод, введите цифру от 1 до 3");
        } catch (Exception e) {
            throw new ValidationException("Проверьте коллекцию на соответствие");
        }
    }

    @Override
    public void getResult() {
        try {
            selectBinarySearch();
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }

    }
}
