package com.ycs.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ycs.practice.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
