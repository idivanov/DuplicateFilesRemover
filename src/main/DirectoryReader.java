package main;

import java.awt.List;
import java.util.ArrayList;
import java.io.File;

public class DirectoryReader {
	private static ArrayList<String> filesAndDirectories;
	private static String basePath;
	private static File file;

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
		if (this.basePath == "")
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
		// System.out.println(filesAndDirectories.size());
	}
}
