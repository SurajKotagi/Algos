import java.io.*;
import java.util.*;

public class countofdistictpalindromesinsubsequencce {

    public static int solution(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int[] n = new int[str.length()];
        int[] p = new int[str.length()];

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hm.containsKey(c) == true) {
                int pocc = hm.get(c);
                p[i] = pocc;
            } else {
                p[i] = -1;
            }
            hm.put(c, i);
        }
        hm.clear();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (hm.containsKey(c) == true) {
                int nocc = hm.get(c);
                n[i] = nocc;
            } else {
                n[i] = str.length();
            }
            hm.put(c, i);
        }
        // (c1 != c2) dps(c1m) + dps(mc2) - dps(m);
        // (c1 == c2) there is no c1 in between string 2*dps(m) + 2
        // (c1 == c2) there is one c1 present within string i.e in middle part then
        // 2*dps(m) + 1
        //
        // more than one c1 2*dps(m) - dps(m')

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                char sch = str.charAt(i);
                char ech = str.charAt(j);
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = 2;
                } else {
                    if (sch == ech) {
                        if (n[i] > p[j]) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if (n[i] == p[j]) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else if (n[i] < p[j]) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[n[i] + 1][p[j] - 1];
                        }
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}