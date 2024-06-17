package dev.bhargav.productservice;

import dev.bhargav.productservice.Repositories.CategoryRepository;
import dev.bhargav.productservice.Repositories.ProductRepository;
import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductserviceApplicationTests {

//	@Autowired
//	ProductRepository productRepository;
//
//	@Autowired
//	CategoryRepository categoryRepository;
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void withoutaccessingproducts()
//	{
//		Category category = categoryRepository.findBytitle("electronics");
//		System.out.println(category.getTitle());
//	}
//
//	@Test
//	@Transactional
//	void withaccessingproducts()
//	{
//	List<Category> category = categoryRepository.findAll();
//	for(Category c : category)
//		{
//		for(Product p : c.getProducts())
//			System.out.println(p.getTitle());
//		}
//	}

}
