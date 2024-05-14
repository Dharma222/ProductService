package dev.bhargav.productservice.Repositories;

import dev.bhargav.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {



    Category findBytitle(String title);

    Category save(Category category);

    List<Category> findAll();

}
