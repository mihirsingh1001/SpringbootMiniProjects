package com.ycs.practice.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycs.practice.models.Product;
import com.ycs.practice.repository.ProductRepository;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(ProductImpl.class);

    @Override
    public Product createProduct(Product product) {
        logger.info("inside create Product IMPL");

        return productRepository.save(product);
    }

    @Override
    public Product getSingleProduct(int product_id) {
        Product getSingleProduct = productRepository.findById(product_id)
                .orElseThrow(() -> new RuntimeException("Error!! Given product_id is not found."));
        return getSingleProduct;

    }

    @Override
    public List<Product> getAllProduct() {
        // TODO Auto-generated method stub
        return productRepository.findAll();

    }

    @Override
    public Product updaProduct(Product newProduct, int product_id) {
        // TODO Auto-generated method stub
        Product oldProduct = productRepository.findById(product_id)
                .orElseThrow(() -> new RuntimeException("Error!! Given product_id is not found."));
        oldProduct.setProduct_name(newProduct.getProduct_name());
        oldProduct.setProduct_status(newProduct.getProduct_status());
        newProduct = productRepository.save(oldProduct);
        return newProduct;
    }

    @Override
    public void deleteProduct(int product_id) {
        // TODO Auto-generated method stub
        productRepository.deleteById(product_id);

        logger.info("Deleted Successfully");
    }

}
