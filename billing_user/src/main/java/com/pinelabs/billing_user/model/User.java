package com.pinelabs.billing_user.model;

import com.pinelabs.billing_user.utility.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "bl_user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String phone;
    private String address;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private UserStatus userStatus;

    @Column(nullable = false)
    private Boolean isCustomer;

    @Column(nullable = false)
    private Boolean isMerchant;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime lastUpdated;
}
