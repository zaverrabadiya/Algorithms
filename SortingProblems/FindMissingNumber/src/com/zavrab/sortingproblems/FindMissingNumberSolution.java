package com.zavrab.sortingproblems;

/**
 * Given an input file with four billion integers, provide an algorithm to generate an integer which is not contained in the file.
 * Assume you have 1 GB memory. Follow up with what you would do if you have only 10 MB of memory.
 */
public class FindMissingNumberSolution {

    public static void main(String[] args) {
        int[] inArray = new int[] {2, 5, 4, 0, 1};

        System.out.println("Missing number is: " + findMissingNumber(inArray) + " (Assuming have 1 GB of memory)");

        System.out.println("Missing number is: " + findMissingNumber10MbMemory(inArray) + " (Assuming have only 10 MB of memory)");
    }

    /**
     * Find missing number form 4 billion integers, Assume we have only 1GB memory.
     */
    public static int findMissingNumber(int[] inArr) {
        int BIT_LENGTH = 8, totalElements = inArr.length;

        // Get the max positive(UINT max) i.e.4294967294 = 2^32 Then divide by 8 to get number of bytes
        int size = (int)(((long)Integer.MAX_VALUE << 1) / BIT_LENGTH);

        // Then divide by 8 to get number of bytes
        byte[] bitSet = new byte[size]; // Store 8 bit

        // Set each element to its corresponding index in bitset
        for (int i = 0; i < totalElements; i++) {
            int posInBitSet = inArr[i] / BIT_LENGTH; // Get index in bitset array
            int bitPos = inArr[i] % BIT_LENGTH;  // Get bit to turn ON in BitSet array

            bitSet[posInBitSet] |=  (1 << bitPos);
        }

        int count = 0;
        // Iterate through bitset array and find who is missing
        for (byte i = 0; i < bitSet.length; i++) {
            for (int bit = 0; bit < BIT_LENGTH; bit++) {
                if (count++ >= totalElements) { // Assuming: we should only find missing element from given elements i.e. not one next
                    return Integer.MIN_VALUE;
                }

                if ((bitSet[i] & (1 << bit)) == 0) {    // Assuming: should return the first missing element
                    return (i * BIT_LENGTH) + bit;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * Find missing number form 4 billion integers, Assume we have only 10MB memory.
     */
    public static int findMissingNumber10MbMemory(int[] inArr) {
        int BIT_LENGTH = 16, totalElements = inArr.length;

        int size = 1 << BIT_LENGTH;

        int[] bitSet = new int[size]; // Store 32 bit

        // Set 2^16 bits prefix counter
        for (int i = 0; i < totalElements; i++) {
            int posInBitSet = inArr[i] / BIT_LENGTH; // Get index in bitset array
            bitSet[posInBitSet] += 1;   // Increase counter of the bucket
        }

        // Check which bucket is less than 2^16
        int bitBucket = findBuketWithLessNumber(bitSet, BIT_LENGTH);

        if (bitBucket < 0) {
            return  Integer.MIN_VALUE;
        }

        // Found the prefix, so now set bit for 2^16 suffix
        BIT_LENGTH = 16;
        bitSet = new int[size / BIT_LENGTH]; // Reset bitSet to free up old buckets

        for (int i = 0; i < inArr.length; i++) {
            int posInBitSet = inArr[i] / BIT_LENGTH; // Get index in bitset array

            if (posInBitSet == bitBucket) {
                int bitPos = inArr[i] % BIT_LENGTH;  // Get bit to turn ON in BitSet array
                bitSet[posInBitSet] |= (1 << bitPos);
            }
        }

        return findMissingNumberFromBuckets(bitSet, totalElements, BIT_LENGTH);
    }

    private static int findMissingNumberFromBuckets(int[] bitArray, int totalElements, int bitLength) {
        int count = 0;
        // Iterate through bitset array and find who is missing
        for (byte i = 0; i < bitArray.length; i++) {
            for (int bit = 0; bit < bitLength; bit++) {
                if (count++ >= totalElements) {      // Assuming: we should only find missing element from given elements i.e. not one next
                    return Integer.MIN_VALUE;
                }

                if ((bitArray[i] & (1 << bit)) == 0) {    // Assuming: should return the first missing element
                    return (i * bitLength) + bit;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int findBuketWithLessNumber(int[] bitArray, int bitLength) {
        for (int i = 0; i < bitArray.length; i++) {
            if (bitArray[i] < (1 << bitLength)) {
                return i;
            }
        }
        return -1;
    }
}
