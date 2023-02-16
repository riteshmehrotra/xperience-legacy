package com.xperience.legacy;

import lombok.*;

import java.util.UUID;

@RequiredArgsConstructor
public class Product {
    @Generated
    @Getter
    UUID productId;
    @Getter
    @Setter
    @NonNull
    String name;
    @Getter
    @Setter
    @NonNull
    String brand;
    @Getter
    @Setter
    @NonNull
    double unitPrice;
    @Getter
    @Setter
    @NonNull
    PricingStrategy pricingStrategy;
    @Getter
    @Setter
    @NonNull
    int volumeThreshold;
    @Getter
    @Setter
    @NonNull
    double volumePrice;

}
