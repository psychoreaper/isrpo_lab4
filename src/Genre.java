package lab2;

import java.util.*;

public class Genre {
    //genre-tree: item knows his only parent, has list of children
    private String name;
    private Genre parent;
    private Vector<Genre> children;

    public Genre getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public Vector<Genre> getChildren() {
        return children;
    }

    public Genre(String name) {
        this.name = name;
        this.children = new Vector<>();
    }

    public Genre(String name, Genre parent) {
        this.name = name;
        this.parent = parent;
        this.parent.children.add(this);
        this.children = new Vector<>();
    }
}
