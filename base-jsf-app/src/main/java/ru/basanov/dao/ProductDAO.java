package ru.basanov.dao;

import ru.basanov.entity.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class ProductDAO implements ProductService {

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    private Map<String, Product> productMap;

    public ProductDAO() {
        productMap = new HashMap<>();
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Transactional
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    public Product editProduct(Product product) {
        return entityManager.merge(product);
    }

    @Transactional
    public void deleteProduct(Product product) {
        entityManager.remove(product);
    }
}
