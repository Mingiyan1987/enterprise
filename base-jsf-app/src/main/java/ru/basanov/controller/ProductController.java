package ru.basanov.controller;

import ru.basanov.entity.Product;
import ru.basanov.dao.ProductDAO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private ProductDAO productDAO;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Map<String, Product> getAllProducts() {
        return productDAO.findAll();
    }

    public String createProduct() {
        product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public String editProduct(Product product) {
        productDAO.editProduct(product);
        return "/product.xhtml?faces-redirect=true";
    }

    public String deleteProduct(Product product) {
        productDAO.deleteProduct(product.toString());
        return "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        productDAO.saveProduct(product);
        return "/index.xhtml?faces-redirect=true";
    }

}
