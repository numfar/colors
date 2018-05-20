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
        List<Color> uni = getUniqueColorsWithScore();
        List<Color> uniSorted = allColors.stream().sorted((c1,c2) -> (

                ) ).collect(Collectors.toList());
        return uniSorted.subList(0,count);
    }

    public int getUniqueColorCount() {
        getUniqueColorsWithScore().length;
    }

    public HashMap<Color,Integer> getUniqueColorsWithScore(){
        Map counted = new HashMap<Color,Integer>();


    }
}
