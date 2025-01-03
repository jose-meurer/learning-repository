package com.josemeurer.store.services;

import com.josemeurer.store.entities.Order;
import com.josemeurer.store.entities.OrderItem;
import com.josemeurer.store.entities.Product;
import com.josemeurer.store.entities.enums.OrderStatus;
import com.josemeurer.store.repositories.OrderItemRepository;
import com.josemeurer.store.repositories.OrderRepository;
import com.josemeurer.store.repositories.ProductRepository;
import com.josemeurer.store.repositories.UserRepository;
import com.josemeurer.store.services.exceptions.DataBaseException;
import com.josemeurer.store.services.exceptions.EmptyListException;
import com.josemeurer.store.services.exceptions.ResouceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(() -> new ResouceNotFoundException(id));
    }

    @Transactional
    public Order insert(Order obj) {
        Order entity = new Order();
        orderData(entity, obj);
        orderItemData(entity, obj);
        orderRepository.save(entity);
        orderItemRepository.saveAll(entity.getItems());
        return entity;
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id)) throw new ResouceNotFoundException(id);
        try {
            orderRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    @Transactional
    public Order update(Long id, Order obj) {
        if (obj.getItems().isEmpty()) throw new EmptyListException("The order item list cannot be empty.");

        try {
            Order entity = orderRepository.getReferenceById(id);
            entity.getItems().clear();
            orderItemData(entity, obj);
            return orderRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResouceNotFoundException(id);
        }
    }

    private void orderData(Order entity, Order obj) {
        entity.setClient(userRepository.getReferenceById(obj.getClient().getId()));
        entity.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        entity.setMoment(Instant.now());
    }

    private void orderItemData(Order entity, Order obj) {
        for (OrderItem item : obj.getItems()) {
            Product prod = productRepository.getReferenceById(item.getProduct().getId());
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(prod);
            orderItem.setOrder(entity);
            orderItem.setPrice(prod.getPrice());
            orderItem.setQuantity(item.getQuantity());

            entity.getItems().add(orderItem);
        }
    }
}
