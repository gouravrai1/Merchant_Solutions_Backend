package com.pinelabs.billing_order.model;

import com.pinelabs.billing_order.utility.ItemStatus;
import com.pinelabs.billing_order.utility.UnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "bl_order_details")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderDetailsId;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private UnitType unitType;

    @Column(nullable = false)
    private Double unitSellingPrice;

    @Column(nullable = false)
    private Integer itemQuantity;

    private Double totalAmount;

    private Double gstPercentage;
    private Double totalGross;
    private Double totalGst;
    private Double totalCgst;
    private Double totalSgst;
    private Double totalCess;
    private Double totalNet;

    private ItemStatus itemStatus;
}
