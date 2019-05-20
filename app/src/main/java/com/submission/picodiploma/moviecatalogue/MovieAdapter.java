package com.submission.picodiploma.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;


    public void setMovies(ArrayList<Movie> heroes) {
        this.movies = heroes;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView txtMovieTitle;
        private TextView txtMovieScore;
        private TextView txtMovieReleaseDate;
        private TextView txtMovieOverview;
        private ImageView imgMovie;

        ViewHolder(View view) {
            txtMovieTitle = view.findViewById(R.id.txt_movie_title);
            txtMovieScore = view.findViewById(R.id.txt_movie_score);
            txtMovieReleaseDate = view.findViewById(R.id.txt_movie_release_date);
            txtMovieOverview = view.findViewById(R.id.txt_movie_overview);
            imgMovie = view.findViewById(R.id.img_movie);
        }

        void bind(Movie movie) {
            txtMovieTitle.setText(movie.getTitle());
            txtMovieScore.setText(movie.getScore());
            txtMovieReleaseDate.setText(movie.getReleaseDate());
            txtMovieOverview.setText(movie.getOverview());
            imgMovie.setImageResource(movie.getPhoto());
        }
    }
}
