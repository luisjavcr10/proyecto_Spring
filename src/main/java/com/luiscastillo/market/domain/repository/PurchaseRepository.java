package com.luiscastillo.market.domain.repository;

import com.luiscastillo.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository
{
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
