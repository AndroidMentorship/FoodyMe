package com.example.toyin.foodfly.ObjectClasses;

import java.io.Serializable;
import java.sql.PreparedStatement;

/**
 * Created by Toyin on 27/06/2017.
 */

public class SelectedFood{

    private int price;
    private String title;
    private String description;
    private int thumbnail;

    public SelectedFood(int price, String descrip, int thumbnail, String title) {
        this.price = price;
        this.description = descrip;
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public int getSelectedPrice() {
        return price;
    }

    public void setSelectedPrice(int price) {
        this.price = price;
    }

    public String getSelectedTitle() {
        return title;
    }

    public void setSelectedTitle(String title) {
        this.title = title;
    }

    public String getSelectedDescription() {
        return description;
    }

    public void setSelectedDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}
