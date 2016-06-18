package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        int[] sorted = new int[] {2,3, 5, 5, 7, 11, 11, 11, 13};
        //int[] result = deleteDuplicatesFromSorted(sorted);

        int[] unsorted = new int[] {88, 4, 2, 3, 21, 17, 2, 3, 17, 21, 88, 17, 17};

        int[] result = deleteDuplicatesFromUnSorted(unsorted);

        System.out.println("Unique array after deleting duplicates: ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    //Returns the number of valid entries after deletion
    public static int[] deleteDuplicatesFromSorted(int[] A) {
        if(A.length == 0) {
            return null;
        }

        int writeIdx = 1;

        for(int i = 1; i < A.length; i++) {
            if(A[i-1] != A[i]) {
                A[writeIdx++] = A[i];
            }
        }

        return Arrays.copyOf(A, writeIdx); // Copy original array to new array till unique element position;
    }

    // Removes duplicates from UNSORTED array,
    // Array can have billions of elements
    // Using byte array to set bit corresponds to the value in original array
    // BitSet table would look like: b represents byte[]
    // 4 => b[0]: 0 0 0 1 0 0 0
    // 3 => b[0]: 0 0 1 0 0 0 0
    // 15 => b[1]: 0 0 0 0 0 1 0
    // 21 => b[2]: 0 0 0 0 1 0 0
    // 88 => b[11]: 0 0 0 0 0 0 1
    public static int[] deleteDuplicatesFromUnSorted(int[] inArr) {

        final int BIT_LENGTH = 8, MAX = 1 << BIT_LENGTH;


        // Get the max positive(UINT max) i.e.4294967294 = 2^32 Then divide by 8 to get number of bytes
        int size = (int)(((long)Integer.MAX_VALUE << 1) / BIT_LENGTH);

        // Then divide by 8 to get number of bytes
        byte[] bitSet = new byte[size]; // Store 8 bit

        int writeIdx = 0;   // Maintains position to replace dup element with unique one

        for (int i = 0; i < inArr.length; i++) {
            int posInBitSet = inArr[i] / BIT_LENGTH; //Get position in BitSet array
            int bitPos = inArr[i] % BIT_LENGTH;  // Get bit to turn ON in BitSet array

            if ((bitSet[posInBitSet] & (1 << bitPos)) == 0) { // Right-shift 256 till bitPos
                bitSet[posInBitSet] ^=  (1 << bitPos);
                inArr[writeIdx++] = inArr[i];
            }
        }
        BitSet bitSet1= new BitSet();
        return Arrays.copyOf(inArr, writeIdx); // Copy original array to new array till unique element position;
    }
}
