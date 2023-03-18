import java.util.*;
import java.io.*;

public class q12_FindTHeNumberThatAppearsOnce {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 2, 2, 3, 4, 4 };

        System.out.println(Brute(arr));
        System.out.println(Better(arr));
        System.out.println(Optimal(arr));
    }

    // Brute
    // time complexity -> O(n^2)
    // space complexity -> O(1)
    public static int Brute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    cnt++;
            }
            if (cnt == 1)
                return arr[i];
        }
        return 69;
    }

    // Better
    // time complexity -> O(2n)
    // space complexity -> O(k)

    public static int Better(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : hm.keySet()) {
            if (hm.get(key) == 1)
                return key;
        }
        return 69;
    }

    public static int Optimal(int[] arr) {
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
}