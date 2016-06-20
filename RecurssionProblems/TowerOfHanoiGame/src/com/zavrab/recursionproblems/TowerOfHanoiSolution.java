package com.zavrab.recursionproblems;

import java.util.Stack;

public class TowerOfHanoiSolution {

    public static void main(String[] args) {
        moveTower(3);
    }

    public static void moveTower(int disk) {
        Stack<Integer> tower = new Stack<Integer>();
        // Add disks to the tower
        for (int i = disk; i > 0; i--) {
            tower.push(i);
        }

        moveTower(disk, tower, new Stack<Integer>(), new Stack<Integer>());
    }
    private static void moveTower(int disk, Stack<Integer> src, Stack<Integer> dest, Stack<Integer> spare) {
        if (disk == 1) {
            moveDisk(src, dest);
            System.out.format("Source: %d, Dest: %d, Spare: %d \n", src.size(), dest.size(), spare.size());
        } else {
            moveTower(disk - 1, src, spare, dest);
            moveDisk(src, dest);
            System.out.format("Source: %d, Dest: %d, Spare: %d \n", src.size(), dest.size(), spare.size());
            moveTower(disk - 1, spare, dest, src);
        }
    }

    private static void moveDisk(Stack<Integer> src, Stack<Integer> dest) {
        dest.push(src.pop());
    }
}
