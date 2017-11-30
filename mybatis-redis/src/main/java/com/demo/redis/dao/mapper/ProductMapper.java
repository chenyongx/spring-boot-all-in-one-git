package com.demo.redis.dao.mapper;

import com.demo.redis.dao.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyueming
 */
@Mapper
public interface ProductMapper {

    void  save(Product product);
    Product select(@Param("id") long id);
    List<Product> findByName(@Param("name") String name);
    void update(Product product);
}
