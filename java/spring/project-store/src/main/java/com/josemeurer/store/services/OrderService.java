package com.josemeurer.store.services;

import com.josemeurer.store.entities.Order;
import com.josemeurer.store.entities.OrderItem;
import com.josemeurer.store.entities.Product;
import com.josemeurer.store.repositories.OrderItemRepository;
import com.josemeurer.store.repositories.OrderRepository;
import com.josemeurer.store.repositories.ProductRepository;
import com.josemeurer.store.repositories.UserRepository;
import com.josemeurer.store.services.exceptions.DataBaseException;
import com.josemeurer.store.services.exceptions.ResouceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        entity = orderRepository.save(entity);
        orderItemData(entity, obj);
        orderItemRepository.saveAll(entity.getItems());
        return orderRepository.save(entity);
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
        entity.setClient(userRepository.getReferenceById(obj.getClient().getId()));
        entity.setPayment(obj.getPayment());
        entity.setOrderStatus(obj.getOrderStatus());
        entity.setMoment(obj.getMoment());
    }

    private void orderItemData(Order entity, Order obj) {
        Set<OrderItem> itemsToSave = new HashSet<>();
        for (OrderItem item : obj.getItems()) {
            Product prod = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new ResouceNotFoundException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(prod);
            orderItem.setOrder(entity);
            orderItem.setPrice(prod.getPrice());
            orderItem.setQuantity(item.getQuantity());

            itemsToSave.add(orderItem);
        }
        entity.getItems().addAll(itemsToSave);
    }
}
