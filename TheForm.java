package lab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;

public class TheForm extends javax.swing.JFrame {
    JTextField queryTextField;
    private JComboBox comboBox1;
    JPanel panel1;
    private JButton showAnythingButton;
    JTextPane textpane1;
    private JButton button1;
    private JScrollPane jsp;

    TheForm() {
        super("music");
        //textpane1 = new JTextPane();
        textpane1.setText(Main.inform);

        jsp = new JScrollPane();
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        showAnythingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) comboBox1.getSelectedItem()) {
                    case "none": {
                        textpane1.setText("Anything of what? :)");
                        break;
                    }
                    case "Album": {
                        textpane1.setText("");
                        for (Album i : Main.mainCatalog.albums) {
                            textpane1.setText(textpane1.getText() + i.getTitle() + " by " + i.getArtist().getName() + "\n");
                        }
                        break;
                    }
                    case "Artist": {
                        textpane1.setText("");
                        for (Artist i : Main.mainCatalog.artists) {
                            textpane1.setText(textpane1.getText() + i.getName() + "\n");
                        }
                        break;
                    }
                    case "Track": {
                        textpane1.setText("");
                        for (Track i : Main.mainCatalog.tracks) {
                            textpane1.setText(textpane1.getText() + i.getTitle() + " (" + i.getAlbum().getTitle() + ", " + i.getArtist().getName() + ")\n");
                        }
                        break;
                    }
                    case "Genre": {
                        textpane1.setText("");
                        for (Genre i : Main.mainCatalog.genres) {
                            if (i.getParent() != null) {
                                textpane1.setText(textpane1.getText() + i.getParent().getName() + ": ");
                            }
                            textpane1.setText(textpane1.getText() + i.getName() + "\n");
                        }
                        break;
                    }
                    case "Playlist": {
                        textpane1.setText("");
                        for (Playlist i : Main.mainCatalog.playlists) {
                            textpane1.setText(textpane1.getText() + i.getName());
                        }
                        break;
                    }
                    case "Year": {
                        textpane1.setText("");
                        for (Album i : Main.mainCatalog.albums) {
                            textpane1.setText(textpane1.getText() + i.getYear() +": " + i.getTitle() + " by " + i.getArtist().getName() + "\n");
                        }
                        break;
                    }
                    case "Origin": {
                        textpane1.setText("");
                        for (Artist i : Main.mainCatalog.artists) {
                            textpane1.setText(textpane1.getText() + i.getOrigin() + ": " + i.getName() + "\n");
                        }
                        break;
                    }
                }
            }
        });
        showAnythingButton.addFocusListener(new FocusAdapter() {
        });



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = queryTextField.getText().toLowerCase();
                String regexp = ".*" + query + ".*";
                if (query.equals("Type your query here...")) {
                    textpane1.setText("Type something original, please.");
                } else {
                    textpane1.setText("That's what I found by your query:\n");
                    switch ((String) comboBox1.getSelectedItem()) {
                        case "none": {

                            break;
                        }
                        case "Album": {
                            for (Album i : Main.mainCatalog.albums) {
                                if (i.getTitle().toLowerCase().matches(regexp)) {
                                    textpane1.setText(textpane1.getText() + i.getTitle() + " by " + i.getArtist().getName() + "\n");
                                }
                            }
                            break;
                        }
                        case "Artist": {
                            for (Artist i : Main.mainCatalog.artists) {
                                if (i.getName().toLowerCase().matches(regexp)) {
                                    textpane1.setText(textpane1.getText() + i.getName() + "\n");
                                }
                            }
                            break;
                        }
                        case "Track": {
                            for (Track i : Main.mainCatalog.tracks) {
                                if (i.getTitle().toLowerCase().matches(regexp)) {
                                    textpane1.setText(textpane1.getText() + i.getTitle() + " (" + i.getAlbum().getTitle() + ", " + i.getArtist().getName() + ")\n");
                                }
                            }
                            break;
                        }
                        case "Genre": {
                        /*textpane1.setText("");
                        for (Genre i : Main.mainCatalog.genres) {
                            if (i.getParent() != null) {
                                textpane1.setText(textpane1.getText() + i.getParent().getName() + ": ");
                            }
                            textpane1.setText(textpane1.getText() + i.getName() + "\n");
                        }*/
                            break;
                        }
                        case "Playlist": {
                        /*textpane1.setText("");
                        for (Playlist i : Main.mainCatalog.playlists) {
                            textpane1.setText(textpane1.getText() + i.getName());
                        }*/
                            break;
                        }
                        case "Year": {
                            for (Album i : Main.mainCatalog.albums) {
                                if (Integer.toString(i.getYear()).matches(regexp)) {
                                    textpane1.setText(textpane1.getText() + i.getYear() +": " + i.getTitle() + " by " + i.getArtist().getName() + "\n");
                                }
                            }
                            break;
                        }
                        case "Origin": {
                            for (Artist i : Main.mainCatalog.artists) {
                                if (i.getOrigin().toLowerCase().matches(regexp)) {
                                    textpane1.setText(textpane1.getText() + i.getOrigin() + ": " + i.getName() + "\n");
                                }
                            }
                            break;
                        }
                    }
                }
            }
        });
        //jsp.setViewportView(textpane1);
    }


}
