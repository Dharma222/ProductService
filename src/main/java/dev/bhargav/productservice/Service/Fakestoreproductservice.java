package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.dtos.Fakestoreproductdto;
import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class Fakestoreproductservice implements ProductService {

    private RestTemplate restTemplate;

    public Fakestoreproductservice (RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleproduct(Long id) {


        Fakestoreproductdto fakestoreproductdto =
                restTemplate.
                        getForObject("https://fakestoreapi.com/products/" + id , Fakestoreproductdto.class);

        Product product = new Product();
        product.setId(fakestoreproductdto.getId());
        product.setTitle(fakestoreproductdto.getTitle());
        product.setDescription(fakestoreproductdto.getDescription());
        product.setImageUrl(fakestoreproductdto.getImage());

       // product.setPrice(fakestoreproductdto.getPrice());
        Category category = new Category();
        category.setTitle(fakestoreproductdto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        Fakestoreproductdto fakestoreproductdto = new Fakestoreproductdto();
        fakestoreproductdto.setTitle(title);
        fakestoreproductdto.setDescription(description);
        fakestoreproductdto.setImage(image);
        fakestoreproductdto.setCategory(category);
        fakestoreproductdto.setPrice(price);

        Fakestoreproductdto response = restTemplate.
                postForObject("https://fakestoreapi.com/products", fakestoreproductdto, Fakestoreproductdto.class);

        Product product = new Product();
        return response.toproduct();

    }

    @Override
    public List<Product> getAllProducts() {
        Fakestoreproductdto[] fakestoreproductdto = restTemplate.
                getForObject("https://fakestoreapi.com/products",Fakestoreproductdto[].class);
        List<Product> products = new ArrayList<>();
        for(Fakestoreproductdto fakestoreproductdto1: fakestoreproductdto)
        {
            Product product = fakestoreproductdto1.toproduct();
            products.add(product);
        }
        return products;
    }

    @Override
    public String[] getCategories() {

        String[] ans = restTemplate.
                getForObject("https://fakestoreapi.com/products/categories", String[].class);


        return ans;
    }
}
