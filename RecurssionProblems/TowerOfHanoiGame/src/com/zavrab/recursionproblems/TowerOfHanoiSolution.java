package com.zavrab.recursionproblems;

import java.util.Stack;

/**
 * A Tower of Hanoi is a game that consists of three rods,
 * and a number of disks of different sizes which can slide onto any rod.
 * The game starts with the disks in a neat stack in ascending order of size on one rod,
 * the smallest at the top. The objective of the puzzle is to move the entire stack to another rod,
 * obeying the following simple rules:
 *
 * 1. Only one disk can be moved at a time.
 * 2. Each one consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * 3. No disk may be place on top of a smaller disk.
 *
 * http://www.cs.cmu.edu/~cburch/survey/recurse/hanoiimpl.html
 * */
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
            // Just helper to move disk from source tower to destination tower
            moveDisk(src, dest);

            System.out.format("Source: %d, Dest: %d, Spare: %d \n", src.size(), dest.size(), spare.size());
        }
        else {
            // Recurse: source to spare
            moveTower(disk - 1, src, spare, dest);

            // Just helper to move disk from source tower to destination tower
            moveDisk(src, dest);

            System.out.format("Source: %d, Dest: %d, Spare: %d \n", src.size(), dest.size(), spare.size());

            // Recurse: spare to destination
            moveTower(disk - 1, spare, dest, src);
        }
    }

    // Just helper to move disk from source tower to destination tower
    private static void moveDisk(Stack<Integer> src, Stack<Integer> dest) {
        dest.push(src.pop());
    }
}
