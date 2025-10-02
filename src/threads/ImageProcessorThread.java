package threads;

import filters.GrayscaleFilter;

import java.awt.image.BufferedImage;

public class ImageProcessorThread extends Thread {

    private BufferedImage image;
    private int startRow , endRow;

    public ImageProcessorThread(BufferedImage image, int startRow, int endRow) {
        this.image = image;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        for(int row = startRow ; row < endRow ; row++) {
            for(int x=0 ; x<image.getWidth() ; x++) {
                int rgb =  image.getRGB(x,row);
                int newRgb = GrayscaleFilter.apply(rgb);
                image.setRGB(x,row,newRgb);
            }
        }
    }
}
