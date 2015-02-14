package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.RowFilter.Entry;

public class FindingDuplicateFiles {
	// TODO:
	// Opravi si construktorite!!!
	// INACHE MECHKA!
	
	private HashMap<Long, ArrayList<File>> map;

	public FindingDuplicateFiles() {
        // TODO Auto-generated constructor stub
    }
	
	public void setDublicateFiles(ArrayList<File> allFiles) {
		map = new HashMap<>();

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
			System.out.println();
			System.out.println();
		}
	}
}
