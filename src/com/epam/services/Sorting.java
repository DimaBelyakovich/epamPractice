package com.epam.services;

import com.epam.entities.Item;
import com.epam.entities.Store;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {
    public static List<Item> overFive(Supplier<Stream<Item>> itemSupply){
        return itemSupply.get().filter(item -> item.getPrice()>500)
                               .peek(item-> System.out.println("price over 500 "+item.getName()))
                               .collect(Collectors.toList());
    }

    public static Item maxCount(Supplier<Stream<Item>> itemSupply){
        Optional<Item> maxCount = Optional.of(itemSupply.get().max(Comparator.comparingInt(item->item.getCount())).get());
        return maxCount.isPresent() ? maxCount.get() : new Item();
    }

    public static Item minCount(Supplier<Stream<Item>> itemSupply){
        Optional<Item> minCount = Optional.of(itemSupply.get().min(Comparator.comparingInt(item->item.getCount())).get());
        return minCount.orElseThrow(NullPointerException::new);
    }

    public static List<Item> oneStore(Supplier<Stream<Item>> itemSupply){
        List<Item> oneStoreItems = itemSupply.get().filter(item -> item.getStores().size() == 1)
                                                   .collect(Collectors.toList());
        return oneStoreItems;
    }

    public static List<Item> sortPrice(Supplier<Stream<Item>> itemSupply){
        List<Item> priceItems = itemSupply.get().sorted(
                                                        (item1,item2)->item1.getPrice().compareTo(item2.getPrice()) == 0 ?
                                                                item1.getCount().compareTo(item2.getCount()) :
                                                                item1.getPrice().compareTo(item2.getPrice()))
                                                .collect(Collectors.toList());
        return priceItems;
    }

    public static ArrayList<Store> getStores(Supplier<Stream<Item>> itemSupply){
        List<Store> stores = new ArrayList<>();
        itemSupply.get().forEach(item->{
            for (int i = 0; i < item.getStores().size(); i++) {
                stores.add(item.getStores().get(i));
            }
        });
        return (ArrayList<Store>) stores;
    }

    public static ArrayList<Store> getDistinctStores(Supplier<Stream<Item>> itemSupply){
        Stream<Store> storeStream = getStores(itemSupply).stream();
        List<Store> distinctStore = new ArrayList<>();
        storeStream.distinct().forEach(store -> distinctStore.add(store));
        storeStream.close();
        return (ArrayList<Store>)distinctStore;
    }
}
