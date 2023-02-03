package com.nyawira.thedlba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PosterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster_page);

        RecyclerView recyclerViewMovie = findViewById(R.id.recycler_movies_view);
        ImageView imageBanner = findViewById(R.id.imageview_banner);

        List<MovieItem> movies = new ArrayList<>();
        MovieAdapter movieAdapter = new MovieAdapter(movies);

        GridLayoutManager layoutManager = new GridLayoutManager(PosterPage.this, 2);

        recyclerViewMovie.setAdapter(movieAdapter);

        recyclerViewMovie.setLayoutManager(layoutManager);

        String url = "https://www.omdbapi.com/?apikey=1c9a1d41&s=Batman&page=2";

        Ion.with(PosterPage.this)
                .load(url)
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>() {
                    @Override
                    public void onCompleted(Exception e, Response <JsonObject> result) {
                        if (result.getHeaders().code()!=200 || e!= null ) {
                            return;
                        }
                        JsonObject theResult = result.getResult();
                        JsonArray jsonArraySearch = result.getResult().getAsJsonArray("Search");
                        for (int i=1; i<jsonArraySearch.size(); i++){
                            JsonObject movie =  jsonArraySearch.get(i).getAsJsonObject();
                            String poster = movie.get("Poster").getAsString();
                            String title = movie.get("Title").getAsString();
                            String year = movie.get("Year").getAsString();
                            String imdb = movie.get("imdbID").getAsString();
                            String type = movie.get("Type").getAsString();

                            MovieItem movieItem = new MovieItem(title,year,imdb,type,poster);
                            movies.add(movieItem);
                            System.out.println("=======  " + poster);
                        };
                        movieAdapter.notifyDataSetChanged();

                        Picasso.get().load(((JsonObject) jsonArraySearch.get(0)).get("Poster").getAsString()).into(imageBanner);




//
//                        int userId = result.get("userId").getAsInt();
//                        int id = result.get("id").getAsInt();
//                        String title = result.get("title").getAsString();
//                        String body = result.get("body").getAsString();
//                        // do stuff with the result or error
//                        System.out.println("Object  " + result);
//                        System.out.println("Error   " + e);


                    }
                });
    }
}