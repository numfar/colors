package se.mobileinteraction.image;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ColorUtil {

    private List<Color> allColors = new ArrayList<>();

    public ColorUtil() {
        //Intentionally left empty
    }

    public void addColors(List<Color> colors) {
        allColors.addAll(colors);
    }

    public List<Color> getTopColors(int count) {
        Map<Color,Integer> uni = getUniqueColorsWithScore();

        Map<Color, Integer> sortedMap = new LinkedHashMap<>();
        uni.entrySet().stream()
                .sorted(Map.Entry.<Color, Integer>comparingByValue().reversed())
                        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        List<Color> uniSorted = sortedMap.keySet().stream()
                .collect(Collectors.toList());

        return uniSorted.subList(0,count);
    }

    public int getUniqueColorCount() {
        return getUniqueColorsWithScore().size();
    }

    public LinkedHashMap<Color,Integer> getUniqueColorsWithScore(){
        LinkedHashMap<Color,Integer> counted = new LinkedHashMap<Color,Integer>();

        for(Color c : allColors){
            if(containsColor(c, counted)) {
                int currCount = counted.get(c);
                counted.put(c,currCount + 1);
            }
            else {
                counted.put(c,1);
            }
        }

        return counted;
    }

    private boolean containsColor(Color curr, Map<Color,Integer> same){
        for(Color c2 : same.keySet()){
            if(c2.isSame(curr,0)){
                return false;
            }
        }
        return true;
    }

}
