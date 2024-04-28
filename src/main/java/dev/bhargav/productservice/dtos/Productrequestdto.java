package dev.bhargav.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Productrequestdto {
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}
