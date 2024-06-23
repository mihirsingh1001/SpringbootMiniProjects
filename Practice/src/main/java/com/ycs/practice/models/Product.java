package com.ycs.practice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_status")
    private String product_status;

    public Product(int product_id, String product_name, String product_status) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_status = product_status;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_status() {
        return product_status;
    }

    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }

    @Override
    public String toString() {
        return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_status="
                + product_status + "]";
    }

    
}
