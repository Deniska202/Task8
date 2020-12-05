package com.company;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(int maxHeight, int maxWidth) {
        super(maxHeight, maxWidth);
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(x, y, 100, 50);
        g.setColor(color);
        g.fillRect(x, y, 100, 50);
    }
}