package se.mobileinteraction.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.io.IOException;

public class FileUtil {

    public FileUtil() {
        //Intentionally left empty
    }

    public List<String> getImageFilesInDirectory(String path) throws IOException {

        List<String> files = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File f = listOfFiles[i];
            if (f.isFile()) {
                System.out.println("File " + f.getName());

                if (ImageIO.read(f) == null) {
                    throw new IOException("The file"+f.getName()+"could not be opened , it is not an image");
                }

                files.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                files.addAll(getFilesInDirectory(f.getAbsolutePath()));
            }
        }

        return files;
    }


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
                files.addAll(getFilesInDirectory(f.getAbsolutePath()));
            }
        }

        return files;
    }


}
