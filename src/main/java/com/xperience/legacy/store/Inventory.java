package com.xperience.legacy.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Inventory  {

    List<ProductStock> stocks = new ArrayList<>();

    public Inventory(){
        stocks.add(new ProductStock(UUID.randomUUID(),200));
        stocks.add(new ProductStock(UUID.randomUUID(),500));
    }
    public Optional<ProductStock> findStockForProduct(UUID productId, int quantity){
        return stocks.stream().filter(stock->stock.getProductId().equals(productId) && stock.getStock()>quantity).findFirst();
    }
}
