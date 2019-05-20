package com.submission.picodiploma.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int photoPoster;
    private int photo;
    private String title;
    private String score;
    private String releaseDate;
    private String overview;

    public int getPhotoPoster() {
        return photoPoster;
    }

    public void setPhotoPoster(int photoPoster) {
        this.photoPoster = photoPoster;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return  title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return  overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoPoster);
        dest.writeInt(this.photo);
        dest.writeString(this.title);
        dest.writeString(this.score);
        dest.writeString(this.releaseDate);
        dest.writeString(this.overview);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photoPoster = in.readInt();
        this.photo = in.readInt();
        this.title = in.readString();
        this.score = in.readString();
        this.releaseDate = in.readString();
        this.overview = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
