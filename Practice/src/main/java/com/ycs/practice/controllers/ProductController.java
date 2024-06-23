package com.ycs.practice.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycs.practice.models.Product;
import com.ycs.practice.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/create")
    public ResponseEntity <Product> createProduct(@RequestBody Product product) {
        logger.info("Inside create");
        Product newProduct = productService.createProduct(product);
        return  new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity <Product> getSingleProduct(@PathVariable int product_id) {
       Product singleProduct =  productService.getSingleProduct(product_id);
        return new ResponseEntity<Product>(singleProduct, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity <List<Product>> getAllProduct(){
       List<Product> allProduct =  productService.getAllProduct();
        return new ResponseEntity<List<Product>> (allProduct, HttpStatus.OK);
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product newProduct ,@PathVariable int product_id){
       Product updateProduct =  productService.updaProduct(newProduct, product_id);
        return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{product_id}")
    public void deleteProduct(@PathVariable int product_id){
        productService.deleteProduct(product_id);
        logger.info("Successfully Deleted");
    }
    
    
}
