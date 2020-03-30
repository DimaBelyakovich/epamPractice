package com.epam.dao;

import com.epam.entities.Item;
import com.epam.entities.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DaoReader {
    static Logger logger = LogManager.getLogger();
    public static void readItems(ArrayList<Item> items, ArrayList<Store> stores){
        ////////////////////
        try(BufferedReader reader = new BufferedReader(new FileReader("data/Items.txt"))){
            String buffer;
            while((buffer = reader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(buffer, "-");
                String name = tokenizer.nextToken();
                int price = Integer.parseInt(tokenizer.nextToken());
                int count = Integer.parseInt(tokenizer.nextToken());
                items.add(new Item(name,price,count));
            }
        }catch (IOException e){
            logger.error(e);
        }
        /////////////////////

        try (BufferedReader reader = new BufferedReader(new FileReader("data/Stors.txt"))){
            String buffer;
            while((buffer = reader.readLine()) != null){
                Store store = new Store();
                StringTokenizer tokenizer = new StringTokenizer(buffer, "-");
                store.setName(tokenizer.nextToken());
                store.addFeedback(tokenizer.nextToken());

                while(tokenizer.hasMoreElements()){
                    Item item = new Item();
                    String itemName = tokenizer.nextToken();

                    for (Item tmpItem : items) {
                        if(tmpItem.getName().equals(itemName)){
                            item = tmpItem;
                            item.setStores(store);
                            store.setItems(item);
                            break;
                        }
                    }
                }

                stores.add(store);
            }
        }catch (IOException e){
            logger.error(e);
        }
    }
}
