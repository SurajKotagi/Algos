import java.util.*;
import java.io.*;

public class l104_coin_change_permutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();

        // the intution is not that string solbve more problems like this - suggestion
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        for (int i = 1; i <= amt; i++) {
            for (int j = 0; j < n; j++) {
                dp[i] += (i - arr[j] >= 0) ? dp[i - arr[j]] : 0;
            }
        }
        System.out.println(dp[amt]);
    }
}