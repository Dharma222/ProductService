package dev.bhargav.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass  // telling spring data jpa to inherit

public class BaseModel {

    @Id// says this is primary key
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private boolean isdeleted;

}
