import java.io.*;
import java.util.*;

public class targetsumpermu {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        // 2 3 5
        // 0 1 2 3 4 5 6 7

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int j = 1; j <= target; j++) {
            // every spot has to be checked with all the vals of array
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                if (j >= val) {
                    count = count + dp[j - val];
                }
            }
            dp[j] = count;
        }

        System.out.println(dp[target]);
    }
}