package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task3 extends JFrame {

    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 720;

    private int count;
    private final List<BufferedImage> images;

    public Task3(List<BufferedImage> images) {
        this.images = images;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
        MediaTracker tr = new MediaTracker(this);
        images.forEach(image -> tr.addImage(image, 0));
        try {
            tr.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(images.get(count % images.size()), 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void playLoopAnimation() {
        while (true) {
            repaint();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                System.out.println("Анимация прервана");
            }
            count++;
        }
    }

    public static void main(String[] args) {
        List<BufferedImage> readImages = Arrays.stream(args).map(arg -> {
            try {
                return ImageIO.read(new File(arg));
            } catch (IOException e) {
                System.out.println("Ошибка открытия файла: " + arg);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
        if (readImages.isEmpty()) {
            System.out.println("Не загружено ни одной картинки!");
            System.exit(-1);
        } else {
            Task3 task3 = new Task3(readImages);
            task3.playLoopAnimation();
            task3.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent ev) {
                    System.exit(0);
                }
            });
        }
    }

}