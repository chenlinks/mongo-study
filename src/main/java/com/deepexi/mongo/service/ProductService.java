package com.deepexi.mongo.service;

/**
 * @author chenling
 * @date 2020/5/19  16:33
 * @since V1.0.0
 */
public interface ProductService {
    void saveProduct();

    void bacthSaveProduct();

    void findById();

    void findByQuery();
}
