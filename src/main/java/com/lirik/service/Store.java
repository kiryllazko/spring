package com.lirik.service;

import com.lirik.exception.DuplicatedException;
import com.lirik.exception.StoreException;
import com.lirik.exception.StoreRuntimeException;
import com.lirik.model.*;

import java.util.*;

public final class Store {

    private static Store INSTANCE;

    public synchronized static Store getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Store(100);
        }
        return INSTANCE;
    }

    List<Product> products;
    Map<Integer, Product> productsMap;

    // инициилизировать объект
    public Store(int maxProducts) {

        products = new LinkedList<>();
        productsMap = new HashMap<>();

        for (int i = 0; i < maxProducts; i++) {
            double r = Math.random();
            Product p = null;

            if (r < 0.33) {
                p = new Tool(i, createTitle());
            } else if (r < 0.66) {
                p = new Food(i, createTitle(), Food.ShelfLife.UNKNOWN);
            } else {
                r = Math.random();
                if (r < 0.5) {
                    p = new CarPart(i, createTitle(), "Volvo", "XC-90", 2022);
                } else {
                    p = new MotorcyclePart(i, createTitle(), "Suzuki", "Ninja", 1995);
                }
            }

            products.add(p);
            productsMap.put(i, p);
        }
        Collections.shuffle(products);
    }

// метод который вернет первый попавшийся продукт путем перебора списка продуктов
//    public Product findById(int id) {
//        List<Product> productList = productsList;
//        int i = 0;
//        while (i < productList.size()) {
//           Product p = productList.get(i);
//            if (p.getId() == id) {
//                return p;
//            }
//            i++;
//        }
//        return null;
//    }

// метод который вернет первый попавшийся продукт по ключу из Map (map.get(id))
    public Product findProductById(int id) {
        Product p = productsMap.get(id);
        return p;
    }

//методы которые будут обрабатывать нештатные ситуации
// добавление продукта с NULL title (нельзя)
// добавление NULL продукта
// добавление продукта с ID который уже есть (тоже нельзя)
    public void add(Product product) throws StoreException {
//        if (product == null) {
//            throw new com.lirik.exception.StoreRuntimeException("Продукт пустой");
//        }
        if (product.getTitle() == null) {
            throw new StoreException("Заполните title");
        }
        if (findProductById(product.getId()) != null) {
            throw new DuplicatedException("такое Id уже есть");
        }
        productsMap.put(product.getId(), product);
        products.add(product);
    }

// удаление продукта по несуществующему ID
    public void delete(int productId) throws StoreException {
        Product product = findProductById(productId);
        if (product == null) {
            throw new StoreException("несуществующий id");
        }
        products.remove(product);
        productsMap.remove(productId);
    }

    private static String createTitle() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 100; // letter 'z' 122
        int targetStringLength = 3; // 10
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

// отфильтровать чтобы в результате была только Food
    public List<Food> getFood() {

        List<Food> result = new LinkedList<>();

        for (Product product : products) {
            if (/**проверить является ли продукт Food */product.getClass().equals(Food.class)) {
                result.add((Food) product);
            }
        }
        return result;
    }

// отфильтровать чтобы в результате была только VehicleParts
    public List<VehiclePart> getVehicleParts() {

        List<VehiclePart> result = new LinkedList<>();

        for (Product product : products) {
            if (product instanceof VehiclePart) {
                result.add((VehiclePart) product);
            }
        }
        return result;
    }

// отфильтровать чтобы в результате была только Tool
    public List<Tool> getTools() {

        List<Tool> result = new LinkedList<>();

        for (Product product : products) {
            if (/**проверить является ли продукт Tool */product.getClass().isAssignableFrom(Tool.class)) {
                result.add((Tool) product);
            }
        }

        return result;
    }

// вернуть как запчасть
    public VehiclePart findPart(int id) {
        Product p = findProductById(id);

        if (p.getClass().isAssignableFrom(CarPart.class)) {
            return (VehiclePart) p;
        } else {
            throw new StoreRuntimeException("Это не запчасть!!");
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
