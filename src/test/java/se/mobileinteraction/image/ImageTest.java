package se.mobileinteraction.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.

public class ImageTest {

    private Image image = new Image("images");

    @Test
    public void initTest(){

        List<Color> colors = image.getColors(1);
    }


}
