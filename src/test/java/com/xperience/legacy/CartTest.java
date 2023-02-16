package com.xperience.legacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CartTest {

    @Test
    public void addItemsToCartWithPerUnitStrategy(){
        Cart cart = new Cart();
        cart.add(new Product("Soap", "Dettol",2,PricingStrategy.PerUnit,5,8),1);
        cart.add(new Product("Butter", "Cowhead",6,PricingStrategy.PerUnit,2,5),1);
        assertEquals(2,cart.getSize());
        assertEquals(8,cart.getTotal());
    }


    @Test
    public void addMultipleItemsToCartWithDifferentStrategies(){
        Cart cart = new Cart();
        cart.add(new Product("Soap", "Dettol",2,PricingStrategy.Volume,5,8),5);
        cart.add(new Product("Butter", "Cowhead",6,PricingStrategy.PerUnit,2,5),1);

        assertEquals(2,cart.getSize());
        assertEquals(14,cart.getTotal());
    }

    @Test
    public void addItemToCartWithVolumeStrategyWithExactVolume(){
        Cart cart = new Cart();
        cart.add(new Product("Soap", "Dettol",2,PricingStrategy.Volume,5,8),5);
        assertEquals(1,cart.getSize());
        assertEquals(8,cart.getTotal());
    }


    @Test
    public void addItemToCartWithVolumeStrategyButLowVolume(){
        Cart cart = new Cart();
        cart.add(new Product("Soap", "Dettol",2,PricingStrategy.Volume,5,8),2);
        assertEquals(1,cart.getSize());
        assertEquals(4,cart.getTotal());
    }


    @Test
    public void addItemToCartWithVolumeStrategyWithVolumeHigherThanThreshold(){
        Cart cart = new Cart();
        cart.add(new Product("Soap", "Dettol",2,PricingStrategy.Volume,5,8),7);
        assertEquals(1,cart.getSize());
        assertEquals(12,cart.getTotal());
    }



}
