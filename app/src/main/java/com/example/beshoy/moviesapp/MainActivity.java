package com.example.beshoy.moviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Movies> moviesList = new ArrayList<Movies>();
        moviesList.add(new Movies("Lord of the rings : the followship of the ring"
                ,"A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron."
                ,R.drawable.the_lord_of_the_rings_1));
        moviesList.add(new Movies("Lord of the rings : the followship of the ring"
                ,"While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron's new ally, Saruman, and his hordes of Isengard."
                ,R.drawable.the_lord_of_the_rings_1));
        moviesList.add(new Movies("Lord of the rings : the return of the king"
                ,"Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."
                ,R.drawable.lord_of_the_rings_3));

        customAdapter adapter = new customAdapter(moviesList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    public  class customAdapter extends BaseAdapter
    {
        public ArrayList<Movies>  list = new ArrayList<Movies>();

        customAdapter(ArrayList<Movies> list){
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int i) {
            return list.get(i).movieName;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int p1, View p2, ViewGroup p3) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.list_view, null);

            ImageView image = findViewById(R.id.image_view);
            TextView txtName = findViewById(R.id.movie_name);

            txtName.setText(list.get(p1).movieName);
            image.setBackgroundResource(list.get(p1).image);

            final Movies movie = list.get(p1);

            myView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){

                    Intent intent = new Intent();
                    intent.putExtra("data", (Serializable) movie);
                    startActivity(intent);
                }

            });

            return myView;
        }
    }
}
