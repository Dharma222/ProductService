package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Optional<Product> getSingleproduct(Long id);

    public Product createProduct(String title, String description,String image, String category,double price);

    public List<Product> getAllProducts();


    public List<Category> getCategories();

    public Product deleteProductbyId(Long id);

    public Product updateProduct(Long id, String title, String description, String image, String category, double price);


}



