
package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Task2 extends JFrame {

    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 720;

    public Task2(BufferedImage image) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setVisible(true);
        add(new ImageImplement(image));
    }

    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File(args[0]));
            Task2 task2 = new Task2(image);
        } catch (IOException e) {
            System.out.println("Ошибка открытия файла!");
        }
    }
}

