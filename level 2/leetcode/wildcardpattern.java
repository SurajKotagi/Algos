public boolean isMatch(String s, String p) {
    // algorithm
    // pattern is taken vertical and string is on horizotal axis
    // ' ' is take on both vertical and horizontal as last character (last row and col are trivial cases) 
    // dp last box is set true as default as ' ' = ' '
    // last column is manages seperately (if * is there in pattern then if the next box vertically down is true then the current spot is also true because the * has unique power to get vanished(mf))
    
    // if the character is not same then false (i.e pattern character and string character)
    // else if the pattern character is ? then check next diagonal box if true then true
    // else if the pattern character is * then 
    //     start can take form of any set of characters so rather than checking every possiblities check vertically down box and horizontally right box if any one is true then current box is true
    
    // else
    //    it means that pattern character is not * or ? and not same as that of strings so directly we can mark false
    
    
    int plen = p.length();
    int slen = s.length();
    boolean[][] dp = new boolean [plen+1][slen+1];
    dp[plen][slen] = true;
    
    for(int i = dp.length-2; i>=0 ; i--){
        if(p.charAt(i) == '*'){
            if(dp[i+1][dp[0].length-1] == true){
                dp[i][dp[0].length-1] = true;
            }
        }
    }
    
    for(int i = dp.length-2; i>=0 ; i--){
        for(int j = dp[0].length-2; j>=0 ; j--){
            char pch = p.charAt(i);
            char sch = s.charAt(j);
            
            if(pch == sch){
                if(dp[i+1][j+1] == true)
                    dp[i][j] = true;
            } else if (pch == '?'){
                if(dp[i+1][j+1] == true)
                    dp[i][j] = true;
            } else if (pch == '*'){
                boolean vanish = dp[i+1][j];
                boolean starset = dp[i][j+1];
                
                dp[i][j] = vanish || starset;
            } else {
                dp[i][j] = false;
            }
        }
    }
}