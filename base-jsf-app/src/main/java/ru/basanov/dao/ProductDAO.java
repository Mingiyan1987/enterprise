package ru.basanov.dao;

import ru.basanov.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ApplicationScoped
public class ProductDAO {

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    private Map<String, Product> productMap;

    public ProductDAO() {
        productMap = new HashMap<>();
    }

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
