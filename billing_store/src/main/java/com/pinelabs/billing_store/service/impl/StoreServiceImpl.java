package com.pinelabs.billing_store.service.impl;

import com.pinelabs.billing_store.model.Store;
import com.pinelabs.billing_store.repository.StoreRepository;
import com.pinelabs.billing_store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    WebClient webClient;

    @Autowired
    private StoreRepository storeRepository;

    private static final String BASE_URL_USER = "http://localhost:8081/api/v1/user/";

    @Override
    public Optional<Store> getStoreName(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Store addStore(Store store) {

        Store store1 = getUserById(store.getUserId());
        if (store1.getIsMerchant()) {
            store.setIsMerchant(store1.getIsMerchant());
            storeRepository.save(store);
            return store;
        }
        return null;
    }

    public Store getUserById(Long userId) {
        return webClient
                .get()
                .uri(BASE_URL_USER + userId)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(Store.class)
                .block();
    }
}
