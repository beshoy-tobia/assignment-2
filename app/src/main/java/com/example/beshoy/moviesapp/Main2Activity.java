package com.example.beshoy.moviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView title = findViewById(R.id.title);
        TextView txt = findViewById(R.id.txt);
        TextView description = findViewById(R.id.description);
        ImageView image = findViewById(R.id.image);

        Serializable ser = getIntent().getSerializableExtra("data");
        Movies movie = (Movies) ser;

        title.setText(movie.movieName);
        description.setText(movie.description);
        image.setBackgroundResource(movie.image);

    }
}
