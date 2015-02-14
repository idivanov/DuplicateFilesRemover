package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FindingDuplicateFiles {
    private HashMap<Long, ArrayList<File>> map;

    private void setDublicateFiles(ArrayList<File> allFiles) {
        map = new HashMap<>();
        
        for (File file: allFiles) {
            if (map.containsKey(file.length())) {
                map.get(file.length()).add(file);
            } else {
                ArrayList<File> arrayList = new ArrayList<>();
                arrayList.add(file);
                map.put(file.length(), arrayList);
            }
        }
    }
}
