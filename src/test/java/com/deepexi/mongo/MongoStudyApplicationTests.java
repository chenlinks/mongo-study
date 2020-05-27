package com.deepexi.mongo;

import com.deepexi.mongo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongoStudyApplicationTests {


    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
//        productService.saveProduct();
//        productService.bacthSaveProduct();
//        productService.findById();
        productService.findByQuery();
    }

}
