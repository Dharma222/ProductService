package dev.bhargav.productservice.Service;

import dev.bhargav.productservice.Repositories.ProductRepository;
import dev.bhargav.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private ProductRepository productRepository;
    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> search(String query, int pagenumber, int pagesize)
    {
        Pageable p = PageRequest.of(pagenumber, pagesize);
        return productRepository.findByTitleContaining(query,p);

    }
}
