package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryReader {
    private List<File> filesAndDirectories;
    private String basePath;
    private File file;

    public List<File> getFilesAndDirectories() {
        return filesAndDirectories;
    }

    public DirectoryReader(String basePath) {
        setBasePath(basePath);
        filesAndDirectories = new ArrayList<File>();
        file = new File(this.basePath);
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

    public boolean go() {
        if (getBasePath() == "")
            return false;

        this.listFilesForFolder(file);

        return true;
    }

    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getAbsolutePath());
                filesAndDirectories.add(fileEntry);
            }
        }
    }
}
