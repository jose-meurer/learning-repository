package com.josemeurer.store.services;

import com.josemeurer.store.entities.Order;
import com.josemeurer.store.repositories.OrderRepository;
import com.josemeurer.store.services.exceptions.DataBaseException;
import com.josemeurer.store.services.exceptions.ResouceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(() -> new ResouceNotFoundException(id));
    }

    public Order insert(Order obj) {
        return orderRepository.save(obj);
    }

    public void delete(Long id) {
        if (orderRepository.existsById(id)) throw new ResouceNotFoundException(id);
        try {
            orderRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Order update(Long id, Order obj) {
        try {
            Order entity = orderRepository.getReferenceById(id);
            orderData(entity, obj);
            return orderRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResouceNotFoundException(id);
        }
    }

    private void orderData(Order entity, Order obj) {
        entity.setClient(obj.getClient());
        entity.setPayment(obj.getPayment());
        entity.setOrderStatus(obj.getOrderStatus());
        entity.setMoment(obj.getMoment());

        obj.getItems().forEach(x -> entity.getItems().add(x));
    }
}
