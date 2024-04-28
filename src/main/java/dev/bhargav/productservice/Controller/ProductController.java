package dev.bhargav.productservice.Controller;

import dev.bhargav.productservice.Service.ProductService;
import dev.bhargav.productservice.dtos.Productrequestdto;
import dev.bhargav.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Productrequestdto productrequestdto) {
        return productService.createProduct(
                productrequestdto.getTitle(),
                productrequestdto.getDescription(),
                productrequestdto.getImage(),
                productrequestdto.getCategory(),
                productrequestdto.getPrice()
        );
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }

    // Jackson
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleproduct(id);
    }

    public void deleteProduct(Long id) {

    }

    @GetMapping("/product/categories")
    public String[] getallCategories()
    {
        return productService.getCategories();
    }
}