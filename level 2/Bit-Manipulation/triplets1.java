import java.io.*;
import java.util.*;

public class triplets1 {

    public static void solution(int[] arr) {
        // 1. You are given an array(arr) of N numbers.
        // 2. You have to select three indices i,j,k following this condition ->
        // i.e 0 <= i < j <= k < arr.length
        // 3. Two numbers X and Y as defined as :
        // X = arr[i] ^ arr[i+1] ^ ... ^ arr[j - 1]
        // Y = arr[j] ^ arr[j+1] ^ ... ^ arr[k]
        // 4. You have to print the number of triplets where X is equal to Y.

        // basically we have to print count of all possble triplets whose xor is 0(i.e
        // same elemts cancel out)

        int i = 0;
        int j = 0;
        int k = 0;

        int triplet_count = 0;

        for (int a = 0; a < arr.length; a++) {
            int xor = arr[a];
            for (int b = a + 1; b < arr.length; b++) {
                xor = xor ^ arr[b];
                if (xor == 0) {
                    i = a;
                    k = b;
                    triplet_count += (k - i);
                }
            }
        }
        System.out.println(triplet_count);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

}