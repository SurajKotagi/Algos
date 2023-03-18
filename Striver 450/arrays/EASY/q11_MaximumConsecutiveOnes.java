import java.util.*;
import java.io.*;

public class q11_MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 0, 1, 1, 1, 0, 1, 1 };

        // optimal solution
        // time complexity = O(n);
        // space complexity = O(1);

        int max = 0;
        int cmax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                cmax++;
                max = Math.max(cmax, max);
            } else {
                cmax = 0;
            }
        }
        System.out.println(max);
    }

}