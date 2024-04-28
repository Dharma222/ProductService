package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getSingleproduct(Long id);

    public Product createProduct(String title, String description,String image, String category,double price);

    public List<Product> getAllProducts();


    public String[] getCategories();


}
