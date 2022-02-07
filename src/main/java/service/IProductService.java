package service;

import model.Product;

import java.util.ArrayList;

// interface service để thao tác với database
public interface IProductService {
    Product getProduct(int id);

    ArrayList<Product> getAllProducts();

    void addProduct(Product product);

    void deleteProduct(Product product);

    void editProduct(int id, Product product);
}
