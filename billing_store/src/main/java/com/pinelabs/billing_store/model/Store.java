package com.pinelabs.billing_store.model;

import com.pinelabs.billing_store.utility.StoreStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "bl_store")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false)
    private String storeName;

    @Column(length = 2000)
    private String storeDescription;

    @Column(nullable = false)
    private Long userId;

    private String phone;
    private String mobile;
    private String email;
    private String Address;
    private String city;
    private String state;
    private Boolean isMerchant;
    private StoreStatus storeStatus;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime lastUpdated;
}
