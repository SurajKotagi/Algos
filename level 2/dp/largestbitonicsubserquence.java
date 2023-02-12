import java.io.*;
import java.util.*;

public class largestbitonicsubserquence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // algorithm
        // we have to find largest bitonic subsequnece possile i the array
        // i.e we have to find largeest mountain which can be forned

        // fr=irst we find largest lis for all the elements
        // and then we find lds for all the elements
        // and then ew find the difference of lis lds for aall the elements ib the array
        // maximum value + 1 is the aswer neeeded

        // lis is the array in which we store lis length values fpr all te elements
        int[] dp = new int[n];
        // defaultly lis for first element is 1
        dp[0] = 1;

        int max_lis_of_array = 0;

        // starting the loop form 1 to end
        for (int i = 1; i < n; i++) {

            int max_length_lis_before = -1;
            // we have to check all the elements beofore it (i.2e whether they are less tham
            // the curremt one)
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {// means that we can attach our curremt element to it
                    // we should also check that it has largest length
                    if (dp[j] > max_length_lis_before) {
                        max_length_lis_before = dp[j];
                    }
                }
            }

            if (max_length_lis_before == -1) {// meaning that there is no element smaller before
                dp[i] = 1; // that is itself
            } else {
                dp[i] = max_length_lis_before + 1;
            }

            if (dp[i] > max_lis_of_array)
                max_lis_of_array = dp[i];
        }

        // similarly we have to find lds (note that commentsn may be wrong bcz these are
        // coppied conmmments)

        // lds is the array in which we store lds length values fpr all te elements
        int[] dp2 = new int[n];
        // defaultly lds for last element is 1
        dp2[n - 1] = 1;

        int max_lds_of_array = 0;

        // starting the loop form n-1 to 0
        for (int i = n - 1; i >= 0; i--) {

            int max_length_lds_after = -1;
            // we have to check all the elements affter it (i.2e whether they are less tham
            // the curremt one)
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) { // means that we can attach our curremt element before it

                    // we should also check that it has largest length
                    if (dp2[j] > max_length_lds_after) {
                        max_length_lds_after = dp2[j];
                    }

                }
            }

            if (max_length_lds_after == -1) {// meaning that there is no element smaller before
                dp2[i] = 1; // that is itself
            } else {
                dp2[i] = max_length_lds_after + 1;
            }
            if (dp2[i] > max_lds_of_array)
                max_lds_of_array = dp2[i];
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : dp2) {
            System.out.print(i + " ");
        }

    }

}