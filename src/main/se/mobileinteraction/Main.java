package se.mobileinteraction;

import se.mobileinteraction.files.FileUtil;
import se.mobileinteraction.image.Color;
import se.mobileinteraction.image.ColorUtil;
import se.mobileinteraction.image.Image;
import se.mobileinteraction.image.ImageUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide a path as the first argument to this program");
            return;
        }

        int tolerance = 0;  //TODO: Make program accept tolerance value as second argument (0-255)

        FileUtil fileUtil = new FileUtil();
        ImageUtil imageUtil = new ImageUtil();
        ColorUtil colorUtil = new ColorUtil();

        List<String> files = fileUtil.getFilesInDirectory(args[0]);

        for (String file : files) {
            Image img = imageUtil.getImage(file);
            List<Color> colors = img.getColors(tolerance);
            colorUtil.addColors(colors);
        }

        System.out.println("--------------------------------");
        System.out.println("Total files: " + files.size());
        System.out.println("Total unique colors: " + colorUtil.getUniqueColorCount());

        System.out.println("Top three colors:");
        for (Color color : colorUtil.getTopColors(3)) {
            System.out.println(color.getName() + ": in " + color.getFileCount() + " files, total of " + color.getPixelCount() + " pixels");
        }

    }
}
