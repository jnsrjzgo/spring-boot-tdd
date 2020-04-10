package com.example.demotdd.entity;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Product {

    private Long id;
    private String sku;
    private String name;
    private String brand;

}
