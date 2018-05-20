package se.mobileinteraction.image;

public class Color {

    private final int red;
    private final int green;
    private final int blue;

    private String name = null;

    private int pixelCount = 0;
    private int fileCount = 0;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(int[] pixel) {
        this(pixel[0], pixel[1], pixel[2]);
    }

    public String getName() {
        if (name == null) {
            name = "R: " + red + ", G: " + green + ", B: " + blue;
            //TODO: Get a human readable name for this color. See ColorNames.java for inspiration
        }
        return name;
    }

    public int getPixelCount() {
        return pixelCount;
    }

    public void setPixelCount(int pixelCount) {
        this.pixelCount = pixelCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }
}
