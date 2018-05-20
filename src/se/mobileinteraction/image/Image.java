package se.mobileinteraction.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Image {

    private String file;
    private BufferedImage img = null;
    private boolean loaded = false;

    public Image(String file) {
        this.file = file;
    }

    private void load() {
        if (loaded) return;

        try {
            System.out.println("Loading file: " + file);
            img = ImageIO.read(new File(file));
        } catch (IOException e) {
        }

        loaded = true;
    }

    private void unload() {
        img = null;
    }

    public List<Color> getColors(int tolerance) {
        load();

        ArrayList<Color> colors = new ArrayList<>();

        if (img == null) {
            System.out.println("Failed to load image: " + file);
            return colors;
        }

        Raster data = img.getData();
        int w = data.getWidth();
        int h = data.getHeight();

        int[] pixel = new int[4];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                data.getPixel(x, y, pixel);
                Color c = new Color(pixel);
                colors.add(c);
                //TODO: Get all *unique* colors based on tolerance
            }
        }

        return colors;
    }


}
