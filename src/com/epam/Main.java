package com.epam;

import com.epam.dao.DaoReader;
import com.epam.entities.Item;
import com.epam.entities.Store;
import com.epam.services.Sorting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Store> stores = new ArrayList<>();

        DaoReader.readItems(items);
        DaoReader.readStores(stores,items);

        Supplier<Stream<Item>> itemSupply = items::stream;

        System.out.println(Sorting.overFive(itemSupply));

        System.out.println(Sorting.maxCount(itemSupply));

        System.out.println(Sorting.minCount(itemSupply));

        System.out.println(Sorting.oneStore(itemSupply));

        System.out.println(Sorting.sortPrice(itemSupply));
        System.out.println("----------------------------");
        Sorting.getStores(itemSupply).forEach(store-> System.out.println(store));
        System.out.println("----------------------------");
        Sorting.getDistinctStores(itemSupply).forEach(store -> System.out.println(store));
    }
}