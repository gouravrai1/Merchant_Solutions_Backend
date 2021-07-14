package com.pinelabs.billing_store.repository;

import com.pinelabs.billing_store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(value = "select * from bl_store b where b.store_id=id", nativeQuery = true)
    Store findByName(@Param("store_id") Long id);
}
