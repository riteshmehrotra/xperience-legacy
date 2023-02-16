package com.xperience.legacy.store;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
public class ProductStock {
    UUID productId;
    int stock;
}
