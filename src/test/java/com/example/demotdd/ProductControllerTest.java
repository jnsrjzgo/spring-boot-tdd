package com.example.demotdd;

import com.example.demotdd.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    public void getProduct_bySku_success() throws Exception {
        given(productService.getBySku(anyString())).willReturn(new Product()
                .setId(1L)
                .setSku("i9se")
                .setName("iPhone 9SE")
                .setBrand("Apple")
        );

        mockMvc.perform(get("/products/i9se"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("sku").value("i9se"))
                .andExpect(jsonPath("name").value("iPhone 9SE"))
                .andExpect(jsonPath("brand").value("Apple"));
    }

    //getProduct_notFound

}
