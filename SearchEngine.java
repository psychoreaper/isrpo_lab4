package lab2;

import java.util.ArrayList;

public class SearchEngine {

    public Track searchTrackByTitle(ArrayList<Track> tracks, String title) {
        for (Track i : tracks) {
            if (i.getTitle().equals(title)) {
                return i;
            }
        }
        return null;
    }

    public Album searchAlbumByTitle(ArrayList<Album> albums, String title) {
        for (Album i : albums) {
            if (i.getTitle().equals(title)) {
                return i;
            }
        }
        return null;
    }

    public Artist searchArtistByName(ArrayList<Artist> artists, String name) {
        for (Artist i : artists) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public Genre searchGenreByName(ArrayList<Genre> genres, String name) {
        for (Genre i : genres) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public void genreTree(Genre genre){
        //for (genre.getChildren().size())
    }
}
