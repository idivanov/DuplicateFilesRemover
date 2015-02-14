package main;

import java.awt.List;
import java.util.ArrayList;

public class DirectoryReader {
    private ArrayList<String> allDrirectories;
    private String basePath;

    public DirectoryReader() {
        allDrirectories = new ArrayList<String>();
        basePath = new String();
    }

    public DirectoryReader(String basePath) {

        setBasePath(basePath);
        allDrirectories = new ArrayList<String>();

    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        if (basePath != null) {
            this.basePath = new String(basePath);
        } else {
            this.basePath = "";
        }
    }

}
