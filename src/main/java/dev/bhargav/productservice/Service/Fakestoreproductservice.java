package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.Controller.ProductService;
import dev.bhargav.productservice.dtos.Fakestoreproductdto;
import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
