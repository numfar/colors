package se.mobileinteraction.image;
import java.lang.*;

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

    public boolean isSame(Color c,int tolerance){
        int totalDiff = Math.abs(red - c.red) + Math.abs(green - c.green) + Math.abs(blue - c.blue);

        if (totalDiff > tolerance){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean equals(Object o){
        Color c = (Color)o;

        if(o == null){
            return false;
        }
        if (!(c.green == this.green && c.blue == this.blue && c.red == this.red) ){
            return false;
        }

        return true;
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
