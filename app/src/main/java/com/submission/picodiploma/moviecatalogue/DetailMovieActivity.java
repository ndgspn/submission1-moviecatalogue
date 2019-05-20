package com.submission.picodiploma.moviecatalogue;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    ImageView imgMovie, imgMoviePoster;
    TextView txtMovieTitle, txtMovieScore, txtMovieOverview, txtMovieReleaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        if(getSupportActionBar() != null) getSupportActionBar().setTitle("The Movie Catalogue");
        MyColorUtility.darkenNavigationBar(this, R.color.colorLowBlack);
        MyColorUtility.darkenStatusBar(this, R.color.colorLowBlack);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        imgMoviePoster = findViewById(R.id.img_movie_poster);
        imgMovie = findViewById(R.id.img_movie);
        txtMovieTitle = findViewById(R.id.txt_movie_title);
        txtMovieScore = findViewById(R.id.txt_movie_score);
        txtMovieOverview = findViewById(R.id.txt_movie_overview);
        txtMovieReleaseDate = findViewById(R.id.txt_movie_release_date);


        Movie movie = getIntent().getParcelableExtra("Movie");

        int moviePhotoPoster = movie.getPhotoPoster();
        int moviePhoto = movie.getPhoto();
        String movieTitle = movie.getTitle();
        String movieScore = movie.getScore();
        String movieOverview = movie.getOverview();
        String movieReleaseDate = movie.getReleaseDate();
        String[] releaseDateYear = movie.getReleaseDate().split("\\s+");

        imgMoviePoster.setImageResource(moviePhotoPoster);
        imgMovie.setImageResource(moviePhoto);
        txtMovieTitle.setText(movieTitle + " (" + releaseDateYear[2] + ")");
        txtMovieScore.setText(String.format("%s User Score", movieScore));
        txtMovieOverview.setText(movieOverview);
        txtMovieReleaseDate.setText("# " + movieReleaseDate);
    }
}
