package com.company;

import java.awt.*;

public class Square extends Rectangle {

    public Square(int maxHeight, int maxWidth) {
        super(maxHeight, maxWidth);
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(x, y, 50, 50);
        g.setColor(color);
        g.fillRect(x, y, 50, 50);
    }
}