package se.mobileinteraction.image;

import java.util.ArrayList;
import java.util.List;

public class ColorUtil {

    private List<Color> allColors = new ArrayList<>();

    public ColorUtil() {
        //Intentionally left empty
    }

    public void addColors(List<Color> colors) {
        allColors.addAll(colors);
    }

    public List<Color> getTopColors(int count) {
        return new ArrayList<>();   //TODO: implement method
    }

    public int getUniqueColorCount() {
        return 0;   //TODO: implement method
    }
}
