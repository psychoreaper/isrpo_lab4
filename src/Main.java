package lab2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


public class Main {
    public static String inform;
    public static Catalog mainCatalog;

    public static void main(String[] args) throws FileNotFoundException {
        Catalog catalog = new Catalog();

        Scanner input = new Scanner(new File("input.txt"));
        String inputString;
        while (input.hasNext()) {
            inputString = input.nextLine();
            if (inputString.matches("setArtist name .+ origin .+ year \\d{4}")) {
                /*INPUTTING ARTIST*/
                String string = inputString.replaceAll("setArtist name", ""); //deleting the first words needed to detect
                String[] words1 = string.split(" "); //splitting string to separate words
                String artistName = ""; //we should save artist name in case in contains of more than 1 word
                for (String i : words1) { //searching while it's not a different field
                    if (!i.equals("origin")) {
                        artistName += (i + " ");
                    } else {
                        break;
                    }
                }
                string = string.replaceAll(artistName + "origin ", ""); //getting rid of the known info
                artistName = artistName.substring(1, artistName.length() - 1);
                String[] words2 = string.split(" "); //splitting again
                String artistOrigin = words2[0]; //origin is always one word
                int artistYear = Integer.parseInt(words2[2]); //year is the last word, it can be translated into integer
                catalog.artists.add(new Artist(artistName, artistOrigin, artistYear)); //creating new item in the arraylist of artists
            } else if (inputString.matches("setAlbum title .+ artist .+ genre .+ year \\d{4}")) {
                /*INPUTTING ALBUM*/
                String string = inputString.replaceAll("setAlbum title", "");
                String[] words1 = string.split(" ");
                String albumTitle = "";
                for (String i : words1) {
                    if (!i.equals("artist")) {
                        albumTitle += (i + " ");
                    } else {
                        break;
                    }
                }
                string = string.replaceAll(albumTitle + "artist ", "");
                //albumTitle = albumTitle.replaceFirst(" ", "");
                albumTitle = albumTitle.substring(1, albumTitle.length() - 1);
                String[] words2 = string.split(" ");
                String artistName = "";
                for (String i : words2) {
                    if (!i.equals("genre")) {
                        artistName += (i + " ");
                    } else {
                        break;
                    }
                }
                string = string.replaceAll(artistName + "genre ", "");
                artistName = artistName.replaceFirst(" ", "");
                String[] words3 = string.split(" ");
                String genreName = "";
                for (String i : words3) {
                    if (!i.equals("year")) {
                        genreName += (i + " ");
                    } else {
                        break;
                    }
                }
                genreName = genreName.substring(0, genreName.length() - 1);
                int albumYear = Integer.parseInt(words3[words3.length - 1]);
                catalog.albums.add(new Album(albumTitle, catalog.searchEngine.searchArtistByName(catalog.artists, artistName), catalog.searchEngine.searchGenreByName(catalog.genres, genreName), albumYear));
            } else if (inputString.matches("setGenre name .+")) {
                /*INPUTTING PARENTED GENRE*/
                if (inputString.matches("setGenre name .+ parent .+")) {
                    String string = inputString.replace("setGenre name ", "");
                    String[] words = string.split(" ");
                    String genreName = "";
                    for (String i : words) {
                        if (!i.equals("parent")) {
                            genreName += (i + " ");
                        } else {
                            break;
                        }
                    }
                    string = string.replace(genreName + "parent ", "");
                    genreName = genreName.substring(0, genreName.length() - 1);
                    catalog.genres.add(new Genre(genreName, catalog.searchEngine.searchGenreByName(catalog.genres, string)));
                } else {
                    /*INPUTTING UNPARENTED GENRE*/
                    String string = inputString.replace("setGenre name ", "");
                    String[] words = string.split(" ");
                    String genreName = "";
                    for (String i : words) {
                        genreName += (i + " ");
                    }
                    genreName = genreName.substring(0, genreName.length() - 1);
                    catalog.genres.add(new Genre(genreName));
                }

            } else if (inputString.matches("setTrack title .+ album .+")) {
                /*INPUTTING TRACK*/
                String string = inputString.replace("setTrack title ", "");
                String words[] = string.split(" ");
                String trackTitle = "";
                for (String i : words) {
                    if (!i.equals("album")) {
                        trackTitle += (i + " ");
                    } else {
                        break;
                    }
                }
                string = string.replace(trackTitle + "album ", "");
                trackTitle = trackTitle.substring(0, trackTitle.length() - 1);
                catalog.tracks.add(new Track(trackTitle, catalog.searchEngine.searchAlbumByTitle(catalog.albums, string)));
            }
        }
        //System.out.println(catalog.genres.size() + " genres, " + catalog.artists.size() + " artists, " + catalog.albums.size() + " albums, " + catalog.tracks.size() + " tracks are available for searching.");
        //System.out.println(catalog.searchEngine.searchAlbumByTitle(catalog.albums, "Demon Days").getTrackList().get(12).getTitle());

        mainCatalog = catalog;

        TheForm form = new TheForm();
        javax.swing.JPanel panell = new javax.swing.JPanel();
        form.setContentPane(new TheForm().panel1);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inform = catalog.genres.size() + " genres, " + catalog.artists.size() + " artists, " + catalog.albums.size() + " albums, " + catalog.tracks.size() + " tracks are available for searching.";
        form.pack();
        form.setVisible(true);
    }
}
