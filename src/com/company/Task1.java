package com.company;

        import javax.swing.*;
        import java.awt.*;
        import java.security.SecureRandom;
        import java.util.Random;

public class Task1 extends JFrame {

    private static final int MAX_HEIGHT = 720;
    private static final int MAX_WIDTH = 1280;

    Random random = new SecureRandom();
    Graphics graphics;

    public Task1() {
        super("Main window");
        setSize(MAX_WIDTH, MAX_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        fillFigures();
    }

    private void fillFigures() {
        for (int i = 0; i < 20; i++) {
            int p = random.nextInt(3);
            if (p == 0) {
                graphics = this.getGraphics();
                new Circle(MAX_WIDTH, MAX_HEIGHT).paint(graphics);
            } else if (p == 1) {
                graphics = this.getGraphics();
                new Rectangle(MAX_WIDTH, MAX_HEIGHT).paint(graphics);
            } else {
                graphics = this.getGraphics();
                new Square(MAX_WIDTH, MAX_HEIGHT).paint(graphics);
            }
        }
    }

    public static void main(String[] args) {
        new Task1();
    }
}
