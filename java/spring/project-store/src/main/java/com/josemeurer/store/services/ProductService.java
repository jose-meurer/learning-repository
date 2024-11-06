package com.josemeurer.store.services;

import com.josemeurer.store.entities.Product;
import com.josemeurer.store.repositories.ProductRepository;
import com.josemeurer.store.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        List<Product> list = productRepository.findAll();
        return list;
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResouceNotFoundException(id));
    }
}
