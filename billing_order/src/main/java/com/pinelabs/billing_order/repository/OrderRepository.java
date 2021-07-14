package com.pinelabs.billing_order.repository;

import com.pinelabs.billing_order.model.Order;
import com.pinelabs.billing_order.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
