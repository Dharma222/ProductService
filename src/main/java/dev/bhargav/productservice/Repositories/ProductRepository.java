package dev.bhargav.productservice.Repositories;

import dev.bhargav.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product entity);
}
