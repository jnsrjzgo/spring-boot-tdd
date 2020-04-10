package com.example.demotdd;

import com.example.demotdd.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    public ProductRepository productRepository;

    @InjectMocks
    public ProductService productService;

    @Test
    public void getProduct_bySku_success() {
        given(productRepository.getBySku(anyString())).willReturn(Optional.ofNullable(new Product()
                .setId(1L)
                .setSku("i9se")
                .setName("iPhone 9SE")
                .setBrand("Apple")));

        Product prod = productService.getBySku("i9se");
        assertThat(prod).isNotNull()
                .hasFieldOrPropertyWithValue("sku", "i9se");

    }

    @Test
    public void getProduct_bySkui11_success() {
        //Argument Captor
        given(productRepository.getBySku(anyString())).willReturn(Optional.ofNullable(new Product()
                .setId(1L)
                .setSku("i11pro")
                .setName("iPhone 11 Pro")
                .setBrand("Apple")));

        Product prod = productService.getBySku("i11pro");
        assertThat(prod).isNotNull()
                .hasFieldOrPropertyWithValue("sku", "i11pro");

    }

}