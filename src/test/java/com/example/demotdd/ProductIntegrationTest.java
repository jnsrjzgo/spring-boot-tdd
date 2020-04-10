package com.example.demotdd;

import com.example.demotdd.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void getProduct_bySku_success() {
        ResponseEntity<Product> response = restTemplate.getForEntity("/products/{sku}", Product.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

}
