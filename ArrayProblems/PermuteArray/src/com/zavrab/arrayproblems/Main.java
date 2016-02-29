package com.zavrab.arrayproblems;

public class Main {

    public static void main(String[] args) {
        Character[] s = new Character[] {'a', 'b', 'c', 'd'};
        int[] permutes = new int[] {3, 2, 0, 1};

        permuteArray(permutes, s);
        for (Character c: s) {
            System.out.print(c + " ");
        }
    }

    public static void permuteArray(int[] p, Character[] s) {
        int n = s.length;
        for (int i = 0; i < n; i++) {
            //Check if element at index i has not been moved by checking if  p[i] is nonnegetive.
            int next = i;
            while (p[next] >= 0) {
                swap(s, i, p[next]);
                int temp =  p[next];

                //Substract length n from an entry in permute array to make it negetive.
                //which indicates the corresponding element has been moved.
                p[next] = next - n;
                next = temp;
            }
        }
    }

    private static void swap(Character[] s, int f, int t) {
        char temp = s[f];
        s[f] = s[t];
        s[t] = temp;
    }
}
