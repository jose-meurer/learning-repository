package com.josemeurer.store.services;

import com.josemeurer.store.entities.Category;
import com.josemeurer.store.repositories.CategoryRepository;
import com.josemeurer.store.services.exceptions.DataBaseException;
import com.josemeurer.store.services.exceptions.ResouceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> list = categoryRepository.findAll();
        return list;
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ResouceNotFoundException(id));
    }

    public Category insert(Category obj) {
        return categoryRepository.save(obj);
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) throw new ResouceNotFoundException(id);
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Category update(Long id, Category obj) {
        try {
            Category entity = categoryRepository.getReferenceById(id);
            categoryData(entity, obj);
            return categoryRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResouceNotFoundException(id);
        }
    }

    private void categoryData(Category entity, Category obj) {
        entity.setName(obj.getName());
    }

}
