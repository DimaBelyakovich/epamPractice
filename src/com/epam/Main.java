package com.epam;

import com.epam.dao.DaoReader;
import com.epam.entities.Item;
import com.epam.entities.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Store> stores = new ArrayList<>();

        DaoReader.readItems(items,stores);
        items.forEach(item -> {
            System.out.println(item);
        });
    }
}
