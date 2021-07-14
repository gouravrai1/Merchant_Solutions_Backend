package com.pinelabs.billing_order.repository;

import com.pinelabs.billing_order.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long> {
}
