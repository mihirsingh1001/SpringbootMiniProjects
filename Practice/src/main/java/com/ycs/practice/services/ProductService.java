package com.ycs.practice.services;

import java.util.List;

import com.ycs.practice.models.Product;

public interface ProductService {

   public Product createProduct(Product product);

   public Product getSingleProduct(int product_id);

   public List<Product> getAllProduct();

   public Product updaProduct(Product newProduct,  int product_id);

   public void deleteProduct(int product_id);

}
