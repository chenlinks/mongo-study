package com.deepexi.mongo.service.impl;

import com.deepexi.mongo.entity.Product;
import com.deepexi.mongo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author chenling
 * @date 2020/5/19  16:33
 * @since V1.0.0
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveProduct(){
        Product product = new Product();
        product.setAddress("贵州省瓮安县");
        product.setManufactureDate(new Date());
        product.setName("老干妈");
        product.setPrice(2122112);
        product.setSize("10*28");
        product.setId(1L);
        Product save = mongoTemplate.save(product);
        log.info("数据信息：{}",save);
    }


    @Override
    public void bacthSaveProduct(){
        List<Product> productList = new ArrayList<>();
        for(int i=1000000;i<2000000;i++){
            Product product = new Product();
            product.setAddress("贵州省瓮安县");
            product.setManufactureDate(new Date());
            product.setName("老干妈");
            product.setPrice(2122112);
            product.setSize("10*28");
            product.setId(i+1L);

            productList.add(product);
        }
        long startTime = System.currentTimeMillis();
        Collection<Product> insert = mongoTemplate.insert(productList, Product.class);
        long endTime = System.currentTimeMillis();
        log.info("插入一百万数据耗时：{} 秒",(endTime-startTime)/1000);
        log.info("数据信息：{}",insert);
    }

    @Override
    public void findById(){
        Product byId = mongoTemplate.findById(1, Product.class);
        log.info("数据信息：{}",byId);

    }

    @Override
    public void findByQuery(){
        Query query = new Query(Criteria.where("name").is("老干妈"));
        query.limit(100);
        query.skip(0);
        List<Product> productList = mongoTemplate.find(query, Product.class);
        log.info("数据信息：{}",productList);
    }


}
