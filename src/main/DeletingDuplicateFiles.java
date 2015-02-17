package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeletingDuplicateFiles {

    private Map<Integer, ArrayList<File>> map;

    public DeletingDuplicateFiles() {
        map = new HashMap<Integer, ArrayList<File>>();
        
    }

    public void hashingFilesToMap(ArrayList<File> files) throws IOException {
        for (final File file : files) {
            String text = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())), StandardCharsets.UTF_8);
            Integer hashCode = text.hashCode();
            if (map.containsKey(hashCode)) {
                map.get(hashCode).add(file);
            } else {
                ArrayList<File> newList = new ArrayList<File>();
                newList.add(file);
                map.put(hashCode, newList);
            }
        }
        printAllDuplicateFiles();
        if (deletingAFile()) {
            printAllDuplicateFiles();
        }
    }

    private void printAllDuplicateFiles() {
        int counter = 0;
        for (Map.Entry<Integer, ArrayList<File>> entry : map.entrySet()) {
            ArrayList<File> files = entry.getValue();
            if (files.size() > 1) {
                System.out.println("Duplicate group number : " + ++counter);
                for (File file : files) {
                    System.out.println("\t" + file.getAbsolutePath());
                }
                System.out.println();
            }
        }
    }

    @SuppressWarnings("resource")
    private boolean deletingAFile() throws IOException {
        System.out.print("Type the file you want to delete: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        File fileToDelete = new File(filePath);
        String wholeFile = new String(Files.readAllBytes(Paths.get(fileToDelete.getAbsolutePath())),
                StandardCharsets.UTF_8);
        Integer hashFile = wholeFile.hashCode();
        if (map.containsKey(hashFile)) {
            for (File file : map.get(hashFile)) {
                if (file.getAbsolutePath().equals(fileToDelete.getAbsolutePath())) {

                    if (file.delete()) {
                        System.out.println("The file is deleted successful.");
                    } else {
                        System.out.println("The file is not deleted.");
                    }
                }
            }
        }

        return false;

    }

}
