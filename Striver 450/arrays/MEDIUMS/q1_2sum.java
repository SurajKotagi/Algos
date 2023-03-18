import java.util.*;
import java.io.*;

public class q1_2sum {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 7, 11, 15 };
        int[] res = new int[2];

        res = Brute(arr, 9);
        disp(res);
        res = Better(arr, 9);
        disp(res);
    }

    public static void disp(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    // Brute | TC -> O(n²) | SC -> O(1);
    public static int[] Brute(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 0, 0 };
    }

    // Better
    public static int[] Better(int[] arr, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(target - arr[i]) == true) {
                return new int[] { hm.get(target - arr[i]), i };
            } else {
                hm.put(arr[i], i);
            }
        }
        return new int[] {};
    }
}