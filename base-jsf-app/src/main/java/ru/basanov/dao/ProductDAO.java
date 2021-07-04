package ru.basanov.dao;

import ru.basanov.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@ApplicationScoped
public class ProductDAO {

    private Map<String, Product> productMap;

    public ProductDAO() {
        productMap = new HashMap<>();
    }

    public Map<String, Product> findAll() {
        return productMap;
    }

    public void saveProduct(Product product) {
        productMap.put(product.toString(), product);
    }

    public Product editProduct(Product product) {
        return productMap.get(product.toString());
    }

    public void deleteProduct(String key) {
        productMap.remove(key);
    }
}
