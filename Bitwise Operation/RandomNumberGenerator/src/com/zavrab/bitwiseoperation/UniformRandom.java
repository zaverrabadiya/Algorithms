package com.zavrab.bitwiseoperation;

import java.util.Random;

/**
 * Created by Zaver R on 2/15/16.
 */
public class UniformRandom {
    public int random(int lowerBound, int upperBound) {
        int numberOfOutComes = upperBound - lowerBound + 1;
        int result;
        do {
            result = 0;

            for (int i = 0; (1 << i) < numberOfOutComes; i++) {
                int zeroOneRandom = (new Random().nextInt() & 1); // To get 0 or 1 from random
                result = (result << 1) + zeroOneRandom;
            }
        } while (result >= numberOfOutComes);
        return result + lowerBound;
    }
}
