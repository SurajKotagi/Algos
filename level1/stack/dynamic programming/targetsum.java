import java.io.*;
import java.util.*;

public class targetsum {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int target_sum = scn.nextInt();

        // 2 3 5
        // 0 1 2 3 4 5 6 7

        int[] dp = new int[target_sum + 1];

        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            // iterating through columns for particular value
            for (int j = val; j <= target_sum; j++) {
                if (val == j) {
                    dp[j]++;
                } else {
                    // if j = 3 and val is 2 then 3 - 2 is 1, there should be combinations possible
                    // to get sum as 1
                    if (dp[j - val] > 0) {
                        dp[j] += dp[j - val];
                    }
                }
            }
        }
        System.out.println(dp[target_sum]);
    }
}