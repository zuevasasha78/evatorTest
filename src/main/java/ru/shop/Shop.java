package ru.shop;

import ru.shop.jsonScheme.Product;

public class Shop {
    public <T> T getProduct(Product product) {
        return new DateHelper().getData(product);
    }
}
