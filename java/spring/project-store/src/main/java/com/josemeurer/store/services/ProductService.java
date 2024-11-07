package com.josemeurer.store.services;

import com.josemeurer.store.entities.Category;
import com.josemeurer.store.entities.Product;
import com.josemeurer.store.repositories.CategoryRepository;
import com.josemeurer.store.repositories.ProductRepository;
import com.josemeurer.store.services.exceptions.DataBaseException;
import com.josemeurer.store.services.exceptions.ResouceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        List<Product> list = productRepository.findAll();
        return list;
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResouceNotFoundException(id));
    }

    public Product insert(Product obj) {
        return productRepository.save(obj);
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) throw new ResouceNotFoundException(id);
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product obj) {
        try {
            Product entity = productRepository.getReferenceById(id);
            categoryRepository.findAllById(obj.getCategories().stream().map(Category::getId).toList());
            productData(entity, obj);
            return productRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResouceNotFoundException(id);
        }
    }

    private void productData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());

        entity.getCategories().clear();
        obj.getCategories().forEach(x -> entity.getCategories().add(categoryRepository.getReferenceById(x.getId())));
    }

}
