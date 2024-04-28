package dev.bhargav.productservice.dtos;

import dev.bhargav.productservice.models.Category;
import dev.bhargav.productservice.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fakestoreproductdto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public Product toproduct()
    {
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setImageUrl(getImage());
        product.setPrice(getPrice());
        Category category = new Category();
        category.setTitle(getCategory());
        product.setCategory(category);

        return product;
    }


}
