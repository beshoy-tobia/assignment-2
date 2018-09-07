package com.example.beshoy.moviesapp;

/**
 * Created by beshoy on 9/5/2018.
 */

public class Movies {
    public String movieName;
    public String description;
    public int image;

    Movies(String name, String description, int image){
        movieName=name;
        this.description=description;
        this.image=image;
    }
    Movies(String name, int image){
        movieName=name;
        this.image=image;
    }
}
