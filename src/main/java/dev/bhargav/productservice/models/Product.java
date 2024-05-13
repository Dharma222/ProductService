package dev.bhargav.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity // to say spring create table
public class Product extends BaseModel{
   // private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    @ManyToOne (cascade = {CascadeType.PERSIST})//the table to the entity one, here product to catgeory
    private Category category;

}
