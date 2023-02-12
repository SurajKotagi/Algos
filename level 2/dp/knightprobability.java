class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        if(k == 1) return 1.00000;
        double [][] dp = new double [n][n];
        
        if(r-2>=0 && c+1<n){
            dp[r-2][c+1] = (dp[r-2][c+1] == 0) ? 1/8 : dp[r-2][c+1] * 1/8;  
        } 

        if(r-1>=0 && c+2<n){
            dp[r-1][c+2] = (dp[r-1][c+2] == 0) ? 1/8 : dp[r-1][c+2] * 1/8;
        } 

        if(r+1<n && c+2<n) {
            dp[r+1][c+2] = (dp[r+1][c+2] == 0) ? 1/8 : dp[r+1][c+2] * 1/8;
        }

        if(r+2<n && c+1<n) {
            dp[r+2][c+1] = (dp[r+2][c+1] == 0) ? 1/8 : dp[r+2][c+1] * 1/8;
        }

        if(r+2<n && c-1>=0) {
            dp[r+2][c-1] = (dp[r+2][c-1] == 0) ? 1/8 : dp[r+2][c-1] * 1/8;
        }

        if (r + 1 < n && j - 2 >= 0)
        {
            dp[r + 1][c - 2] = (dp[r + 1][c - 2] == 0) ? 1 / 8 : dp[r + 1][c - 2] * 1 / 8;
        }    

        if (r - 1 >= 0 && c - 2 >= 0)
        {
            dp[r - 1][c - 2] = (dp[r - 1][c - 2] == 0) ? 1 / 8 : dp[r - 1][c - 2] * 1 / 8;
        }    

        if (r - 2 >= 0 && c - 1 >= 0)
        {
            dp[r - 2][c - 1] = (dp[r - 2][c - 1] == 0) ? 1 / 8 : dp[r - 2][c c 1] * 1 / 8;
        } 
        k--;
        while(k != 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dp[i][j] > 0){
                        
                        if(i-2>=0 && j+1<n){
                            dp[i-2][j+1] = (dp[i-2][j+1] == 0) ? 1/8 : dp[i-2][j+1] * 1/8;  
                        } 
                        
                        if(i-1>=0 && j+2<n){
                            dp[i-1][j+2] = (dp[i-1][j+2] == 0) ? 1/8 : dp[i-1][j+2] * 1/8;
                        } 
                        
                        if(i+1<n && j+2<n) {
                            dp[i+1][j+2] = (dp[i+1][j+2] == 0) ? 1/8 : dp[i+1][j+2] * 1/8;
                        }
                        
                        if(i+2<n && j+1<n) {
                            dp[i+2][j+1] = (dp[i+2][j+1] == 0) ? 1/8 : dp[i+2][j+1] * 1/8;
                        }
                        
                        if(i+2<n && j-1>=0) {
                            dp[i+2][j-1] = (dp[i+2][j-1] == 0) ? 1/8 : dp[i+2][j-1] * 1/8;
                        }
                        
                        if (i + 1 < n && j - 2 >= 0)
                        {
                            dp[i + 1][j - 2] = (dp[i + 1][j - 2] == 0) ? 1 / 8 : dp[i + 1][j - 2] * 1 / 8;
                        }    

                        if (i - 1 >= 0 && j - 2 >= 0)
                        {
                            dp[i - 1][j - 2] = (dp[i - 1][j - 2] == 0) ? 1 / 8 : dp[i - 1][j - 2] * 1 / 8;
                        }    

                        if (i - 2 >= 0 && j - 1 >= 0)
                        {
                            dp[i - 2][j - 1] = (dp[i - 2][j - 1] == 0) ? 1 / 8 : dp[i - 2][j - 1] * 1 / 8;
                        } 
                    }
                }
            }
            k--;
        }
        double max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                max += dp[i][j];
            }
        }
        return max;
    }
}