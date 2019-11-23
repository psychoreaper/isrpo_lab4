package lab2;

import java.util.*;

public class Artist {
    private String name;
    private String origin;
    private int year;
    private ArrayList<Album> albumList;

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public Artist(String name, String origin, int year) {
        this.name = name;
        this.origin = origin;
        this.albumList = new ArrayList<>();
        this.year = year;

    }

    public void setAlbum(Album album) {
        this.albumList.add(album);
    }

    public void setAlbumByName(String albumName, Genre genre, int albumYear) {
        this.albumList.add(new Album(albumName, this, genre, albumYear));
    }

    public void view() {
        System.out.println(name);
        System.out.println(origin);
        System.out.println(year);
        for (Album i : albumList) {
            System.out.println(i.getTitle() + ", " + i.getYear());
        }
    }
}
