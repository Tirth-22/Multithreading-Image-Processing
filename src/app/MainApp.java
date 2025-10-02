package app;

import java.awt.image.BufferedImage;

import Utils.ImageUtils;
import threads.ImageProcessorThread;

public class MainApp {
    public static void main(String[] args) {
        try {
            BufferedImage img = ImageUtils.loadImage("images/input/lion.jpeg");
            int numThreads = 4;
            int rows = img.getHeight();
            int chunk = rows / numThreads;

            ImageProcessorThread[] threads = new ImageProcessorThread[numThreads];

            for (int i = 0; i < numThreads; i++) {
                int start = i * chunk;
                int end = (i == numThreads - 1) ? rows : start + chunk;
                threads[i] = new ImageProcessorThread(img, start, end);
                threads[i].start();
            }

            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }

            ImageUtils.saveImage(img, "images/output/image1_gray.jpg");
            System.out.println("Image processing done! Check output directory.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
