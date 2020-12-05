package com.company;

import java.awt.*;

public class Circle extends Shape {

    public Circle(int maxHeight, int maxWidth) {
        super(maxHeight, maxWidth);
    }

    @Override
    public void paint(Graphics g) {
        g.drawOval(x, y, 100, 100);
        g.setColor(color);
        g.fillOval(x, y, 100, 100);
    }
}