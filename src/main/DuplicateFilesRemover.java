package main;

import java.io.File;


public class DuplicateFilesRemover {

	public static void main(String[] args) {
		 String basePath = "C:\\Users\\Mariyan\\Desktop\\test";
		//String basePath = "E:\\Music";
		File file1 = new File(basePath + "\\1.mp3");
		File file2 = new File(basePath + "\\2.mp3");
//		DirectoryReader dr = new DirectoryReader(basePath);
//		dr.go();
		System.out.println(file1.hashCode() + " " + file2.hashCode() );
		
		file1.hashCode();
		System.out.println(file1.length() + "\n" + file2.length() );
	}

}
