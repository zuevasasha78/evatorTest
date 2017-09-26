package ru.shop.jsonScheme;

public class GetProduct {
    private Integer id;
    private String name;
    private Number price;

    public Integer getId() {
        return id;
    }

    public GetProduct setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GetProduct setName(String name) {
        this.name = name;
        return this;
    }

    public Number getPrice() {
        return price;
    }

    public GetProduct setPrice(Number price) {
        this.price = price;
        return this;
    }
}
