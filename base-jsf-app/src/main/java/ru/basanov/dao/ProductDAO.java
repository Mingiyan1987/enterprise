package ru.basanov.dao;

import ru.basanov.bean.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Named
public class ProductDAO {

    private Map<String, Product> productMap = new HashMap<>();

    public ProductDAO() {
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
