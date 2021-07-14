package com.pinelabs.billing_order.model;

import com.pinelabs.billing_order.utility.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name = "bl_order")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private OrderStatus orderStatus;

    private Integer itemsCount;

    private Double totalGst;
    private Double totalSgst;
    private Double totalCgst;
    private Double totalCess;
    private Double totalGross;

    private Long storeId;
    private String storeName;

    private Long userId;
    private String userName;

    private Long transactionId;
    private Long invoiceId;

    private Double orderAmount;
    private Boolean IsCustomer;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime lastUpdated;
}


