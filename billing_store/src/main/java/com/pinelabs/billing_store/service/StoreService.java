package com.pinelabs.billing_store.service;

import com.pinelabs.billing_store.model.Store;

import java.util.Optional;

public interface StoreService {
    Optional<Store> getStoreName(Long id);

    Store addStore(Store store);
}
