package lab2;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Track> trackList;

    public ArrayList<Track> getTrackList() {
        return trackList;
    }

    public String getName() {
        return name;
    }

    public void setTrackList(Track track) {
        this.trackList.add(track);
    }

    public void setTrackList(ArrayList<Track> albumTracks) {
        this.trackList.addAll(albumTracks);
    }
}
