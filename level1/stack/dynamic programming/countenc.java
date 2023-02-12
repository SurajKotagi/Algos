import java.io.*;
import java.util.*;

public class countenc {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String n = scn.next();

        int[] dp = new int[n.length()];

        dp[0] = 1;

        for (int i = 1; i < n.length(); i++) {
            if (n.charAt(i) == '0' && n.charAt(i - 1) == '0') {
                dp[i] = 0;
            } else if (n.charAt(i) == '0' && n.charAt(i - 1) != '0') {
                if (n.charAt(i - 1) == '1' || n.charAt(i - 1) == '2') {
                    dp[i] = (i - 2 < 0) ? 1 : dp[i - 2];
                }
            } else if (n.charAt(i - 1) == '0' && n.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else {
                // System.out.println(i);
                dp[i] = dp[i - 1];
                if (Integer.parseInt(n.substring(i - 1, i + 1)) <= 26) {
                    dp[i] += (i - 2 < 0) ? 1 : dp[i - 2];
                }
            }
        }
        // for(int i : dp){
        // System.out.print(i + " ");
        // }
        System.out.println(dp[n.length() - 1]);
    }
}