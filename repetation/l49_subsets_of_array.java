import java.util.*;
import java.io.*;

public class l49_subsets_of_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // method 1

        for (int i = 0; i < Math.pow(2, n); i++) {
            String s = Integer.toBinaryString(i);
            int slen = s.length();
            for (int j = 0; j < n - slen; j++) {
                System.out.print("-\t");
            }
            for (int j = 0; j < slen; j++) {
                if (s.charAt(j) == '0') {
                    System.out.print("-\t");
                } else {
                    System.out.print(arr[n - slen + j] + "\t");
                }
            }
            System.out.println();
        }
    }
}