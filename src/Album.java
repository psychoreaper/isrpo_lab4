package lab2;

import java.util.*;

public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private int year;
    private ArrayList<Track> trackList;

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public Album(String title, Artist artist, Genre genre, int year) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.trackList = new ArrayList<>();
        this.artist.setAlbum(this);
    }

    //if track is to be added to the non-existing album
    public void setTrack(Track track) {
        this.trackList.add(track);
    }

    //if track is to be added from the album
    public void setTrackByName(String trackTitle){
        this.trackList.add(new Track(trackTitle, this));
    }

    //nice output
    public void view() {
        System.out.println(title);
        System.out.println(artist.getName());
        System.out.println(genre.getName());
        System.out.println(year);
        for (Track i : trackList) {
            System.out.println(i.getTitle());
        }
    }
}
