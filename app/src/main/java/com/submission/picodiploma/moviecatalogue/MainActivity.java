package com.submission.picodiploma.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movieTitle;
    private String[] movieScore;
    private String[] movieReleaseDate;
    private String[] movieOverview;
    private TypedArray movieImage;
    private TypedArray movieImagePoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) getSupportActionBar().setTitle("The Movie Catalogue");
        MyColorUtility.darkenNavigationBar(this, R.color.colorBlack);
        MyColorUtility.darkenStatusBar(this, R.color.colorBlack);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie_lists);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                Movie movie = new Movie();
                movie.setPhotoPoster(movies.get(i).getPhotoPoster());
                movie.setPhoto(movies.get(i).getPhoto());
                movie.setTitle(movies.get(i).getTitle());
                movie.setScore(movies.get(i).getScore());
                movie.setOverview(movies.get(i).getOverview());
                movie.setReleaseDate(movies.get(i).getReleaseDate());

                Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
                intent.putExtra("Movie", movie);
                startActivity(intent);

            }
        });
    }

    private void prepare() {
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieScore = getResources().getStringArray(R.array.movie_score);
        movieReleaseDate = getResources().getStringArray(R.array.movie_release_date);
        movieOverview = getResources().getStringArray(R.array.movie_overview);
        movieImage = getResources().obtainTypedArray(R.array.movie_photo);
        movieImagePoster = getResources().obtainTypedArray(R.array.movie_photo_poster);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < movieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhotoPoster(movieImagePoster.getResourceId(i, -1));
            movie.setPhoto(movieImage.getResourceId(i, -1));
            movie.setTitle(movieTitle[i]);
            movie.setScore("★ " + movieScore[i]);
            movie.setReleaseDate(movieReleaseDate[i]);
            movie.setOverview(movieOverview[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

}
