package com.xperience.legacy;

import com.xperience.legacy.store.Inventory;

import java.util.*;

public class Cart {

    List<CartItem> items = new ArrayList<>();
    Inventory inventory = new Inventory();

    public void add(Product product, int quantity) {
//        if(inventory.findStockForProduct(product.getProductId(),quantity).isPresent()) {
            if (product.getUnitPrice() > 0 && !product.getName().isEmpty() && !product.getName().isBlank()) {
                Optional<CartItem> itemAlreadyInCart = items.stream().filter(cartItem -> cartItem.product.getName().equals(product.getName())).findFirst();
                itemAlreadyInCart.ifPresent(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
                if (itemAlreadyInCart.isEmpty())
                    items.add(new CartItem(product, quantity));
            }
            else
                System.out.println("Item is missing either price or name");
//        }
//        else
//            System.out.println("Item not in stock");
    }

    public void remove(Product product, int quantity) {
    }

    public double getTotal() {
        return items.stream().map(CartItem::getItemTotal).reduce(Double::sum).orElse(0.0);
    }

    public int getSize() {
        return items.size();
    }
}
