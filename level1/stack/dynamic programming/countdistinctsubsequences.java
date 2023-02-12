import java.util.*;

public class countdistinctsubsequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        HashMap<Character, Integer> hm = new HashMap<>();
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch) == true) {
                Long prev_dp = dp[hm.get(ch)];
                dp[i + 1] = (dp[i] * 2) - prev_dp;
            } else {
                dp[i + 1] = dp[i] * 2;
            }
            hm.put(ch, i);
        }
        // to print non empty we need to -1 the empty subsequence count
        System.out.println(dp[str.length()] - 1);
    }
}