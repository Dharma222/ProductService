package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.Repositories.CategoryRepository;
import dev.bhargav.productservice.Repositories.ProductRepository;
import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Product> getSingleproduct(Long id) {
        return productRepository.findById(id);
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
        return productRepository.findAll();
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }

    @Override
    public Product deleteProductbyId(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public Product updateProduct(Long id, String title, String description, String image, String categorytitle, double price) {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);
        Category category1 = categoryRepository.findBytitle(categorytitle);
        if(category1 == null) {
            Category newCategory = new Category();
            newCategory.setTitle(categorytitle);
            category1 = categoryRepository.save(newCategory);
        }
        product.setCategory(category1);
        return productRepository.save(product);
    }
}
