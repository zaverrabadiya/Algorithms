package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/16/16.
 */
public class Main {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 1, 3, 2);
        Rectangle r2 = new Rectangle(3, 2, 4, 4);

        Rectangle i = Intersect.intersectRectangle(r1, r2);
        System.out.println("Inter section rectangle: (x,y) = (" + i.x + "," + i.y + ") and (W,H) = (" + i.width + "," + i.height + ")" );
    }
}
