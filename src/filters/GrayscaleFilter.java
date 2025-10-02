package filters;

import java.awt.Color;

public class GrayscaleFilter {
    public static int apply(int rgb){
        Color c = new Color(rgb);
        int gray = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
        Color newColor = new Color(gray, gray, gray);
        return newColor.getRGB();
    }
}
