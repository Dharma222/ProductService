package dev.bhargav.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{
    // private Long id; as id present in basemodel it inherits from basemodel
    private String title ;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE},fetch = FetchType.EAGER)
   @Fetch(FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Product> products;

}
