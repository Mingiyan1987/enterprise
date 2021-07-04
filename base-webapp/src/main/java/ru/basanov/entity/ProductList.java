package ru.basanov.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<String> products;

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }

    public ProductList(List<String> products) {
        this.products = new ArrayList<String>();
        this.products.add("Ноутбуки");
        this.products.add("Смартфоны");
        this.products.add("Телевизоры");
        this.products.add("Очки виртуальной реальности");
        this.products.add("Планшеты");
        this.products.add("Игровые приставки");
        this.products.add("Фотоаппараты");
        this.products.add("Объективы");
        this.products.add("Квадрокоптеры");
    }
}
