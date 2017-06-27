package com.example.toyin.foodfly.ObjectClasses;

/**
 * Created by Toyin on 25/06/2017.
 */

public class Food {

    private String price;
    private String title;
    private String description;
    private int thumbnail;

    public Food() {
    }

    public Food(String price, String descrip, int thumbnail, String title) {
        this.price = price;
        this.description = descrip;
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.price = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

}
