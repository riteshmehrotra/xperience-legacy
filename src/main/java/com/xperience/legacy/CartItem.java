package com.xperience.legacy;

import lombok.*;

import java.util.UUID;


@RequiredArgsConstructor
public class CartItem {
    @Generated
    @Getter
    UUID cartItemId;
    @NonNull
    @Getter
    @Setter
    Product product;
    @NonNull
    @Getter
    @Setter
    int quantity;

    public double getItemTotal() {
        switch (product.pricingStrategy) {
            case PerUnit -> {
                return product.getUnitPrice() * quantity;
            }
            case Volume -> {
                if (product.getVolumeThreshold() - quantity == 0)
                    return product.getVolumePrice();
                else if (product.getVolumeThreshold() - quantity < 0){
                    int qty = product.getVolumeThreshold() - quantity;
                    return (product.getVolumePrice()) + (product.getUnitPrice() * Math.abs(qty));
                }
                else {
                    return product.getUnitPrice() * quantity;
                }
            }
            case BuyTwoGetOneFree -> {
                if (quantity == 3)
                    return product.getUnitPrice() * 2;
                else
                    return product.getUnitPrice() * quantity;
            }
            default -> throw new IllegalStateException("Unexpected value: " + product.pricingStrategy);
        }
    }
}
