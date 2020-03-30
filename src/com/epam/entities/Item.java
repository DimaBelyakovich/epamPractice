package com.epam.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class Item {
    private String name;
    private Integer price;
    private Integer count;
    private List<Store> stores;

    public Item() {
        super();
        this.stores = new LinkedList<>();
    }

    public Item(String name, Integer price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.stores = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(Store store) {
        this.stores.add(store);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("count=" + count)
                .add("stores=" + stores)
                .toString();
    }
}
