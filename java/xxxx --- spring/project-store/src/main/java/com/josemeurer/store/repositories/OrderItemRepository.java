package com.josemeurer.store.repositories;

import com.josemeurer.store.entities.OrderItem;
import com.josemeurer.store.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
