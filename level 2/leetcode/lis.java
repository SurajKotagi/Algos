// leetcode 300
class Solution {
    public int lengthOfLIS(int[] nums) {

        int lastcol = nums.length - 1;
        int[] dp = new int[lastcol + 1];

        // what is stored? longest increasing subsequence (count) which is ending at
        // that element*

        // algorithm in short
        // you have to find longest increasing subsequence possible for every index
        // for 0 th index element it is 1 (default)
        // so you have to find the lis for elements from 1 to n-1

        // lets say starting 3 elements are 2 3 4
        // for 2 lis possible is 1
        // to find lis of 3 --> we have to check all the elements before 3
        // if the elements before 3 is smaller than 3 then we can form incerasing
        // subsewquence by appending it after thge smaller elemnet
        // in that also we have to find largest so we have to attach curremt element to
        // the largest increasing sequence oresent before it

        // as the lis for 1st element is defaultly 1
        dp[0] = 1;

        int max_lis_in_array = 1;

        // findung lis for all elements from index 1 to so on
        for (int i = 1; i <= lastcol; i++) {

            // max behind indicates largest lis count value present before the current
            // element
            int max_behind = -1;

            // cheching all the elements fron starting to the current element
            for (int j = 0; j < i; j++) {

                // if value at index j is less them it ,eas that we can attach our current
                // element next to it
                // but we also have to check that we are forming largest increasing subsequence
                if (nums[j] < nums[i]) {
                    // if our currently valid check if increasing subsequenve which will formed is
                    // larger than the one that was getting formed befir then we update that value
                    if (dp[j] > max_behind) {
                        max_behind = dp[j];
                    }
                }
            }

            // after iterating throgh all the elements also stiull your value of max lis
            // before is -1 then it ,eas\ns that there is no smaller element present befire
            // the current element
            if (max_behind == -1) {
                dp[i] = 1;
            } else {
                // if we found the maximum value of lis before the current element to which w
                // can bind tghe current elemnet then with previous lis wwe have add the ciunt
                // of current element also
                dp[i] = max_behind + 1;
            }
            // we are finduing lis for all tthe elements on array , we have to find largest
            // incressing subsequence for while array so we are updating max
            max_lis_in_array = Math.max(max_lis_in_array, dp[i]);
        }
        return max_lis_in_array;
    }
}