package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/16/16.
 */
public class Intersect {

    public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
        if(isIntersect(r1, r2)) {
            return new Rectangle(
              Math.max(r1.x, r2.x), Math.max(r1.y, r2.y),
                Math.min((r1.x + r1.width), (r2.x + r2.width)) - Math.max(r1.x, r2.x),
                Math.min((r1.y + r1.height), (r2.y + r2.height)) - Math.max(r1.y , r2.y)
            );
        }
        return new Rectangle(0, 0, -1, -1); //No intersection
    }

    private static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x
                && r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y;
    }
}
