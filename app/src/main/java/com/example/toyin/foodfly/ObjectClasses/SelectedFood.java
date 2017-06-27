package com.example.toyin.foodfly.ObjectClasses;

import java.io.Serializable;
import java.sql.PreparedStatement;

/**
 * Created by Toyin on 27/06/2017.
 */

public class SelectedFood{

    private String price;
    private String title;
    private String description;
    private int thumbnail;

    public SelectedFood(String price, String descrip, int thumbnail, String title) {
        this.price = price;
        this.description = descrip;
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public String getSelectedPrice() {
        return price;
    }

    public void setSelectedPrice(String price) {
        this.price = price;
    }

    public String getSelectedTitle() {
        return title;
    }

    public void setSelectedTitle(String title) {
        this.price = title;
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
