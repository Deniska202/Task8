package com.company;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;


public abstract class Shape extends JFrame {

    SecureRandom random = new SecureRandom();
    protected float red;
    protected float green;
    protected float blue;
    protected Color color;
    protected int x;
    protected int y;

    Shape(int maxWidth, int maxHeight) {
        red = random.nextFloat();
        green = random.nextFloat();
        blue = random.nextFloat();
        x = random.nextInt(maxWidth - 200);
        y = random.nextInt(maxHeight - 200);
        color = new Color(red, green, blue);
    }

    public abstract void paint(Graphics g);
}