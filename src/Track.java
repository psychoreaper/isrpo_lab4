package lab2;

public class Track {
    private String title;
    private Artist artist;
    private Album album;
    //year and genre to be taken from album
    private int year;
    private Genre genre;

    public Track(String title, Album album) {
        this.title = title;
        this.album = album;
        this.artist = album.getArtist();
        this.year = album.getYear();
        this.genre = album.getGenre();
        this.album.getTrackList().add(this);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    //all the information about track
    public void view(){
        System.out.println(title);
        System.out.println(artist.getName());
        System.out.println(album.getTitle());
        System.out.println(year);
        System.out.println(genre.getName());
    }
}
