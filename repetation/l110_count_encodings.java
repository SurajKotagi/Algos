import java.util.*;
import java.io.*;

public class l110_count_encodings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (dp[i - 1] == -1) {
                dp[i] = -1;
            } else if (s.charAt(i - 1) == '0') {
                if (s.charAt(i) != '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = -1;
                }
            } else {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26
                        && Integer.parseInt(s.substring(i - 1, i + 1)) >= 10) {
                    if (s.charAt(i) != '0') {
                        dp[i] = dp[i - 1] + 1;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else if (s.charAt(i) != '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = -1;
                }
            }
        }
        System.out.println((dp[s.length() - 1]) < 0 ? 0 : dp[s.length() - 1]);
    }
}