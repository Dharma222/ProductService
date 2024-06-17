package dev.bhargav.productservice.Repositories;

import dev.bhargav.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product entity);

    Product findById(long id);

    List<Product> findAll();

    Product deleteById(long id);

    Page<Product> findByTitleContaining(String title, Pageable pageable);


}
