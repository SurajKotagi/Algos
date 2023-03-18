import java.util.*;
import java.io.*;

public class q14_LongestSubarrayWithGivenSumBoth {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 1, 2, 3, 1, 1 };
        int k = 3;
        System.out.println(Optimal(arr, k));
    }

    public static int Optimal(int[] arr, int k) {
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (preSumMap.containsKey(sum - k) == true) {
                maxLen = Math.max(maxLen, i - preSumMap.get(sum - k));
            }
            if (preSumMap.containsKey(sum) == false) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
}