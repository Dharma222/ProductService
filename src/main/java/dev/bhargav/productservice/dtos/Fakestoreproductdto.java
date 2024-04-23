package dev.bhargav.productservice.dtos;

import dev.bhargav.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fakestoreproductdto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;


}
