package com.deepexi.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenling
 * @date 2020/5/19  16:30
 * @since V1.0.0
 */
@Data
@Document("product")
public class Product  implements Serializable {

        @MongoId
        private Long id;

        @Field("name")
        private String name;

        @Field("size")
        private String size;

        @Field("address")
        private String address;

        @Field("manufactureDate")
        private  Date   manufactureDate;

        @Field("price")
        private  Integer price;
}
