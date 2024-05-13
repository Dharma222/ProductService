package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.Repositories.CategoryRepository;
import dev.bhargav.productservice.Repositories.ProductRepository;
import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

//    @Autowired
    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleproduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, String categoryTitle, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);

        Category category = categoryRepository.findBytitle(categoryTitle);
        if(category == null) {
            Category newCategory = new Category();
            newCategory.setTitle(categoryTitle);
            category = categoryRepository.save(newCategory);
        }
        product.setCategory(category);
        return productRepository.save(product);


    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public String[] getCategories() {
        return new String[0];
    }

    @Override
    public Product deleteProductbyId(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, String title, String description, String image, String category, double price) {
        return null;
    }
}
