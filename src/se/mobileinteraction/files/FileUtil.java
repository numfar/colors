package se.mobileinteraction.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public FileUtil() {
        //Intentionally left empty
    }

    //TODO: create method for fetching image files only

    //TODO: Make method return all files in subdirectories as well
    public List<String> getFilesInDirectory(String path) {

        List<String> files = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File f = listOfFiles[i];
            if (f.isFile()) {
                System.out.println("File " + f.getName());
                files.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                System.out.println("Directory " + f.getName());
            }
        }

        return files;
    }


}
