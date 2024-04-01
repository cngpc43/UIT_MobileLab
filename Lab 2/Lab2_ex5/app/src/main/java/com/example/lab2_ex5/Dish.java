package com.example.lab2_ex5;
import androidx.annotation.NonNull;

public class Dish {
    private String name;
    private Thumbnail thumbnail;
    private boolean isPromotion;

    public Dish(){

    }
    public Dish(String name, Thumbnail thumbnail, boolean promo){
        this.name =name;
        this.thumbnail = thumbnail;
        this.isPromotion = promo;
    }

    public String getName() {
        return name;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }
    public boolean isPromotion(){
        return isPromotion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
