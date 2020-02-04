package ru.basanov.dao;

import ru.basanov.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
}
