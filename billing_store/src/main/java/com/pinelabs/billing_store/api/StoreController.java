package com.pinelabs.billing_store.api;

import com.pinelabs.billing_store.model.Store;
import com.pinelabs.billing_store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/{storeId}")
    public Optional<Store> getStore(@PathVariable("storeId") Long storeId) {
        Optional<Store> storeName = storeService.getStoreName(storeId);
        return storeName;
    }

    @PostMapping("/")
    public ResponseEntity<Store> addStore(@RequestBody Store store) {

        Store addStore = storeService.addStore(store);
        return ResponseEntity.ok(addStore);
    }

}