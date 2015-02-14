package main;

import java.io.File;
import java.util.ArrayList;

public class DirectoryReader {
	private ArrayList<String> filesAndDirectories;
	private String basePath;
	private File file;

	public ArrayList<String> getFilesAndDirectories() {
	    return filesAndDirectories;
	}
	
	public DirectoryReader(String basePath) {
		setBasePath(basePath);
		filesAndDirectories = new ArrayList<String>();
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
				filesAndDirectories.add(fileEntry.getAbsolutePath());
			}
		}
	}
}
