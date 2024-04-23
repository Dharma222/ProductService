package dev.bhargav.productservice.Controller;

import dev.bhargav.productservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void createProduct() {
        // Break for 5 minutes: 10:38 -> 10:43
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    // Jackson
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleproduct(id);
    }

    public void deleteProduct(Long id) {

    }
}