class Solution {
    public boolean isMatch(String s, String p) {
        int plen = p.length(); // note: indexing of regexp in dp is 1 greater than that of string dp[1] matches
                               // to string [0]
        int slen = s.length(); // note: indexing of regexp in dp is 1 greater than that of string dp[1] matches
                               // to string [0]
        boolean[][] dp = new boolean[plen + 1][slen + 1];
        dp[0][0] = true;
        // setting up the first column
        for (int i = 2; i < dp.length; i++) {
            if (p.charAt(i - 1) == '*') {
                if (dp[i - 2][0] == true) {
                    dp[i][0] = true;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char regch = p.charAt(i - 1);
                char sch = s.charAt(j - 1);

                if (regch == sch) {
                    if (dp[i - 1][j - 1] == true) {
                        dp[i][j] = true;
                    }
                } else if (regch == '.') {
                    if (dp[i - 1][j - 1] == true) {
                        dp[i][j] = true;
                    }
                } else if (regch == '*') {
                    if (p.charAt(i - 2) != '.') {
                        if (p.charAt(i - 2) == sch) {
                            boolean left1 = dp[i][j - 1];
                            boolean up2 = dp[i - 2][j];
                            dp[i][j] = up2 | left1;
                        } else {
                            dp[i][j] = dp[i - 2][j];
                        }
                    } else if (p.charAt(i - 2) == '.') {
                        boolean left1 = dp[i][j - 1];
                        boolean up2 = dp[i - 2][j];
                        dp[i][j] = up2 | left1;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[plen][slen];
    }
}