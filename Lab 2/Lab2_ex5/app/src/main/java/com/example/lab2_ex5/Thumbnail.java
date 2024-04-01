package com.example.lab2_ex5;

public enum Thumbnail {
    Thumbnail1("Thumbnail 1", R.drawable.first_thumb),
    Thumbnail2("Thumbnail 2", R.drawable.second_thumb),
    Thumbnail3("Thumbnail 3",  R.drawable.third_thumb),
    Thumbnail4("Thumbnail 4",  R.drawable.fourth_thumb);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}

