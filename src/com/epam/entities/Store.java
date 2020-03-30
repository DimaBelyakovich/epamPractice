package com.epam.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class Store {
    private String name;
    private List<Item> items;
    private List<String> feedbackList;

    public Store(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.feedbackList = new LinkedList<>();
    }

    public Store() {
        super();
        this.items = new ArrayList<>();
        this.feedbackList = new LinkedList<>();
    }

    public void addFeedback(String feedback){
        this.feedbackList.add(feedback);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(Item item) {
        this.items.add(item);
    }

    public List<String> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<String> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Store.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("items=" + items)
                .add("feedbackList=" + feedbackList)
                .toString();
    }
}
