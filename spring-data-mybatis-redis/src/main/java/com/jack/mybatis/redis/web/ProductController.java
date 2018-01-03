package com.jack.mybatis.redis.web;

import com.jack.mybatis.redis.dao.entity.Product;
import com.jack.mybatis.redis.dao.mapper.ProductMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyueming
 */
@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public Product getProductInfo(
        @PathVariable("id")
            Long productId) {
        return productMapper.select(productId);
    }

    @GetMapping("/list/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name) {
        return productMapper.findByName(name);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(
        @PathVariable("id") Long productId, @RequestBody Product newProduct) {
        Product product = productMapper.select(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productMapper.update(product);
        return product;
    }
}
