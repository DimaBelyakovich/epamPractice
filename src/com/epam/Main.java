package com.epam;

import com.epam.dao.DaoReader;
import com.epam.entities.Item;
import com.epam.entities.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Store> stores = new ArrayList<>();

        DaoReader.readItems(items);
        DaoReader.readStores(stores,items);

        logger.error(new Error());


        items.forEach(item -> {
            System.out.println(item);
        });

        stores.forEach(store -> {
            System.out.println(store);
        });
    }
}
