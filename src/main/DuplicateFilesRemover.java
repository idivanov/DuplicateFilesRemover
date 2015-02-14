package main;

import java.io.File;
import java.util.Arrays;

public class DuplicateFilesRemover {
	
	//
	// Veche mojesh da pullvash uspeshno!
	// gz
	//

	public static void main(String[] args) {
		// String basePath = "C:\\Users\\User\\Desktop\\test";
		String basePath = "E:\\Music";
		DirectoryReader dr = new DirectoryReader(basePath);
		dr.go();
	}

}
