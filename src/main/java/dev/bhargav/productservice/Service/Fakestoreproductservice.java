package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.dtos.Fakestoreproductdto;
import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("FakestoreProductService")
public class Fakestoreproductservice implements ProductService {

    private RestTemplate restTemplate;

    public Fakestoreproductservice (RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }


    @Override
    public Optional<Product> getSingleproduct(Long id) {


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

        return Optional.of(product);
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
    public List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();

        categories = restTemplate.
                getForObject("https://fakestoreapi.com/products/categories", List.class);


        return categories;
    }

    @Override
    public Product deleteProductbyId(Long id) {
//
//        ResponseEntity<Fakestoreproductdto> fakestoreproductdto = (ResponseEntity<Fakestoreproductdto>) restTemplate.
//                execute("https://fakestoreapi.com/products/{id}", HttpMethod.DELETE, (RequestCallback)null, (ResponseExtractor)null, id);
//
//                Product product = fakestoreproductdto.getBody().toproduct();
//
//        if (fakestoreproductdto.getStatusCode().is2xxSuccessful()) {
//            System.out.println("Resource deleted successfully.");
//        } else {
//            System.out.println("Failed to delete resource. Status code: " + fakestoreproductdto.getStatusCodeValue());
//        }
//
//        return product;

        //restTemplate.getForObject()


        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(Fakestoreproductdto.class);
        ResponseExtractor<ResponseEntity<Fakestoreproductdto>> responseExtractor = restTemplate.responseEntityExtractor(Fakestoreproductdto.class);
        ResponseEntity<Fakestoreproductdto> response= restTemplate
                .execute("https://fakestoreapi.com/products/{id}", HttpMethod.DELETE, requestCallback, responseExtractor,id);

        Product product = response.getBody().toproduct();
        return  product;
    }

    @Override
    public Product updateProduct(Long id, String title, String description, String image, String category, double price) {
        Fakestoreproductdto fakestoreproductdto = new Fakestoreproductdto();
        fakestoreproductdto.setTitle(title);
        fakestoreproductdto.setDescription(description);
        fakestoreproductdto.setImage(image);
        fakestoreproductdto.setCategory(category);
        fakestoreproductdto.setPrice(price);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Fakestoreproductdto> httpEntity = new HttpEntity<Fakestoreproductdto>(fakestoreproductdto, headers);


        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakestoreproductdto, Fakestoreproductdto.class);
        ResponseExtractor<ResponseEntity<Fakestoreproductdto>> responseExtractor = restTemplate.responseEntityExtractor(Fakestoreproductdto.class);
        Fakestoreproductdto fakestoreproductdto1 = restTemplate.
                execute("https://fakestoreapi.com/products/{id}", HttpMethod.PUT, requestCallback, responseExtractor, id).getBody();

        return fakestoreproductdto1.toproduct();




    }

    

//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(Fakestoreproductdto.class);
//        ResponseExtractor<ResponseEntity<Fakestoreproductdto>> responseExtractor = restTemplate.responseEntityExtractor(Fakestoreproductdto.class);
//        try {
//            ResponseEntity<Fakestoreproductdto> response= restTemplate.execute("https://fakestoreapi.com/products/{id}", HttpMethod.PUT, requestCallback, responseExtractor,fakestoreproductdto);
//            Product product = new Product();
//            return fakestoreproductdto.toproduct();
//        }
//        catch (
//                Exception exception
//        )
//        {System.out.println("Exception");}
//
//        return null;

    }