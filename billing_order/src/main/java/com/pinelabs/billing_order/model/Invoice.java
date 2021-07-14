package com.pinelabs.billing_order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Table(name = "bl_order_invoice")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String invoiceId;

    private Long invoiceNumber;
    private String invoiceUrl;

    @CreatedDate
    @Column(updatable = false)
    private String createdOn;

    @LastModifiedDate
    private String lastUpdated;
}