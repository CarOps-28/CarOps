package com;

import javafx.scene.control.CheckBox;

public class TempJobObject {
    private String id;
    private String name, description;
    private int price;
    private CheckBox checkBox;
    private String amount;

    public TempJobObject(String name, int price, String description, CheckBox ch) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.checkBox = ch;
        this.checkBox.setAllowIndeterminate(true);
    }

    public TempJobObject(String name, int price, CheckBox ch, String amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.checkBox = ch;
        this.checkBox.setAllowIndeterminate(true);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFired(){
        this.checkBox.setSelected(true);
    }
}
