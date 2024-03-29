package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
