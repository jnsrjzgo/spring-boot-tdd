package com.example.demotdd;

import com.example.demotdd.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Long, Product> {

    Optional<Product> getBySku(String sku);

}
