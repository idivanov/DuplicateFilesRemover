package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindingDuplicateFiles {

	private Map<Long, ArrayList<File>> map;
//	private List<File> allDuplicateFiles;

	public FindingDuplicateFiles() {
	    map = new HashMap<>();
//	    allDuplicateFiles = new ArrayList<>();
    }
	
	public void setDublicateFiles(List<File> allFiles) {
		

		for (File file : allFiles) {
			if (map.containsKey(file.length())) {
				map.get(file.length()).add(file);
			} else {
				ArrayList<File> arrayList = new ArrayList<>();
				arrayList.add(file);
				map.put(file.length(), arrayList);
			}
		}
	}

	public void print() {

		for (Map.Entry<Long, ArrayList<File>> e : map.entrySet()) {
			System.out.print("\t\tKey: " + e.getKey() + "\nValues:\n");
			for (File f : e.getValue()) {
				System.out.println(f.getAbsolutePath());
			}
			System.out.println();
			System.out.println();
		}
	}

//    public List<File> getAllDuplicateFiles() {
//        return allDuplicateFiles;
//    }
//
//    public void setAllDuplicateFiles(ArrayList<File> allDuplicateFiles) {
//        this.allDuplicateFiles = allDuplicateFiles;
//    }
    
    public ArrayList<File> allDuplicateFiles() {
        ArrayList<File> fileList = new ArrayList<>();
        for (Map.Entry<Long, ArrayList<File>> entry : map.entrySet()) {
            ArrayList<File> arrayList = entry.getValue();
            if (arrayList.size() > 1) {
                fileList.addAll(arrayList);
                
            }
        }
        return fileList;
    }
}
